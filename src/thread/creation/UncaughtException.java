package thread.creation;

public class UncaughtException {
  public static void main(String[] args) {

    Thread thread =
        new Thread(
            () -> {
              throw new RuntimeException("Intentional Exception");
            });

    thread.setUncaughtExceptionHandler(
        (t, e) ->
            System.out.println(
                "Critical error occurred in thread "
                    + t.getName()
                    + " error is: "
                    + e.getMessage()));

    thread.start();
  }
}
