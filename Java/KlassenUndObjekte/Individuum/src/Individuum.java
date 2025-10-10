
import java.util.Calendar;

public class Individuum {
    private String name;
    private int alter;
    private double groesse;
    private double gewicht;
    private String haarfarbe;
    private int gebJahr;
    private static int aktJahr = Calendar.getInstance().get(Calendar.YEAR);
    public static int count;
    private int id;

// Constructor
public Individuum(String name, double groesse, double gewicht, String haarfarbe, int gebJahr){
    this.name = name;
    this.alter = aktJahr - gebJahr;
    this.groesse = groesse;
    this.gewicht = gewicht;
    this.haarfarbe = haarfarbe;
    this.gebJahr = gebJahr;
    count++;
    id = count;
}
// getter
public int getCount(){
    return count;
}
public String getName(){
    return name;
}
public int getAlter(){
    return alter;
}
public int getGebJahr(){
    return gebJahr;
}
public double getGroesse(){
    return groesse;
}
public double getGewicht(){
    return gewicht;
}
public String getHaarfarbe(){
    return haarfarbe;
}
// setter
public void setName(String name){
    this.name = name;
}
public void setGroesse(double groesse){
    if (groesse < 0){
        System.out.println("Größe kleiner 0...");
    } else {
        this.groesse = groesse;
    }
}
public void setGewicht(double gewicht){
    if (gewicht < 0){
        System.out.println("Alter kleiner 0...");
    } else {
        this.gewicht = gewicht;
    }
}
public void setHaarfarbe(String haarfarbe){
    this.haarfarbe = haarfarbe;
}
}