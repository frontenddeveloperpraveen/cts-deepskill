import java.util.concurrent.*;

public class ExecutorServiceDemo {
  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newFixedThreadPool(4);
    Callable<Integer> task = () -> {
      Thread.sleep(500);
      return ThreadLocalRandom.current().nextInt(100);
    };
    Future<Integer> f1 = exec.submit(task);
    Future<Integer> f2 = exec.submit(task);
    Future<Integer> f3 = exec.submit(task);
    System.out.println("Result 1: " + f1.get());
    System.out.println("Result 2: " + f2.get());
    System.out.println("Result 3: " + f3.get());
    exec.shutdown();
  }
}
