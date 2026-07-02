// 1. Compile: javac DecompileDemo.java
// 2. Open DecompileDemo.class in JD-GUI or CFR decompiler
// 3. The decompiler will reconstruct Java source from bytecode
//
// JD-GUI: https://java-decompiler.github.io/
// CFR: https://github.com/leibnitz/cfr

public class DecompileDemo {
  private String secret = "hidden";

  public String greet(String name) {
    return "Hello " + name + "!";
  }

  public static void main(String[] args) {
    DecompileDemo d = new DecompileDemo();
    System.out.println(d.greet("World"));
  }
}
