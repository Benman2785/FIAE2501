public class BMIMeth {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-=]/°\\[=- BMI Rechner -=]/°\\[=-");
        double[] werte = input();
        double bmiWert = bmi(werte[0], werte[1]);
        output(bmiWert);
        sc.close();
    }
    public static double[] input() {
        System.out.print("Gib dein Groesse in m (zB 1,81) an: ");
        double groesse = sc.nextDouble();
        System.out.print("Gib dein Gewicht in kg (zB 79,5) an: ");
        double gewicht = sc.nextDouble();
        return new double[]{groesse, gewicht};
    }
    public static double bmi(double groesse, double gewicht) {
         return gewicht / (groesse * groesse);
    }
    public static void output(double bmi) {
        if (bmi >= 30) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Asi-Podi-das! %n", bmi);
        } else if (bmi >= 25.4) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Uebergewicht! %n", bmi);
        } else if (bmi >= 18.5) {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Normalgewicht! %n", bmi);
        } else {
            System.out.printf("Ihr BMI betraegt: %.2f. Sie haben Untergewicht! %n", bmi);
        }
    }
}