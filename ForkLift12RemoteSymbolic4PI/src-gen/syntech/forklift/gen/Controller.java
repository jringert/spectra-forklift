package syntech.forklift.gen;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import misc.SymbolicControllerRunner;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lib.simple.Distance;
import java.lang.Boolean;
import lib.simple.MotorCmd;
import lib.simple.LiftCmd;
public class Controller implements Component {
  protected Port<Distance> sense;
  public void setPort_sense(  Port<Distance> sense){
    this.sense=sense;
  }
  protected Port<Distance> cargo;
  public void setPort_cargo(  Port<Distance> cargo){
    this.cargo=cargo;
  }
  protected Port<Boolean> station;
  public void setPort_station(  Port<Boolean> station){
    this.station=station;
  }
  protected Port<Boolean> emgOff;
  public void setPort_emgOff(  Port<Boolean> emgOff){
    this.emgOff=emgOff;
  }
  protected Port<Boolean> liftAck;
  public void setPort_liftAck(  Port<Boolean> liftAck){
    this.liftAck=liftAck;
  }
  protected Port<MotorCmd> mLeft;
  public Port<MotorCmd> getPort_mLeft(){
    return this.mLeft;
  }
  protected Port<MotorCmd> mRight;
  public Port<MotorCmd> getPort_mRight(){
    return this.mRight;
  }
  protected Port<LiftCmd> lift;
  public Port<LiftCmd> getPort_lift(){
    return this.lift;
  }
  protected SymbolicControllerRunner ctrl;
  public Controller(){
  }
  public void init(){
    this.ctrl=new SymbolicControllerRunner();
    this.ctrl.addInputPort("sense",this.sense);
    this.ctrl.addInputPort("cargo",this.cargo);
    this.ctrl.addInputPort("station",this.station);
    this.ctrl.addInputPort("emgOff",this.emgOff);
    this.ctrl.addInputPort("liftAck",this.liftAck);
    this.ctrl.addOutputPort("mLeft",MotorCmd.class,this.mLeft);
    this.ctrl.addOutputPort("mRight",MotorCmd.class,this.mRight);
    this.ctrl.addOutputPort("lift",LiftCmd.class,this.lift);
    this.ctrl.init();
  }
  public void setUp(){
    this.mLeft=new Port<MotorCmd>();
    this.mRight=new Port<MotorCmd>();
    this.lift=new Port<LiftCmd>();
  }
  public void compute(){
    this.ctrl.compute();
  }
  public void update(){
    this.mLeft.update();
    this.mRight.update();
    this.lift.update();
  }
}

