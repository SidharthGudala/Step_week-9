import java.util.*;

abstract class LibraryItem {
    String title;
    int days;
    LibraryItem(String t, int d) { title = t; days = d; }
    abstract double fine();
}

class Book extends LibraryItem {
    Book(String t, int d) { super(t, d); }
    double fine() { return days * 2.0; }
}

class DVD extends LibraryItem {
    DVD(String t, int d) { super(t, d); }
    double fine() { return Math.min(days * 5.0, 50); }
}

class Magazine extends LibraryItem {
    Magazine(String t, int d) { super(t, d); }
    double fine() { return days * 1.0; }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next(), title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK": item = new Book(title, days); break;
                case "DVD": item = new DVD(title, days); break;
                default: item = new Magazine(title, days);
            }

            System.out.printf("%s: %.2f%n", title, item.fine());
            total += item.fine();
        }

        System.out.printf("Total Fines: %.2f%n", total);
    }
}
