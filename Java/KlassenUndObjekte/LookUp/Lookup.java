import java.util.ArrayList;

public class Lookup {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {3, 4, 2},
            {5, 2, 6}
        };
        // int[][] matrix = {
        //     {1, 2, 3, 4},
        //     {3, 8, 2, 9},
        //     {10, 2, 5, 2},
        //     {2, 7, 8, 1}
        // };
        int vWert1 = 0;
        int vWert2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i + 1 == matrix.length){break;};
            ArrayList<Integer> foundValues = new ArrayList<>();
            System.out.println("Vergleiche Zeile " + i + " mit Zeile " + (i + 1));
            for (int j = 0; j < matrix[i].length; j++) {
                vWert1 = matrix[i][j];
                try {
                    for (int k = 0; k < matrix[i + 1].length; k++) {
                        vWert2 = matrix[i + 1][k];
                        if (vWert1 == vWert2 && !foundValues.contains(vWert1)){
                            System.out.println("Wert " + vWert2 + " kommt auch in der nächsten Zeile vor");
                            foundValues.add(vWert1);
                            break;
                    }
                }
            } catch (Exception e) {
                break;
                }
            }
        }
    }
}
