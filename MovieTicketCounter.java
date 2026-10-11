import java.util.*;

abstract class Ticket {
    static final int FEE = 20;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract int price();

    double amount() {
        return count * (price() + FEE);
    }
}

class Regular extends Ticket {
    Regular(int n) { super(n); }
    int price() { return 150; }
}

class Premium extends Ticket {
    Premium(int n) { super(n); }
    int price() { return 250; }
}

class Recliner extends Ticket {
    Recliner(int n) { super(n); }
    int price() { return 400; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket t;

            switch (type) {
                case "REGULAR": t = new Regular(count); break;
                case "PREMIUM": t = new Premium(count); break;
                default: t = new Recliner(count);
            }

            System.out.printf("%s: %.2f%n", type, t.amount());
            total += t.amount();
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
