public class MatrixAusgabe {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Ausgabe von 1 bis 9");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.printf("%nAusgabe von 9 bis 1%n");
        for (int k = matrix.length - 1; k >= 0; k--) {
            for (int l = matrix[k].length - 1; l >= 0; l--) {
                    System.out.print(matrix[k][l] + " ");
            }
        }
    }
}