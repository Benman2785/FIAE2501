public class Person {
    // Eigenschaften, Instanzvariablen, Attribute
    private String vorname;
    private int alter;
    private double gehalt;
    private int id;

    // getter
    public String getVorname(){
        return vorname;        
    }
    public int getAlter(){
        return alter;        
    }
    public double getGehalt(){
        return gehalt;
    }
    public int getId(){
        return id;        
    }
    // setter
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    public void setAlter(int alter){
        fixAlter(alter);
        this.alter = alter;
                
    }
    public void setGehalt(double gehalt){
        fixGehalt(gehalt);
        this.gehalt = gehalt;

    }
    public void setId(int id){
        fixId(id);
        this.id = id;
    }

    // logik
    public void fixAlter(int alter) {
        if (alter <= 0){
            System.out.println("Alter ist 0 oder negativ");
        }
    }
    public void fixGehalt(double gehalt) {
        if (gehalt <= 0){
            System.out.println("Gehalt ist 0 oder negativ");
        }
    }
    public void fixId(int alter) {
        if (id <= 0){
            System.out.println("ID ist 0 oder negativ");
        }
    }
}
