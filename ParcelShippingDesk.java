import java.util.*;

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

interface Insurable {
    double insurance();
}

class Standard extends Parcel {
    Standard(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
    public double insurance() { return value * 0.02; }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight + 50; }
    public double insurance() { return value * 0.02; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;

        while (n-- > 0) {
            String type = sc.next();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD": p = new Standard(w, v); break;
                case "EXPRESS": p = new Express(w, v); break;
                default: p = new Fragile(w, v);
            }

            double ins = p instanceof Insurable
                    ? ((Insurable)p).insurance() : 0;
            double charge = p.charge();
            double total = charge + ins;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, ins, total
            );
            grand += total;
        }

        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
