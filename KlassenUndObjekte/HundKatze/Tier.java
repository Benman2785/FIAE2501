abstract class Tier {
    protected String name;
    protected int alter;
    
    public Tier(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public void makeSound(){
        System.out.print(name + " macht Krach -> ");
    }
}
