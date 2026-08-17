package library.model;

public class Book extends LibraryResource implements Printable {

    public static final double FINE = 5.0;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return FINE * overdueDays;
    }

    @Override
    public void printDetails() {
        System.out.println(getBaseDetails() + " | Type: Book");
    }
}
