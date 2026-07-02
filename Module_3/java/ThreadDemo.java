class MessageThread extends Thread {
  private final String msg;
  MessageThread(String msg) { this.msg = msg; }
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(msg + " - " + i);
      try { Thread.sleep(100); } catch (InterruptedException e) { }
    }
  }
}

public class ThreadDemo {
  public static void main(String[] args) {
    new MessageThread("Thread A").start();
    new MessageThread("Thread B").start();
  }
}
