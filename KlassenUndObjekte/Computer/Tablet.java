public class Tablet extends Computer {
    private double displayGroesse; // in Zoll
    private boolean hatStift;

    // Konstruktor
    public Tablet(String hersteller, String modell, int baujahr, double displayGroesse, boolean hatStift) {
        super(hersteller, modell, baujahr);
        this.displayGroesse = displayGroesse;
        this.hatStift = hatStift;
    }

    // Getter und Setter
    public double getDisplayGroesse() {
        return displayGroesse;
    }
    public boolean isHatStift() {
        return hatStift;
    }
    public void setDisplayGroesse(double displayGroesse) {
        this.displayGroesse = displayGroesse;
    }
    public void setHatStift(boolean hatStift) {
        this.hatStift = hatStift;
    }
    
}
