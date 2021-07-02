package lib.simple;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lib.simple.LiftCmd;
import java.lang.Boolean;
import lejos.nxt.remote.RemoteMotor;
public abstract class LiftMotor implements Component {
  protected Port<LiftCmd> cmd;
  public void setPort_cmd(  Port<LiftCmd> cmd){
    this.cmd=cmd;
  }
  protected Port<Boolean> ack;
  public Port<Boolean> getPort_ack(){
    return this.ack;
  }
  public RemoteMotor m;
  public LiftMotor(  RemoteMotor m){
    this.m=m;
  }
  public void init(){
  }
  public void setUp(){
    this.ack=new Port<Boolean>();
  }
  public void update(){
    this.ack.update();
  }
}

