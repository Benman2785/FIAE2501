abstract class Tier {
    private String gattung;
    private double gewicht;
    public Tier(String gattung, double gewicht){
        this.gattung = gattung;
        this.gewicht = gewicht;
    }
    public String getGattung() {
        return gattung;
    }
    public void setGattung(String gattung) {
        this.gattung = gattung;
    }
    public double getGewicht() {
        return gewicht;
    }
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    public void gehen(){
        System.out.println("Tiere koennen sich bewegen - tun es aber nicht - besonders nicht im Zoo");
    }
    public void fressen(){
        System.out.println("Damit ein Tier kaggn kann muss es was futtern");
    }
}