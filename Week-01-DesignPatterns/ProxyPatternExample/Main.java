interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } else {
            System.out.println("Retrieved image from cache: " + filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.png");

        System.out.println("--- First Display Request (Should load from remote server) ---");
        img1.display();
        System.out.println();
        img2.display();

        System.out.println("\n--- Second Display Request (Should use cached instance) ---");
        img1.display();
        System.out.println();
        img2.display();
    }
}
