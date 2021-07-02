package lib.simple;
import lejos.nxt.SensorPort;
public class ButtonFactory {
  private static ButtonFactory instance;
  public static void setInstance(  ButtonFactory factory){
    instance=factory;
  }
  public static Button create(  SensorPort sp){
    if (instance == null)     instance=new ButtonFactory();
    return instance.doCreate(sp);
  }
  protected Button doCreate(  SensorPort sp){
    return new ButtonImpl(sp);
  }
}

