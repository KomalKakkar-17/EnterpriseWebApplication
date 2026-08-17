package library.service;

import library.model.LibraryResource;
import library.util.InputValidator;

public class FineService {

    public static double calculateTotalFine(LibraryResource[] rescs, int[] days) {
        double total = 0;
        for (int i = 0; i < rescs.length; i++) {
            if (InputValidator.validateFineDays(days[i])) {
                total += rescs[i].calculateFine(days[i]); // polymorphism -
                // Java calls Book's or DigitalResource's version automatically
            }
        }
        return total;
    }
}
