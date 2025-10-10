public class Tower extends Computer {
    private boolean hatGrafikkarte;

    // Konstruktor
    public Tower(String hersteller, String modell, int baujahr, boolean hatGrafikkarte) {
        super(hersteller, modell, baujahr);
        this.hatGrafikkarte = hatGrafikkarte;
    }

    // Getter und Setter
    public boolean isHatGrafikkarte() {
        return hatGrafikkarte;
    }
    public void setHatGrafikkarte(boolean hatGrafikkarte) {
        this.hatGrafikkarte = hatGrafikkarte;
    }

}
