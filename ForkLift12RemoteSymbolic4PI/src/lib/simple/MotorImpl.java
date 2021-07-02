package lib.simple;

import lejos.nxt.remote.RemoteMotor;

public class MotorImpl extends Motor {

  RemoteMotor motor;

  public MotorImpl(RemoteMotor m) {
    super(m);
    motor = m;
    motor.setAcceleration(10);
    motor.setPower(15);
    motor.resetTachoCount();
  }

  @Override
  public void compute() {

    if (cmd.getNextValue() != null) {
      switch (cmd.getNextValue()) {
      case STOP:
        motor.stop(true);
        break;
      case BWD:
        motor.stop(true);
        motor.backward();
        break;
      case FWD:
        motor.stop(true);
        motor.forward();
        break;

      }
    }
  }
}
