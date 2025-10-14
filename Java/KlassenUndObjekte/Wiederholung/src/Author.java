public class Author {
    private String name;
    private String lastname;
    private BirthPlace birthPlace;

    public Author(String name, String lastname, BirthPlace birthPlace){
        this.name = name;
        this.lastname = lastname;
        this.birthPlace = birthPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.name = lastname;
    }

    public BirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(BirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }
}
