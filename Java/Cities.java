public class Cities {
    public static void main(String[] args) {

        int count = 5;
        
        String[] staedte = new String[count];
        int[] entfernungen = new int[count];

        staedte[0] = "Hamburg";
        staedte[1] = "Kopenhagen";
        staedte[2] = "Paris";
        staedte[3] = "Prag";
        staedte[4] = "Amsterdam";

        entfernungen[0] = 284;
        entfernungen[1] = 355;
        entfernungen[2] = 878;
        entfernungen[3] = 345;
        entfernungen[4] = 658;

        String stadt = "Berlin - ";

        System.out.println(stadt + staedte[0] + ": \t " + entfernungen[0] + "km");
        System.out.println(stadt + staedte[1] + ": \t " + entfernungen[1] + "km");
        System.out.println(stadt + staedte[2] + ": \t " + entfernungen[2] + "km");
        System.out.println(stadt + staedte[3] + ": \t\t " + entfernungen[3] + "km");
        System.out.println(stadt + staedte[4] + ": \t " + entfernungen[4] + "km");

        System.out.printf("%10s %25s: %25dkm\n", stadt, staedte[0], entfernungen[0]);
        System.out.printf("%-10s %-25s: %25dkm\n", stadt, staedte[1], entfernungen[1]);
        System.out.printf("%-10s %-25s: %25dkm\n", stadt, staedte[2], entfernungen[2]);
        System.out.printf("%-10s %-25s: %25dkm\n", stadt, staedte[3], entfernungen[3]);
        System.out.printf("%-10s %-25s: %25dkm\n", stadt, staedte[4], entfernungen[4]);
    }
}
