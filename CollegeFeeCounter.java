import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    boolean usesBus() {
        return false;
    }

    double fee() {
        return tuition() + (usesBus() ? 12000 : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
    boolean usesBus() { return true; }
}

class Hosteller extends Student {
    Hosteller(String n) { super(n); }
    double tuition() { return 100000; }
}

class Scholar extends Student {
    Scholar(String n) { super(n); }
    double tuition() { return 20000; }
    boolean usesBus() { return true; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        while (n-- > 0) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new Scholar(name);
            }

            System.out.printf("%s: %.2f%n", name, s.fee());
            total += s.fee();
        }

        System.out.printf("Total Collected: %.2f%n", total);
    }
}
