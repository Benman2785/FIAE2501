public class FloatArray {
    public static void main(String[] args) {
        double[] zahlen = {1.2345,2.3456,3.4567,4.5678,5.6789};
        double ergebnis = 0;
        int count = 0;
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        for (double zahl : zahlen) {
            ergebnis = ergebnis + zahl;
            System.out.print(zahlen[count] + " + ");
            if (count <= zahlen.length -2){
                count = count + 1;
            } else {
                System.out.print(zahlen[count]);
            }
        }
          System.out.print(" = " + ergebnis);
    }
}
