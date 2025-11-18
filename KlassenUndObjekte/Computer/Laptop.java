public class Laptop extends Computer {
    private double gewicht; // in kg
    private double akkuLaufzeit; // in Stunden
    
    // Konstruktor
    public Laptop(String hersteller, String modell, int baujahr, double gewicht, double akkuLaufzeit) {
        super(hersteller, modell, baujahr);
        this.gewicht = gewicht;
        this.akkuLaufzeit = akkuLaufzeit;
    }

    // Getter und Setter
    public double getGewicht() {
        return gewicht;
    }
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    public double getAkkuLaufzeit() {
        return akkuLaufzeit;
    }
    public void setAkkuLaufzeit(double akkuLaufzeit) {
        this.akkuLaufzeit = akkuLaufzeit;
    }
}
