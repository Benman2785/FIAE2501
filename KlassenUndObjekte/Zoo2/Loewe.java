public class Loewe extends Tier {
    public Loewe(String name, String gattung, double gewicht) {
        super(name, gattung, gewicht);
    }
    @Override
    public void gehen(){
        System.out.println(this.getName() + " liegt nicht mehr faul im Gras sondern wuchtet sich hoch und taumelt 3 Schritte");
    }
    @Override
    public void fressen(){
        System.out.println(this.getName() + " vergenussferkelt ein Gnu...");
    }
    public void bruellen(){
        System.out.println(this.getName() + " macht Rrrroooharrr");
    }
    public void jagen(){
        System.out.println(this.getName() + " pirscht sich an die/den/das Pfleger(in/ens) an und reisst sie/ihn/es in Stuecke...");
    }
}