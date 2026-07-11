import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double price);
}

class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Mobile App - " + appName + "] Notification: " + stockName + " price changed to $" + price);
    }
}

class WebApp implements Observer {
    private final String siteName;

    public WebApp(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[Web App - " + siteName + "] Alert: " + stockName + " is now trading at $" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp("StockTracker");
        Observer webApp = new WebApp("FinancePortal");

        appleStock.registerObserver(mobileApp);
        appleStock.registerObserver(webApp);

        System.out.println("Updating AAPL price to $155.50...");
        appleStock.setPrice(155.50);

        System.out.println("\nDeregistering Web App observer...");
        appleStock.deregisterObserver(webApp);

        System.out.println("\nUpdating AAPL price to $160.00...");
        appleStock.setPrice(160.00);
    }
}
