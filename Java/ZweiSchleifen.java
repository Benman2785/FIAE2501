public class ZweiSchleifen {
    public static void main(String[] args) {
        cls();
        System.out.println("Nummernschilder");
        ausgabe();
    }
    static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void ausgabe() {
        char[] letters = {'A', 'B', 'C'};
        
        for (int y = 0; y < letters.length; y++) {
            for (int z = 0; z < letters.length; z++) {
                for(int i = 1; i <= 3; i++){
                    for (int j = 1; j <= 3; j++){
                        System.out.println("B-" + letters[y] + letters[z] + "-" + i + "" + j);
        }}}}

    }   
}
