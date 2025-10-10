public class Elefant extends Tier{
    private double stossZahnLaenge;
    private double ruesselLaenge;

    public Elefant(String name, String gattung, double gewicht, double stossZahnLaenge, double ruesselLaenge) {
        super(name, gattung, gewicht);
        this.stossZahnLaenge = stossZahnLaenge;
        this.ruesselLaenge = ruesselLaenge;
    }
    @Override
    public void gehen(){
        System.out.println(this.getName() + " stuermt auf die Menge zu");
    }
    @Override
    public void fressen(){
        System.out.println(this.getName() + " spiesst einen Pinguin auf und wird zum Carnivore...");
    }
    public double getStossZahnLaenge() {
        return stossZahnLaenge;
    }
    public void setStossZahnLaenge(double stossZahnLaenge) {
        this.stossZahnLaenge = stossZahnLaenge;
    }
    public double getRuesselLaenge() {
        return ruesselLaenge;
    }
    public void setRuesselLaenge(double ruesselLaenge) {
        this.ruesselLaenge = ruesselLaenge;
    }
}