public class Aufgabe1 {
    public static void main(String[] args) {
        String header = "<?xml version='1.0' encoding='UTF-8'?>";
        String header2 = "<svg width='300' height='300' xmlns='http://www.w3.org/2000/svg'>";
        String rechteck = "<rect x='0' y='0' width='300' height='300' fill='white' stroke='black' stroke-width='2' />";
        String kreis = "<circle cx='150' cy='150' r='75' fill='red' stroke='black' stroke-width='2' />";
        String svg = "</svg>";

        System.out.println(header);
        System.out.println(header2);
        System.out.println(rechteck);
        System.out.println(kreis);
        System.out.println(svg);
    }
}
