import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int num = Math.abs(n); // handle negative numbers safely
        int count = 0;

        if (num == 0) {
            count = 1; // special case: 0 has 1 digit
        } else {
            while (num != 0) {
                num /= 10;
                count++;
            }
        }

        System.out.println("Number of digits in " + n + " is " + count);
        sc.close();
    }
}
