package lib.simple;
import lejos.nxt.remote.RemoteMotor;
public class MotorFactory {
  private static MotorFactory instance;
  public static void setInstance(  MotorFactory factory){
    instance=factory;
  }
  public static Motor create(  RemoteMotor m){
    if (instance == null)     instance=new MotorFactory();
    return instance.doCreate(m);
  }
  protected Motor doCreate(  RemoteMotor m){
    return new MotorImpl(m);
  }
}

