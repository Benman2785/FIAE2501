import java.util.Random;

public class BiggestSmallesArray {

    public static void main(String[] args) {
        int[] numbers = new int[15];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {
            if (number > max){
                max = number;
            }
            if (number < min){
                min = number;
            }
            System.out.print(number + " ");
        }

        System.out.println("");
        System.out.println("Groesste Zahl " + max);
        System.out.println("Kleinste Zahl " + min);
    }
}