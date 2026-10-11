import java.util.*;

abstract class Appliance {
    double hours;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    boolean supportsSaver() {
        return false;
    }

    double units(boolean saver) {
        double u = power() * hours / 1000;
        return saver ? u * 0.75 : u;
    }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AC extends Appliance {
    AC(double h) { super(h); }
    double power() { return 1500; }
    boolean supportsSaver() { return true; }
}

class TV extends Appliance {
    TV(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance {
    Washer(double h) { super(h); }
    double power() { return 500; }
    boolean supportsSaver() { return true; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            double h = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver) sc.next();

            Appliance a;
            switch (type) {
                case "FRIDGE": a = new Fridge(h); break;
                case "AC": a = new AC(h); break;
                case "TV": a = new TV(h); break;
                default: a = new Washer(h);
            }

            if (saver && !a.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.units(saver);
            double cost = units * 8;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                              type, units, cost);
            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}
