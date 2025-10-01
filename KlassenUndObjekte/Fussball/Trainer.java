package Fussball;

public class Trainer extends Person{
    private int erfahrung;
    private String name;
    private int alter;

    public Trainer(String name, int alter, int erfahrung){
        super(name, alter);
        this.erfahrung = erfahrung;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        this.erfahrung = erfahrung;
    }

    public String getTName() {
        return name;
    }

    public void setTName(String name) {
        this.name = name;
    }

    public int getTAlter() {
        return alter;
    }

    public void setTAlter(int alter) {
        this.alter = alter;
    }
    
    @Override
    public String toString(){
        return "[Name: " 
        + super.toString()
        + ", Erfahrung: " + erfahrung + " Jahre]";
    }
    public String toStringCombi(){
        return super.toString()
        + ", Erfahrung: " + erfahrung + " Jahre]";
    }
}
