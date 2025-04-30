public class EntfernungArray {
    public static void main(String[] args) {
        String[] Urlaubsziele = new String[] {"Malediven, Gan","London","Sansibar","Malta","Griechenland, Kreta"};
        int[] Entfernungen = new int[] {8087,932,6967,1851,2181};
        String berlin = "Berlin";
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        for (int i = 0; i < Urlaubsziele.length; i++) {
            String ziel = Urlaubsziele[i];
            int km = Entfernungen[i];
            System.out.printf("%-6s - %-20s: %20dkm %n", berlin, ziel, km);
        }
        System.out.println("now Reverse");
        for (int i = Urlaubsziele.length -1; i >= 0; i--) {
            String ziel = Urlaubsziele[i];
            int km = Entfernungen[i];
            System.out.printf("%-6s - %-20s: %20dkm %n", berlin, ziel, km);
        }
    }
}