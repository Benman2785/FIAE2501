public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("BMW", "M3", 4);
        Motorrad motorrad = new Motorrad("Honda", "CBR600");
        
        //** CLS in Console */ 
        System.out.print("\033[H\033[2J");
        System.out.flush();

        auto.setAnzahlTuerenOpen(2);

        // ** Geschwindigkeit **
        auto.beschleunigen(50);
        auto.bremsen(20);
        
        motorrad.beschleunigen(80);
        motorrad.bremsen(40);

        // ** ToString **
        System.out.println(auto);
        System.out.println(motorrad);

        // ** Tueren / Gepaeckfach**
        auto.setAnzahlTuerenOpen(2);
        System.out.println(auto.modell + " hat " + auto.getAnzahlTueren() + " Tueren, und davon ist/sind " + auto.getAnzahlTuerenOpen() + " Tuer(en) offen.");
  
        auto.gepaeckFach();
        motorrad.gepaeckFach();
    }
}
