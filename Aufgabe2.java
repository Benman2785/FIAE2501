public class Aufgabe2 {
    public static void main(String[] args) {
        String header = "<?xml version='1.0' encoding='UTF-8'?>";
        String header2 = "<svg width='300' height='300' xmlns='http://www.w3.org/2000/svg'>";
        String rechteck = "<rect x='0' y='0' width='300' height='300' fill='white' stroke='black' stroke-width='2' />";
        String kreis = "<circle cx='";
        String kreis2 = "' cy='";
        String kreis3 = "' r='10' fill='red' stroke='black' stroke-width='2' />";
        String svg = "</svg>";

        System.out.println(header);
        System.out.println(header2);
        System.out.println(rechteck);

        for (int x = 10; x <= 290; x += 20) { // i = x
            for (int y = 10; y <= 290; y += 20) { // y = y
                System.out.println(kreis + x + kreis2 + y + kreis3);
            }
        }

        System.out.println(svg); // außerhalb der Schleife!
    }
}
