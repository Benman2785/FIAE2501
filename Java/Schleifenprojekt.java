public class Schleifenprojekt {
    public static void main(String[] args) {

        double[] zahlenArray = {3.2, 6.8, 8.1, 1.8};

        // while Schleife
        // while(Abbruchbedingung(en)){
            // Anweisungen    
        // }
        int i = 0;
        double summe = 0;
        while (i < zahlenArray.length) { 
            // summe += zahlenArray[i]
            summe = summe + zahlenArray[i];
            i++;
        }

        System.out.println("Summe: " + summe);

        // do-while Schleife
        // do {
            // Anweisungen;    
        // } while (Abbruchbedingung(en));
        double produkt = 1;
        i = 0;
        do {
            // summe *= zahlenArray[i]
            produkt = produkt * zahlenArray[i];
            i++;
        } while (i < zahlenArray.length);

        System.out.println("Produkt: " + produkt);

    }
}