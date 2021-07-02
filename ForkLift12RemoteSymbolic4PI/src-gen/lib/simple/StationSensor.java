package lib.simple;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import java.lang.Boolean;
import lejos.nxt.SensorPort;
public abstract class StationSensor implements Component {
  protected Port<Boolean> sense;
  public Port<Boolean> getPort_sense(){
    return this.sense;
  }
  public SensorPort sp;
  public StationSensor(  SensorPort sp){
    this.sp=sp;
  }
  public void init(){
  }
  public void setUp(){
    this.sense=new Port<Boolean>();
  }
  public void update(){
    this.sense.update();
  }
}

