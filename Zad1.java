import java.util.ArrayList;

class Zad1 {
    String name;
    double netto;
    double vat;

    public Zad1(String name, double netto, double vat) {
        this.name = name;
        this.netto = netto;
        this.vat = vat;
    }
    

    public String getName() {
        return name;
    }


    public double getNetto() {
        return netto;
    }


    public double getVat() {
        return vat;
    }


    public double calculateVAT() {
        return netto * vat / 100;
    }

    public static void main(String[] args) {
        ArrayList<Zad1> items = new ArrayList<>();
        items.add(new Zad1("Clean Code, Robert C. Martin", 100.00, 8));
        items.add(new Zad1("Applying UML and Patterns, C. Larman", 300.00, 8));
        items.add(new Zad1("Shipping", 50.00, 23));

        double Netto8 = 0, Netto23 = 0;
        double vat8 = 0;
        double vat23 = 0;

        for (Zad1 item : items) {
            if (item.vat == 8) {
                Netto8 += item.netto;
                vat8 += item.calculateVAT();
            } else if (item.vat == 23) {
                Netto23 += item.netto;
                vat23 += item.calculateVAT();
            }

        }

        System.out.println("|          | Total netto | Sum of Vat |");
        System.out.println("|----------|-------------|------------|");
        System.out.printf("| Vat 8%%   | %.2f PLN  | %.2f PLN  |\n", Netto8, vat8);
        System.out.printf("| Vat 23%%  | %.2f PLN   | %.2f PLN  |\n", Netto23, vat23);
    }
}
