// Compile: javac JavapDemo.java
// Inspect: javap -c JavapDemo
//
// javap disassembles the bytecode:
// - Shows the constant pool, method bytecode instructions
// - Useful for understanding what the compiler generates

public class JavapDemo {
  public static int add(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    int result = add(3, 4);
    System.out.println("Result: " + result);
  }
}
