public class Main {
    public static void main(String[] args) {
        Hund h1 = new Hund("Anouk", 7, "Ball", "Frana");
        Katze k1 = new Katze("Miri", 11, "BFW-Sklaven");
    // Tier t1 = new Tier("ELWMS", 42); KANN NICHT INSTANZIIERT WERDEN
        h1.makeSound();
        k1.makeSound();
    // t1.makeSound();
    }
}
