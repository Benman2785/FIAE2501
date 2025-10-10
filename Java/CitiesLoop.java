public class CitiesLoop {
    public static void main(String[] args) {

        String wohnort = "Berlin - ";
        
        String[] staedte = {"Hamburg","Kopenhagen","Paris","Praha","Amsterdam"};
        int[] entfernungen = {284,355,878,345,658};

        for(int i = 0; i < staedte.length; i++){

            String stadt = staedte[i];
            int entfernung = entfernungen[i];

            System.out.println(wohnort + stadt + ": " + entfernung + "km gespeichert");
        }

        for(int i = 0; i < 100; i = i + 2){
            System.out.println(i);
        }
    }
}
