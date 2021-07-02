package tau.syntech.specs.forklift;

import java.util.HashMap;
import java.util.Map;

import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RMISampleProvider;
import lejos.remote.ev3.RemoteEV3;
import tau.smlab.syntech.controller.executor.ControllerExecutor;
import tau.smlab.syntech.controller.jit.BasicJitController;

/**
 * A main class that connects to the forklift, sets up sensors and motors, and
 * gives basic controls for moving the forklift.
 * 
 * @author ringert
 *
 */
public class ForkLift {

	private static final int STEP = 210;

	public static void main(String[] args) throws Throwable {

		// connect to brick
		RemoteEV3 ev3 = new RemoteEV3("10.0.1.1");
		ev3.setDefault();

		RMISampleProvider sense = ev3.createSampleProvider("S2", "lejos.hardware.sensor.EV3UltrasonicSensor",
				"Distance");
		RMISampleProvider cargo = ev3.createSampleProvider("S4", "lejos.hardware.sensor.EV3UltrasonicSensor",
				"Distance");
		RMISampleProvider emgOff = ev3.createSampleProvider("S3", "lejos.hardware.sensor.EV3TouchSensor", "Touch");
		RMISampleProvider station = ev3.createSampleProvider("S1", "lejos.hardware.sensor.EV3ColorSensor", "Red");

		RMIRegulatedMotor mLeft = ev3.createRegulatedMotor("B", 'L');
		mLeft.setSpeed(200);
		mLeft.resetTachoCount();
		RMIRegulatedMotor mRight = ev3.createRegulatedMotor("C", 'L');
		mRight.setSpeed(200);
		mRight.resetTachoCount();

		// Instantiate a new controller executor
		ControllerExecutor executor = new ControllerExecutor(new BasicJitController(), "out/");

		Map<String, String> inputs = new HashMap<>();
		boolean iniState = true;
		while (true) {
			inputs.clear();

			String cargoVal = (cargo.fetchSample()[0] * 100 < 10)?"BLOCKED":"CLEAR";
			String senseVal = (sense.fetchSample()[0] * 100 < 30)?"BLOCKED":"CLEAR";
			
			// collect inputs for controller
			inputs.put("cargo", cargoVal);
			inputs.put("sense", senseVal);
			inputs.put("emgOff", Boolean.toString(emgOff.fetchSample()[0] > .5));
			inputs.put("station", Boolean.toString(station.fetchSample()[0] > .5));

			System.out.println(inputs);

			// execute controller
			if (iniState) {
				executor.initState(inputs);
				iniState = false;
			} else {
				executor.updateState(inputs);
			}

			// send outputs to motors
			String mLeftVal = executor.getCurrValue("mLeft");
			if ("FWD".equals(mLeftVal)) {
				mLeft.rotate(STEP, true);
			} else if ("BWD".equals(mLeftVal)) {
				mLeft.rotate(-STEP, true);
			}
			String mRightVal = executor.getCurrValue("mRight");
			if ("FWD".equals(mRightVal)) {
				mRight.rotate(STEP, true);
			} else if ("BWD".equals(mRightVal)) {
				mRight.rotate(-STEP, true);
			}
			// TODO do the lifting stuff

			Thread.sleep(2000);
		}

		// The sensors should be closed, but we run forever...
//		sense.close();
//		cargo.close();
//		emgOff.close();
//		station.close();
	}
}
