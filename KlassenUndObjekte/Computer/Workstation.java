public class Workstation extends Computer {
    private String Prozessor;

    // Konstruktor
    public Workstation(String hersteller, String modell, int baujahr, String Prozessor) {
        super(hersteller, modell, baujahr);
        this.Prozessor = Prozessor;
    }

    // Getter und Setter
    public String getProzessor() {
        return Prozessor;
    }
    public void setProzessor(String Prozessor) {
        this.Prozessor = Prozessor;
    }   
}
