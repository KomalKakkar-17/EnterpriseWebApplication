package library.model;

public class DigitalResource extends LibraryResource implements Printable {

    public static final double FINE = 2.0;

    public DigitalResource(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return FINE * overdueDays;
    }

    @Override
    public void printDetails() {
        System.out.println(getBaseDetails() + " | Type: Digital Resource");
    }
}
