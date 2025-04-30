public class ForLoop {
    public static void main(String[] args) {

        int [] arr = new int[10];
        
        for (int i = 0; i < 10; i++) {
            
            arr[i] = i+100;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
