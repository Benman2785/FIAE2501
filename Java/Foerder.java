public class Foerder {

    public static void main(String[] args) {
        
        int[] geburtsjahre = {1920,1955,1975,2001};

        for(int geburtsjahr : geburtsjahre){
            System.out.print(geburtsjahr + " ");
        }
        System.out.println();
       
        for(int i = 0;i < geburtsjahre.length;i++ ){
            System.out.print(geburtsjahre[i] + "_");
        }

        System.out.println();
        for(int i = 1; i <= 50; i++){
            System.out.print(i*2 + " ");
        }

        

    }
}