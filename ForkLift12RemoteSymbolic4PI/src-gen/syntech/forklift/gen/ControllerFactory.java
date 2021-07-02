package syntech.forklift.gen;
public class ControllerFactory {
  private static ControllerFactory instance;
  public static void setInstance(  ControllerFactory factory){
    instance=factory;
  }
  public static Controller create(){
    if (instance == null)     instance=new ControllerFactory();
    return instance.doCreate();
  }
  protected Controller doCreate(){
    return new Controller();
  }
}

