public class VirtualThreadDemo {
  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread[] threads = new Thread[100_000];
    for (int i = 0; i < threads.length; i++) {
      int id = i;
      threads[i] = Thread.startVirtualThread(() -> {
        System.out.println("VT " + id + " running");
      });
    }
    for (Thread t : threads) t.join();
    long end = System.currentTimeMillis();
    System.out.println("Launched " + threads.length + " virtual threads in " + (end - start) + "ms");
  }
}
