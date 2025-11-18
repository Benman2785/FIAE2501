public class Loewe extends Tier {
    public Loewe(String gattung, double gewicht) {
        super(gattung, gewicht);
    }
    @Override
    public void gehen(){
        System.out.println("Loewi liegt nicht mehr faul im Gras sondern wuchtet sich hoch und taumelt 3 Schritte");
    }
    @Override
    public void fressen(){
        System.out.println("Loewi vergenussferkelt ein Gnu...");
    }
    public void bruellen(){
        System.out.println("Rrrroooharrr");
    }
    public void jagen(){
        System.out.println("Loewi pirscht sich an die/den/das Pfleger(in/ens) an und reisst sie/ihn/es in Stuecke...");
    }
}