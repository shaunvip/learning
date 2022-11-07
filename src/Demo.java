@FunctionalInterface
public interface Demo {
    abstract void  show();
    default void  print(){
        System.out.println("Hellow");
    }
}
