public class Loop {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int summe = 0;

        for (int i = 0; i < numbers.length; i++) {
            summe += numbers[i];
        }
        System.out.println("Summe des Arrays = " + summe);
        System.out.printf("GERADE Zahlen des Arrays:");
        for (int i : numbers) {
            if (i % 2 == 0) {
                System.out.printf(" %d;", i);
            }
        }
        System.out.printf("%n");
        System.out.printf("UNGERADE Zahlen des Arrays:");
        for (int i : numbers) {
            if (i % 2 == 1) {
                System.out.printf(" %d;", i);
            }
        }
    }
}
