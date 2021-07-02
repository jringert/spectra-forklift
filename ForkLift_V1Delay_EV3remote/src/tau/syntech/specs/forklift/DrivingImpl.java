package tau.syntech.specs.forklift;

import java.rmi.RemoteException;

import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

/**
 * An implementation for driving the forklift around based on two motors.
 * 
 * @author ringert
 *
 */
public class DrivingImpl {

	/**
	 * A definition of step size in degrees of the motor
	 */
	private final int STEP = 210;

	private RMIRegulatedMotor mLeft;
	private RMIRegulatedMotor mRight;

	public DrivingImpl(RemoteEV3 ev3, String portLeft, String portRight) {
		mLeft = init(ev3, portLeft);
		mRight = init(ev3, portRight);
	}

	/**
	 * go a few cm forward
	 * 
	 * @throws RemoteException
	 */
	public void forward() throws RemoteException {
		mLeft.rotate(STEP, true);
		mRight.rotate(STEP);
	}

	/**
	 * go a few cm backward
	 * 
	 * @throws RemoteException
	 */
	public void backward() throws RemoteException {
		mLeft.rotate(-STEP, true);
		mRight.rotate(-STEP);
	}

	/**
	 * turn 90 degrees left
	 * 
	 * @throws RemoteException
	 */
	public void left() throws RemoteException {
		mLeft.rotate(-STEP, true);
		mRight.rotate(STEP);
	}

	/**
	 * turn 90 degrees right
	 * 
	 * @throws RemoteException
	 */
	public void right() throws RemoteException {
		mLeft.rotate(STEP, true);
		mRight.rotate(-STEP);
	}

	/**
	 * initialize a motor on the given port, e.g., "A" or "B"
	 * 
	 * @param port
	 * @return
	 */
	private RMIRegulatedMotor init(RemoteEV3 ev3, String port) {
		RMIRegulatedMotor m = ev3.createRegulatedMotor(port, 'L');
		try {
			m.setSpeed(200);
			m.resetTachoCount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	/**
	 * close the connection to the motors to not block them
	 * 
	 * @throws RemoteException
	 */
	protected void close() throws RemoteException {
		mLeft.close();
		mRight.close();
	}
}
