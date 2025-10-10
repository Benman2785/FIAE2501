public class Main {
    public static void main(String[] args) {
       
        Laptop laptop1 = new Laptop("Dell", "XPS 13", 2021, 1.2, 10);
        Tablet tablet1 = new Tablet("Apple", "iPad Pro", 2023, 12.9, true);
        Tower tower1 = new Tower("HP", "Omen", 2020, true);
        Workstation workstation1 = new Workstation("Lenovo", "ThinkStation", 2022, "Intel Xeon");
        
        // starten der Computer
        System.out.println("\n--- es werde schlicht ---");
        laptop1.starten();
        tablet1.starten();
        tower1.starten();
        workstation1.starten();

        // Dateien erstellen
        System.out.println("\n--- erstelle Datei(en) ---");
        laptop1.erstelleDatei("Dokument.docx");
        tablet1.erstelleDatei("Datenanalyse.csv");
        tower1.erstelleDatei("IHK-Projektarbeit.txt");
        workstation1.erstelleDatei("krasser Porn.mp4");

        // Dateien anzeigen
        System.out.println("\n--- Gespeicherte Dateien ---");
        laptop1.zeigeGespeicherteDateien();
        tablet1.zeigeGespeicherteDateien();
        tower1.zeigeGespeicherteDateien();
        workstation1.zeigeGespeicherteDateien();

        // Dateien transferieren
        System.out.println("\n--- transfer Datei(en) ---");
        laptop1.transferCopyDatei(workstation1, "Dokument.docx");
        tablet1.transferCopyDatei(workstation1, "Datenanalyse.csv");
        tower1.transferCopyDatei(workstation1, "IHK-Projektarbeit.txt");
  
        // Dateien anzeigen
        System.out.println("\n--- Gespeicherte Dateien nach TransferCopy ---");
        laptop1.zeigeGespeicherteDateien();
        tablet1.zeigeGespeicherteDateien();
        tower1.zeigeGespeicherteDateien();
        workstation1.zeigeGespeicherteDateien();

        // Dateien transferieren und löschen
        System.out.println("\n--- verschiebe Datei(en) ---");
        workstation1.transferDelDatei(tablet1, "krasser Porn.mp4");
        workstation1.transferDelDatei(tower1, "Datenanalyse.csv");
        workstation1.transferDelDatei(laptop1, "IHK-Projektarbeit.txt");

        // Dateien anzeigen
        System.out.println("\n--- Gespeicherte Dateien nach TransferDel ---");
        laptop1.zeigeGespeicherteDateien();
        tablet1.zeigeGespeicherteDateien();
        tower1.zeigeGespeicherteDateien();
        workstation1.zeigeGespeicherteDateien();

        // Dateien löschen
        System.out.println("\n--- loesche Datei(en) von Laptop ---");
        laptop1.loescheDatei("Dokument.docx");
        laptop1.zeigeGespeicherteDateien();
    }
}