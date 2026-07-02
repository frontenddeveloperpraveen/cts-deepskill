import java.lang.reflect.Method;

class Sample {
  public void sayHello(String name) {
    System.out.println("Hello, " + name + "!");
  }
}

public class ReflectionDemo {
  public static void main(String[] args) throws Exception {
    Class<?> cls = Class.forName("Sample");
    Object obj = cls.getDeclaredConstructor().newInstance();
    Method[] methods = cls.getDeclaredMethods();
    for (Method m : methods) {
      System.out.println("Method: " + m.getName());
      for (Class<?> p : m.getParameterTypes()) {
        System.out.println("  Param: " + p.getName());
      }
    }
    Method m = cls.getMethod("sayHello", String.class);
    m.invoke(obj, "Reflection");
  }
}
