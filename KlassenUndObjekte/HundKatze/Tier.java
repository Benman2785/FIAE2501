abstract class Tier {
    private String name;
    private int alter;
    
    public Tier(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public void makeSound(){
        System.out.println(name + " macht Krach");
    }
}
