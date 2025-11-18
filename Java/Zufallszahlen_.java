import java.util.Random;

public class ZufallsZahlen {
    public static void main(String[] args) {

        Random random = new Random();

        int a = random.nextInt(100); // Zufallszahl von 0-99
        int aa = random.nextInt(101); // Zufallszahl von 0-100
        int b = random.nextInt(-1,101); // Zufallszahl von -1 bis 100
        int c = random.nextInt(-10,10); // Zufallszahl von -10 bis 9

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
