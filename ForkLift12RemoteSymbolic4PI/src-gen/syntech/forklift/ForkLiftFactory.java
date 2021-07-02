package syntech.forklift;
public class ForkLiftFactory {
  private static ForkLiftFactory instance;
  public static void setInstance(  ForkLiftFactory factory){
    instance=factory;
  }
  public static ForkLift create(){
    if (instance == null)     instance=new ForkLiftFactory();
    return instance.doCreate();
  }
  protected ForkLift doCreate(){
    return new ForkLift();
  }
}

