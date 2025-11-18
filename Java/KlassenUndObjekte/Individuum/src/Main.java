import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Individuum i1 = new Individuum("Bugs Bunny", 1.82, 38.46, "grau", 1985);
        Individuum i2 = new Individuum("Duffy Duck", 1.78, 43.12, "schwarz", 1987);
        Individuum i3 = new Individuum("Tweety", 0.2, 0.15, "gelb", 1960);


        List<Individuum> liste = Arrays.asList(i1, i2, i3);

        for (Individuum ix : liste) {
            System.out.println(ix.getName());
            System.out.println(ix.getAlter());
            System.out.println(ix.getGroesse());
            System.out.println(ix.getGewicht());
            System.out.println(ix.getHaarfarbe());
        }
    }
}
