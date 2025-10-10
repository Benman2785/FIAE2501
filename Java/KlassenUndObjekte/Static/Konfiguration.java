public class Konfiguration {
    private static String standardSprache = "de";
    // private int anzahl;

    public static String getStandardSprache(){
        return standardSprache;
    }
    public static void setStandardSprache(String standardSprache){
        Konfiguration.standardSprache = standardSprache;
    }
    // public void setAnzahl(int anzahl){
    //     this.anzahl = anzahl;
    // }
    // public int getAnzahl(){
    //     return anzahl;
    // }
}
