class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger 1 Hashcode: " + logger1.hashCode());
        System.out.println("Logger 2 Hashcode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both logger1 and logger2 reference the exact same instance.");
        } else {
            System.out.println("FAILURE: logger1 and logger2 reference different instances.");
        }

        logger1.log("This is a test log message using logger1.");
        logger2.log("This is a test log message using logger2.");
    }
}
