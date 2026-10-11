import java.util.*;

abstract class Connection {
    int units;
    Connection(int u) { units = u; }
    abstract double bill();
}

class Home extends Connection {
    Home(int u) { super(u); }
    double bill() {
        return Math.min(units, 100) * 5
             + Math.max(0, units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(int u) { super(u); }
    double bill() { return units * 8 + 100; }
}

class Factory extends Connection {
    Factory(int u) { super(u); }
    double bill() { return Math.max(1000, units * 6); }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            switch (type) {
                case "HOME": c = new Home(units); break;
                case "SHOP": c = new Shop(units); break;
                default: c = new Factory(units);
            }

            System.out.printf("%s: %.2f%n", type, c.bill());
            total += c.bill();
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
