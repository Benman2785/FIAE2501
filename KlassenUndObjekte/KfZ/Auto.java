public class Auto extends Kfz {
    private final int anzahlTueren;
    private int anzahlTuerenOpen;

    public Auto(String marke, String modell, int anzahlTueren) {
        super(marke, modell);
        this.anzahlTueren = anzahlTueren;
        anzahlTuerenOpen = 0;
    }
    public int getAnzahlTueren() {
        return anzahlTueren;
    }
    public int getAnzahlTuerenOpen() {
        return anzahlTuerenOpen;
    }
    public int setAnzahlTuerenOpen(int anzahlTuerenOpen){
        this.anzahlTuerenOpen = anzahlTuerenOpen;
        if (anzahlTuerenOpen > anzahlTueren){
            anzahlTuerenOpen = anzahlTueren;
        }
        System.out.println("Wir oeffnen " + anzahlTuerenOpen + " Tueren am " + modell + ".");
        return anzahlTuerenOpen;
    }
    @Override
    public void gepaeckFach() {
        System.out.println("Auto hat einen Kofferraum!");
    }
    @Override
    public String toString() {
        return "Auto [Marke= " + marke + ", Modell= " + modell + ", Geschwindigkeit= " + geschwindigkeit + "km/h]";
    }
    @Override
    public void beschleunigen(int wert) {
        anzahlTuerenOpen = 0;
        System.out.print("Auto schließt alle Tueren und ");
        super.beschleunigen(wert);
    }
    @Override
    public void bremsen(int wert){
        System.out.print("Auto ");
        super.bremsen(wert);
    }
}