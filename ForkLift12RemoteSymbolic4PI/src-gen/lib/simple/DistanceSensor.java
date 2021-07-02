package lib.simple;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lib.simple.Distance;
import lejos.nxt.SensorPort;
import java.lang.Integer;
public abstract class DistanceSensor implements Component {
  protected Port<Distance> sense;
  public Port<Distance> getPort_sense(){
    return this.sense;
  }
  public SensorPort sp;
  public Integer cm;
  public DistanceSensor(  SensorPort sp,  Integer cm){
    this.sp=sp;
    this.cm=cm;
  }
  public void init(){
  }
  public void setUp(){
    this.sense=new Port<Distance>();
  }
  public void update(){
    this.sense.update();
  }
}

