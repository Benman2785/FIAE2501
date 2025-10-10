public class Letters {
    public static void main(String[] args) {
        
        int j = 1;

        for (int i = 65; i <= 122; i++) {

            if(i > 90 && i < 97){
                continue;
            }

            System.out.print((char) i + " ");

            if (j % 10 == 0){
                System.out.println();
            }
            j++;
        }
    }
}
