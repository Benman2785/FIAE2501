//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // neue Personen-Objekte erzeugen
        int x = 5;
        Person p1 = new Person();
        Person p2 = new Person();

        System.out.println("_________________________________");
        System.out.println(p1.getVorname());
        System.out.println(p1.getAlter());
        System.out.println(p1.getGehalt());
        System.out.println("_________________________________");
        System.out.println(p2.getVorname());
        System.out.println(p2.getAlter());
        System.out.println(p2.getGehalt());
        System.out.println("_________________________________");

        p1.setVorname("Martin");
        p1.setAlter(46);
        p1.setGehalt(100.11);
        p1.setId(1);

        p2.setVorname("Martina");
        p2.setAlter(45);
        p2.setGehalt(541.12);
        p2.setId(2);

        System.out.println("_________________________________");
        System.out.println(p1.getVorname());
        System.out.println(p1.getAlter());
        System.out.println(p1.getGehalt());
        System.out.println("_________________________________");
        System.out.println(p2.getVorname());
        System.out.println(p2.getAlter());
        System.out.println(p2.getGehalt());
        System.out.println("_________________________________");



    }
}