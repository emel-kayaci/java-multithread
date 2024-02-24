package thread.creation;

public class Creation {

  public static void main(String[] args) throws InterruptedException {

    // Note: Creating Threads (2 way)
    Thread thread1 =
        new Thread(
            () -> {
              System.out.println("In thread " + Thread.currentThread().getName());
              System.out.println("Thread priority " + Thread.currentThread().getPriority());
            });

    Thread thread2 = new NewThread();

    thread1.setName("Thread 1");
    thread1.setPriority(Thread.MAX_PRIORITY); // ranges 1-10

    thread2.setName("Thread 2");

    System.out.println(
        "In thread " + Thread.currentThread().getName() + " before starting a new thread.");
    thread1.start(); // create new thread and pass it to OS
    // does not spin in a loop, tells OS to not schedule new thread until that time passes
    Thread.sleep(10000);
    thread2.start();
    System.out.println(
        "In thread " + Thread.currentThread().getName() + " after starting a new thread.");
  }

  private static class NewThread extends Thread {
    @Override
    public void run() {
      // Note: Since we are extending class directly can access name with this instead of
      // Thread.currentThread().getName()
      System.out.println("In thread " + this.getName());
    }
  }
}
