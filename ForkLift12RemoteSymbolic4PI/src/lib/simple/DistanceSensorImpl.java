package lib.simple;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class DistanceSensorImpl extends DistanceSensor {

  UltrasonicSensor sensor;
  int cm;

  public DistanceSensorImpl(SensorPort sp, int cm) {
    super(sp, cm);
    this.cm = cm;
    sensor = new UltrasonicSensor(sp);
    sensor.continuous();
  }

  @Override
  public void init() {
    compute();
  };

  @Override
  public void compute() {
    if (sensor.getDistance() < cm) {
      sense.setCurrentValue(Distance.BLOCKED);
    } else {
      sense.setCurrentValue(Distance.CLEAR);
    }
  }

}
