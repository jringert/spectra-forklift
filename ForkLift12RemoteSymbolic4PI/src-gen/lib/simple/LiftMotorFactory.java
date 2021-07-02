package lib.simple;
import lejos.nxt.remote.RemoteMotor;
public class LiftMotorFactory {
  private static LiftMotorFactory instance;
  public static void setInstance(  LiftMotorFactory factory){
    instance=factory;
  }
  public static LiftMotor create(  RemoteMotor m){
    if (instance == null)     instance=new LiftMotorFactory();
    return instance.doCreate(m);
  }
  protected LiftMotor doCreate(  RemoteMotor m){
    return new LiftMotorImpl(m);
  }
}

