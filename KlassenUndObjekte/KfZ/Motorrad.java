public class Motorrad extends Kfz {
    public Motorrad(String marke, String modell) {
        super(marke, modell);
    }
    @Override
    public void gepaeckFach() {
        System.out.println("Motorrad hat ein Topcase!");
    }
    @Override
    public String toString() {
        return "Motorrad [Marke= " + marke + ", Modell= " + modell + ", Geschwindigkeit= " + geschwindigkeit + "km/h]";
    }
    @Override
    public void beschleunigen(int wert) {
        System.out.print("Motorad heult auf und ");
        super.beschleunigen(wert);
    }

    @Override
    public void bremsen(int wert){
        System.out.print("Motorad ");
        super.bremsen(wert);
    }
}