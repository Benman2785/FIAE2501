public class Schleifenaufgabe1 {
    public static void main(String[] args) {
        int zahlenArray[] = {1,2,3,4,5,6,7,8,9,10};
        int laenge = zahlenArray.length;

        for (int i = 0; i < laenge; i++) {
            System.out.print(zahlenArray[i] + " ");
        }
        System.out.println(" ");
        
        int y = 0;
        do {
            System.out.print(zahlenArray[y] + " ");
            y++; 
        } while (y < laenge);

        int z = 0;
        System.out.println(" ");
        while (z < laenge) {
            System.out.print(zahlenArray[z] + " ");
            z++;
        }
        System.out.println(" ");
        for (int zahl : zahlenArray) {
            System.out.print(zahl + " ");
        }     
    }
}