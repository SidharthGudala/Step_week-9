import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double fare() {
        return Math.max(100, km * rate());
    }
}

interface NightService {
    double nightFare();
}

class Mini extends Cab {
    Mini(double km) { super(km); }
    double rate() { return 10; }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) { super(km); }
    double rate() { return 14; }
    public double nightFare() { return fare() * 1.2; }
}

class SUV extends Cab implements NightService {
    SUV(double km) { super(km); }
    double rate() { return 18; }
    public double nightFare() { return fare() * 1.2; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab c;
            switch (type) {
                case "MINI": c = new Mini(km); break;
                case "SEDAN": c = new Sedan(km); break;
                default: c = new SUV(km);
            }

            if (time.equals("NIGHT") && !(c instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = c.fare();
            if (time.equals("NIGHT"))
                fare = ((NightService)c).nightFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
