
import java.util.ArrayList;

abstract public class Computer {
    private String hersteller;
    private String modell;
    private int baujahr;
    private final ArrayList<String> gespeicherteDateien = new ArrayList<>();

    public static String dateiName;

    // Konstruktor
    public Computer(String hersteller, String modell, int baujahr) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
    }

    // Methoden
    public void starten() {
        System.out.println(hersteller + " " + modell + " wird gestartet...");
    }

    public void erstelleDatei(String dateiName) {
        gespeicherteDateien.add(dateiName);
        System.out.println("Datei " + dateiName + " wurde erstellt.");
    }

    public void loescheDatei(String dateiName) {
        gespeicherteDateien.remove(dateiName);
        System.out.println("Datei " + dateiName + " wurde geloescht.");
    }

    public void transferCopyDatei(Computer zielComputer, String dateiName) {
        if (gespeicherteDateien.contains(dateiName)) {
            zielComputer.gespeicherteDateien.add(dateiName);
            System.out.println("Datei " + dateiName + " wurde zu " + zielComputer.getModell() + " transferiert.");
        } else {
            System.out.println("Datei " + dateiName + " nicht gefunden.");
        }
    }

    public void transferDelDatei(Computer zielComputer, String dateiName) {
        if (gespeicherteDateien.contains(dateiName)) {
            gespeicherteDateien.remove(dateiName);
            zielComputer.gespeicherteDateien.add(dateiName);
            System.out.println("Datei " + dateiName + " wurde zu " + zielComputer.getModell() + " transferiert.");
        } else {
            System.out.println("Datei " + dateiName + " nicht gefunden.");
        }
    }

    public void zeigeGespeicherteDateien() {
        System.out.println("Gespeicherte Dateien auf " + hersteller + " " + modell  + ": " + gespeicherteDateien);
    }

    // Getter und Setter
    public String getHersteller() {
        return hersteller;
    }
    public String getModell() {
        return modell;
    }
    public int getBaujahr() {
        return baujahr;
    }
    public String getDateiName() {
        return dateiName;
    }
    public ArrayList<String> getGespeicherteDateien() {
        return gespeicherteDateien;
    }
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    public void setModell(String modell) {
        this.modell = modell;
    }
    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }
    public void setDateiName(String dateiName) {
        Computer.dateiName = dateiName;
    }
}
