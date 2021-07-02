package lib.simple;
import lejos.nxt.SensorPort;
public class StationSensorFactory {
  private static StationSensorFactory instance;
  public static void setInstance(  StationSensorFactory factory){
    instance=factory;
  }
  public static StationSensor create(  SensorPort sp){
    if (instance == null)     instance=new StationSensorFactory();
    return instance.doCreate(sp);
  }
  protected StationSensor doCreate(  SensorPort sp){
    return new StationSensorImpl(sp);
  }
}

