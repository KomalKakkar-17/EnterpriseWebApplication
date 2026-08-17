package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.model.Printable;
import library.service.FineService;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource.setLibraryName("Nova Nolanda");

        LibraryResource[] rescs = new LibraryResource[5];
        rescs[0] = new Book(1, "CAO", "Morris");
        rescs[1] = new DigitalResource(2, "Ghost", "Bill");
        rescs[2] = new DigitalResource(3, "Ove", "Ove");
        rescs[3] = new Book(4, "ML", "Alfredo");
        rescs[4] = new Book(5, "Java", "Karan");

        System.out.println("Library: " + LibraryResource.getLibraryName());
        System.out.println();

        for (LibraryResource resc : rescs) {
            if (!InputValidator.validateResourceId(resc.getResourceId())) {
                System.out.println("Not a valid resource ID");
                continue;
            }
            ((Printable) resc).printDetails();
        }

        int[] overdueDays = {0, 0, 1, 3, 7};
        double totalFine = FineService.calculateTotalFine(rescs, overdueDays);

        System.out.println();
        LibraryResource.displayTotalResources();
        System.out.println("Total fine: " + totalFine);
    }
}
