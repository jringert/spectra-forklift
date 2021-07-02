package lib.simple;

import lejos.nxt.remote.RemoteMotor;

public class LiftMotorImpl extends LiftMotor {

  RemoteMotor motor;
  boolean working;

  public LiftMotorImpl(RemoteMotor m) {
    super(m);
    motor = m;
    motor.setAcceleration(500);
    motor.resetTachoCount();
    working = false;
  }

  @Override
  public void compute() {
    if (cmd.getNextValue() != null) {
      switch (cmd.getNextValue()) {
      case DROP:
        motor.rotateTo(0, true);
        working = true;
        break;
      case LIFT:
        motor.rotateTo(600, true);
        working = true;
        break;
      case NIL:
        break;
      }
    }

    boolean atDonePos = true;
    try {
    	atDonePos = !motor.isMoving()
    			&& (motor.getTachoCount() == 0 || motor.getTachoCount() == 600);
    } catch (Exception e) {
    	e.printStackTrace();
	}
    if (working && atDonePos) {
      ack.setCurrentValue(true);
      working = false;
    } else {
      ack.setCurrentValue(false);
    }
  }

}
