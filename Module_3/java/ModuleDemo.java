// File 1: com.utils/module-info.java
// module com.utils {
//   exports com.utils;
// }
//
// File 2: com.utils/com/utils/Utility.java
// package com.utils;
// public class Utility {
//   public static void greet(String name) {
//     System.out.println("Hello, " + name + " from com.utils!");
//   }
// }
//
// File 3: com.greetings/module-info.java
// module com.greetings {
//   requires com.utils;
// }
//
// File 4: com.greetings/com/greetings/Main.java
// package com.greetings;
// import com.utils.Utility;
// public class Main {
//   public static void main(String[] args) {
//     Utility.greet("Alice");
//   }
// }
//
// Compile:
//   javac -d mods/com.utils com.utils/module-info.java com.utils/com/utils/Utility.java
//   javac --module-path mods -d mods/com.greetings com.greetings/module-info.java com.greetings/com/greetings/Main.java
// Run:
//   java --module-path mods -m com.greetings/com.greetings.Main

public class ModuleDemo {
  public static void main(String[] args) {
    System.out.println("See inline comments for full module setup instructions.");
    System.out.println("Directory structure:");
    System.out.println("  com.utils/");
    System.out.println("    module-info.java");
    System.out.println("    com/utils/Utility.java");
    System.out.println("  com.greetings/");
    System.out.println("    module-info.java");
    System.out.println("    com/greetings/Main.java");
  }
}
