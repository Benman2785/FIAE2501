public class BirthPlace {
    private String ortsname;
    private String plz;
    private int population;

    public BirthPlace(String ortsname, String plz, int population) {
        this.ortsname = ortsname;
        this.plz = plz;
        this.population = population;
    }

    public String getOrtsname() {
        return ortsname;
    }
    public void setOrtsname(String ortsname) {
        this.ortsname = ortsname;
    }
    public String getPlz() {
        return plz;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
}
