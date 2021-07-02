package lib.simple;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class ButtonImpl extends Button {

  TouchSensor sense;

  public ButtonImpl(SensorPort sp) {
    super(sp);
    sense = new TouchSensor(sp);
  }

  @Override
  public void init() {
    compute();
  };

  @Override
  public void compute() {
    pressed.setCurrentValue(sense.isPressed());
  }

}
