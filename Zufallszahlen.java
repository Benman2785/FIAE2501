import java.util.Random;
public class Zufallszahlen {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(100);
        int b = random.nextInt(100) + 1;
        int c = random.nextInt(-10,10);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}