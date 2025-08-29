abstract class Kfz {
    protected String marke;
    protected String modell;
    protected int geschwindigkeit;

    public Kfz(String marke, String modell) {
        this.marke = marke;
        this.modell = modell;
        geschwindigkeit = 0;
    }
    public void beschleunigen(int wert) {
        geschwindigkeit += wert;
        System.out.print(modell + " beschleunigt um " + wert + "km/h. Aktuelle Geschwindigkeit: " + geschwindigkeit + "km/h\n");
    }
    public void bremsen(int wert) {
        geschwindigkeit -= wert;
        if (geschwindigkeit < 0) {
            geschwindigkeit = 0;
        }
        System.out.print(modell + " bremst um " + wert + "km/h. Aktuelle Geschwindigkeit: " + geschwindigkeit + "km/h\n");
    }
    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }
    public abstract void gepaeckFach();
}