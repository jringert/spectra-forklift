package lib.simple;
import lejos.nxt.SensorPort;
import java.lang.Integer;
public class DistanceSensorFactory {
  private static DistanceSensorFactory instance;
  public static void setInstance(  DistanceSensorFactory factory){
    instance=factory;
  }
  public static DistanceSensor create(  SensorPort sp,  Integer cm){
    if (instance == null)     instance=new DistanceSensorFactory();
    return instance.doCreate(sp,cm);
  }
  protected DistanceSensor doCreate(  SensorPort sp,  Integer cm){
    return new DistanceSensorImpl(sp,cm);
  }
}

