public class Hund extends Tier {
    private String lieblingsSpielzeug;
    private String besitzer;
    
    public Hund (String name, int alter, String lieblingsSpielzeug, String besitzer){
        super(name, alter);
        this.lieblingsSpielzeug = lieblingsSpielzeug;
        this.besitzer = besitzer;
    }
}