public class SummeGleitkommaZahle {
    public static void main(String[] args) {
        

        double[] zahlen = {1.5,2.5,3.5,4.5,5.5};
    
        double ergebnis = 0;

        for (double zahl : zahlen) {
            ergebnis = ergebnis + zahl;
        }
        System.out.println( " = " + ergebnis);

    }


}
