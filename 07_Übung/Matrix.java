public class Matrix {
    private MatrixEntry[][] matrix;
    private int spalten;
    private int zeilen;

    public Matrix(int spalten, int zeilen) {
        matrix = new MatrixEntry[spalten][zeilen];
        for(int i = 0; i < spalten; i++)
            for(int j = 0; j < zeilen; j++)
                matrix[i][j] = new MatrixEntry();
        this.spalten = matrix.length;
        this.zeilen = matrix[0].length;
    }

    public void gauss() {
        int offset = 0;
        for(int j = 0; j < zeilen; j++) {
            while(matrix[j + offset][j].getZahl() == 0.0)
                offset++;
            double teiler = matrix[j + offset][j].getZahl();
            for(int k = j + 1; k < zeilen; k++) {
                double teiler2 = matrix[j + offset][k].getZahl();
                if(teiler2 == 0.0)
                    continue;
                for(int i = j + offset; i < spalten; i++) {
                    double zahl = matrix[i][k].getZahl();
                    double newZaehler = zahl - (teiler2 / teiler) * matrix[i][j].getZahl();
                    matrix[i][k].setZahl(newZaehler);
                }
            }
            int[] firstIndexPerRow = new int[zeilen];
            for(int k = 0; k < zeilen; k++) {
                int index = k;
                while(matrix[index][k].getZahl() != 0) {
                    if(index == spalten - 1) {
                        firstIndexPerRow[k] = index;
                        break;
                    }
                    index++;
                }
                if(index < spalten - 1)
                    firstIndexPerRow[k] = index;
            }
            for(int k = 0; k < zeilen; k++)
                for(int l = k + 1; l < zeilen; l++)
                    if(firstIndexPerRow[k] > firstIndexPerRow[l]) {
                        for(int i = 0; i < spalten; i++) {
                            MatrixEntry hilfe = matrix[i][k];
                            matrix[i][k] = matrix[i][l];
                            matrix[i][l] = hilfe;
                        }
                    }
        }
    }

    public void jordan() {
        int offset = 0;
        for(int j = zeilen - 1; j > 0; j--) {
            while(matrix[j + offset][j].getZahl() == 0.0)
                offset--;
            double teiler = matrix[j + offset][j].getZahl();
            for(int k = j - 1; k >= 0; k--) {
                double teiler2 = matrix[j + offset][k].getZahl();
                if(teiler2 == 0.0)
                    continue;
                for(int i = 0; i < spalten; i++) {
                    double zahl = matrix[i][k].getZahl();
                    double newZaehler = zahl - (teiler2 / teiler) * matrix[i][j].getZahl();
                    matrix[i][k].setZahl(newZaehler);
                }
            }
        }
    }

    public void gaussJordan() {
        gauss();
        jordan();
    }

    public void createNew() {
        for(int i = 0; i < spalten; i++)
            for(int j = 0; j < zeilen; j++)
                matrix[i][j] = new MatrixEntry();
    }

    @Override
    public String toString(){
        String result = "";
        for(int j = 0; j < zeilen; j++) {
            for(int i = 0; i < spalten; i++)
                result += matrix[i][j] + " ";
            result += "\n";
        }
        return result;
    }
}
