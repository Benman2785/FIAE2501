package Fussball;

import java.util.Random;

public class Spieler extends Person {
    private String name;
    private int alter;
    private int trefferQuote;
    private String position;
    private int toreErzielt;
    private Trainer trainer;

    public Spieler(String name, int alter, String position, int toreErzielt, int trefferQuote, Trainer trainer){
        super(name, alter);
        this.position = position;
        this.toreErzielt = toreErzielt;
        this.trefferQuote = trefferQuote;
        this.trainer = trainer;
    }

    public int getTrefferQuote() {
        return trefferQuote;
    }

    public void setTrefferQuote(int trefferQuote) {
        this.trefferQuote = trefferQuote;
    }

    public String getSNachName() {
        return name;
    }

    public void setSNachName(String name) {
        this.name = name;
    }

    public int getSAlter() {
        return alter;
    }

    public void setSAlter(int alter) {
        this.alter = alter;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getToreErzielt() {
        return toreErzielt;
    }

    public void setToreErzielt(int toreErzielt) {
        this.toreErzielt = toreErzielt;
    }

    @Override
    public String toString(){
        return "[Name: " + 
        super.toString() 
        + ", Position: " + position 
        + ", Tore erzielt: " + toreErzielt 
        + ", Trainer: " + trainer.toStringCombi();
    }

    public static int rand(){
        Random rand = new Random();
        int n = rand.nextInt(101);
        return n;
    }
    public void versucheTor(int trefferQuote){
        int trefferQuote2 = (getTrefferQuote() + (trainer.getErfahrung() / 2));
        if (rand() <= trefferQuote2 ){
            toreErzielt++;
        }
    }

}
