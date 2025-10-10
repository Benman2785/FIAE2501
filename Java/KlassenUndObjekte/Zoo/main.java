public class main {
     public static void main(String[] args) {
        
        Loewe l1 = new Loewe("Mietzekatze", 150.00);
        Elefant e1 = new Elefant("Olliphant", 2000, 150, 200);

        System.out.println("Will kommen im Zooh!");
        System.out.println("Wir haben nur Loewen und Elefanten");
        System.out.println("");
        System.out.println("Loewi, der Geattung " + l1.getGattung() + " mit einem Gewicht von " + l1.getGewicht() + "kg -> du bist dran!");
        
        l1.gehen();
        l1.bruellen();
        l1.fressen();
        l1.jagen();

        System.out.println("genug Loewi - zurueck in die Einzelzelle!");

        System.out.println("Jetzt kommt deine Zeit Elefanti, der Gattung " + e1.getGattung() + " mit einem Stampfgewicht von " + e1.getGewicht() + "kg!");
        System.out.println("Phanti hat einen riesigen Ruessel mit einer Laenge von " + e1.getRuesselLaenge() + "cm");
        System.out.println("Phanti hat sogar Stosszaehne mit einer Laenge von " + e1.getStossZahnLaenge() + "cm - aber zum Glueck frisst er nur Pflanzis");
        
        e1.fressen();
        e1.gehen();
        
        System.out.println("Der Zoo muss nun leider dauerhaft schliessen");
    }
}