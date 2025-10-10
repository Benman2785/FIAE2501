public class ForEachSum {
    public static void main(String[] args) {

        int[] a = {0,1,2,3,4,5,6,7,8,9};
        int summe = 0;
        
        for (int i : a) {
            summe = summe + i;
        }

        System.out.println("Summe ist gleich " + summe);
    }
}
