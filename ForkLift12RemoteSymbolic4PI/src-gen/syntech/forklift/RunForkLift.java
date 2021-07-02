package syntech.forklift;
public class RunForkLift {
  public static void main(  String[] args){
    ForkLift cmp=ForkLiftFactory.create();
    cmp.setUp();
    cmp.init();
    while (true) {
      cmp.compute();
      cmp.update();
    }
  }
}

