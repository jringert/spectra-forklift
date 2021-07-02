package lib.simple;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lib.simple.MotorCmd;
import lejos.nxt.remote.RemoteMotor;
public abstract class Motor implements Component {
  protected Port<MotorCmd> cmd;
  public void setPort_cmd(  Port<MotorCmd> cmd){
    this.cmd=cmd;
  }
  public RemoteMotor m;
  public Motor(  RemoteMotor m){
    this.m=m;
  }
  public void init(){
  }
  public void setUp(){
  }
  public void update(){
  }
}

