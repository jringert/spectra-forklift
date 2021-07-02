package syntech.forklift;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import lib.simple.LiftMotor;
import lib.simple.LiftMotorFactory;
import lib.simple.StationSensor;
import lib.simple.StationSensorFactory;
import lib.simple.DistanceSensor;
import lib.simple.DistanceSensorFactory;
import lib.simple.Button;
import lib.simple.ButtonFactory;
import syntech.forklift.gen.Controller;
import syntech.forklift.gen.ControllerFactory;
import lib.simple.Motor;
import lib.simple.MotorFactory;
public class ForkLift implements Component {
  public ForkLift(){
  }
  public LiftMotor mLift;
  public StationSensor stationSense;
  public DistanceSensor distSense;
  public Button emgOffButton;
  public DistanceSensor cargoSense;
  public Controller controller;
  public Motor mLeft;
  public Motor mRight;
  public void init(){
    this.controller.setPort_station(this.stationSense.getPort_sense());
    this.controller.setPort_sense(this.distSense.getPort_sense());
    this.controller.setPort_emgOff(this.emgOffButton.getPort_pressed());
    this.controller.setPort_cargo(this.cargoSense.getPort_sense());
    this.controller.setPort_liftAck(this.mLift.getPort_ack());
    this.mLift.setPort_cmd(this.controller.getPort_lift());
    this.mLeft.setPort_cmd(this.controller.getPort_mLeft());
    this.mRight.setPort_cmd(this.controller.getPort_mRight());
    mLift.init();
    stationSense.init();
    distSense.init();
    emgOffButton.init();
    cargoSense.init();
    controller.init();
    mLeft.init();
    mRight.init();
  }
  public void setUp(){
    mLift=LiftMotorFactory.create(lejos.nxt.Motor.A);
    mLift.setUp();
    stationSense=StationSensorFactory.create(lejos.nxt.SensorPort.S1);
    stationSense.setUp();
    distSense=DistanceSensorFactory.create(lejos.nxt.SensorPort.S2,20);
    distSense.setUp();
    emgOffButton=ButtonFactory.create(lejos.nxt.SensorPort.S3);
    emgOffButton.setUp();
    cargoSense=DistanceSensorFactory.create(lejos.nxt.SensorPort.S4,9);
    cargoSense.setUp();
    controller=ControllerFactory.create();
    controller.setUp();
    mLeft=MotorFactory.create(lejos.nxt.Motor.B);
    mLeft.setUp();
    mRight=MotorFactory.create(lejos.nxt.Motor.C);
    mRight.setUp();
  }
  public void compute(){
    mLift.compute();
    stationSense.compute();
    distSense.compute();
    emgOffButton.compute();
    cargoSense.compute();
    controller.compute();
    mLeft.compute();
    mRight.compute();
  }
  public void update(){
    mLift.update();
    stationSense.update();
    distSense.update();
    emgOffButton.update();
    cargoSense.update();
    controller.update();
    mLeft.update();
    mRight.update();
  }
}

