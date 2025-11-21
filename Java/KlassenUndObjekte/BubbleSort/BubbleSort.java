public class BubbleSort {
    public static void main(String[] args) {
        /*
         * Beginn BubbleSort
         * 
         * arr := Array von Int
         * 
         * For i := 0 bis arr.length -1
         *  boolean tausch := false
         *  For j := 0 bis arr.length - i -1
         *   If arr[j] > arr[j + 1] then
         *    temp := arr[j]
         *    arr[j] := arr[j + 1]
         *    arr[j + 1] := temp
         *    tausch := true
         *  End For
         *  If tausch := true then
         *  break;
         *  End If
         * End For
         * 
         * End BubbleSort
         */
        int[] sort = {9, 3, 1, 2, 5, 6, 4, 11, 8, 10, 7, 12};
        int laenge = sort.length;

        for (int n = 0; n < sort.length; n++) {
            System.out.print(sort[n] + " ");
        }
        System.out.println("");
        for (int i = 0; i < laenge; i++) {
            boolean tausch = false;
            for (int j = 0; j < (laenge - i - 1); j++) {
                if (sort[j] > sort[j + 1]) {
                    int temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                    tausch = true;
                }
            }
            if (tausch == false) {
                break;
            }
        }
        for (int n = 0; n < sort.length; n++) {
            System.out.print(sort[n] + " ");
        }
        System.out.println("");
    }
}