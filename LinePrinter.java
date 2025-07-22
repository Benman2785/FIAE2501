public class LinePrinter {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("gibi Zahl");
        int len = sc.nextInt();
        sc.nextLine();
        System.out.println("gibi Zeichn 1");
        char c1 = sc.nextLine().charAt(0);
        System.out.println("gibi Zeichn 2");
        char c2 = sc.nextLine().charAt(0);
        System.out.println("gibi Prefix");
        String Prefix = sc.nextLine();
        System.out.println("gibi Suffix");
        String Suffix = sc.nextLine();
        System.out.println("Wie oft: " + len);
        line();
        System.out.println("");
        line(len);
        System.out.println("");
        line(len, c1);
        System.out.println("");
        line(Prefix, len, c2, Suffix);
    }
    public static void line() {
        System.out.print("**********");
    }
    public static void line(int len) {
        line(len, '-');
    }
    public static void line(int len, char c) {
        for (int i=0; i<len; i++){
            System.out.print(c);
        }
    }
    public static void line(String Prefix, int len, char c, String Suffix) {
        System.out.print(Prefix);
        line(len, c);
        System.out.print(Suffix);
    }
}