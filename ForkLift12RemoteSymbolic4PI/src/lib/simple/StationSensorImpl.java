package lib.simple;

import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.Color;

public class StationSensorImpl extends StationSensor {

  ColorSensor sensor;

  public StationSensorImpl(SensorPort sp) {
    super(sp);
    sensor = new ColorSensor(sp);
    sensor.setFloodlight(Color.BLUE);
  }

  @Override
  public void init() {
  };

  @Override
  public void compute() {
    if (sensor.getRawLightValue() < 200) {
      sense.setCurrentValue(true); 
    } else {
      sense.setCurrentValue(false);
    }
  }

}
