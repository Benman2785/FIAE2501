
public class FizzBuzz {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-=[ Knaller FizzBuzz Line ]=-");

        // ArrayList<Integer> zahlen = new ArrayList<>();
        // for (int i = 1; i < 31; i++) {
        //     zahlen.add(i);
        // }

        // for (int i= 0; i < 30; i++){
        //     if (zahlen.get(i) % 5 == 0 && zahlen.get(i) % 3 == 0) {
        //         System.out.print("FizzBuzz ");
        //     } else if (zahlen.get(i) % 3 == 0) {
        //         System.out.print("Fizz ");
        //     } else if (zahlen.get(i) % 5 == 0) {
        //         System.out.print("Buzz ");
        //     } else {
        //         System.err.print(zahlen.get(i) + " ");
        //     }
        // }

        for (int i= 1; i < 31; i++){
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.err.print(i + " ");
            }
        }
        System.out.println(" ");
        System.out.println("-=[ Knaller Ändä ]=-");
    }
}
