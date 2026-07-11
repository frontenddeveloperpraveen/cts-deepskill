import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=\"" + title + "\", Author=" + author + "]";
    }
}

public class Main {
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] books, String targetTitle) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B01", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B02", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B03", "1984", "George Orwell"),
            new Book("B04", "Moby Dick", "Herman Melville"),
            new Book("B05", "Pride and Prejudice", "Jane Austen")
        };

        System.out.println("--- Linear Search Test ---");
        Book foundLinear = linearSearchByTitle(books, "1984");
        System.out.println("Found: " + foundLinear);

        System.out.println("\n--- Binary Search Test (Requires sorting by title) ---");
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        
        System.out.println("Sorted books:");
        for (Book b : books) {
            System.out.println(b);
        }

        Book foundBinary = binarySearchByTitle(books, "1984");
        System.out.println("\nFound: " + foundBinary);
    }
}
