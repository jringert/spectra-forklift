package lib.simple;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import java.lang.Boolean;
import lejos.nxt.SensorPort;
public abstract class Button implements Component {
  protected Port<Boolean> pressed;
  public Port<Boolean> getPort_pressed(){
    return this.pressed;
  }
  public SensorPort sp;
  public Button(  SensorPort sp){
    this.sp=sp;
  }
  public void init(){
  }
  public void setUp(){
    this.pressed=new Port<Boolean>();
  }
  public void update(){
    this.pressed.update();
  }
}

