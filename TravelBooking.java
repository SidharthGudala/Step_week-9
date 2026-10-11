import java.util.*;

abstract class Travel {
    double distance;
    static final double FEE = 50;

    Travel(double d) { distance = d; }
    abstract double fare();

    double total() { return fare() + FEE; }
}

class Bus extends Travel {
    Bus(double d) { super(d); }
    double fare() { return distance * 2; }
}

class Train extends Travel {
    Train(double d) { super(d); }
    double fare() { return distance * 1.5; }
}

class Flight extends Travel {
    Flight(double d) { super(d); }
    double fare() { return 2500 + distance * 4; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            String type = sc.next();
            double d = sc.nextDouble();
            Travel t;

            switch (type) {
                case "BUS": t = new Bus(d); break;
                case "TRAIN": t = new Train(d); break;
                default: t = new Flight(d);
            }

            System.out.printf("%s: %.2f%n", type, t.total());
        }
    }
}
