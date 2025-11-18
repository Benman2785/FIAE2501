public class Author {
    private String name;
    private String birthPlace;

    public Author(String name, String birthPlace){
        this.name = name;
        this.birthPlace = birthPlace;
    }
    public void getName(String name){
        this.name = name;
    }
    public void getetBirthPlace(String birthPlace){
        this.birthPlace = birthPlace;
    }
    public String getName(){
        return name;
    }
    public String getBirthPlace(){
        return birthPlace;
    }

}
