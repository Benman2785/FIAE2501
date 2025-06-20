import java.util.Random;
public class Aufgabe3 {
    public static void main(String[] args) {
        Random random = new Random();
        String header = "<?xml version='1.0' encoding='UTF-8'?>";
        String header2 = "<svg width='300' height='300' xmlns='http://www.w3.org/2000/svg'>";
        String rechteck = "<rect x='0' y='0' width='300' height='300' fill='white' stroke='black' stroke-width='2' />";
        String rect = "<rect x='";
        String rect2 = "' y='";
        String rect3 = "' width='10' height='10' fill='rgb(";
        String rect4 = ")' stroke='black' stroke-width='0.5' />";
        String svg = "</svg>";

        System.out.println(header);
        System.out.println(header2);
        System.out.println(rechteck);

        for (int i = 0; i <= 290; i += 10) { // i = x
            for (int y = 0; y <= 290; y += 10) { // y = y
                int a = random.nextInt(0,255);
                int b = random.nextInt(0,255);
                int c = random.nextInt(0,255);
                System.out.println(rect + i + rect2 + y + rect3 + a + "," + b + "," + c + rect4);
            }
        }

        System.out.println(svg); // außerhalb der Schleife!
    }
}
