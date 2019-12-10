public class GaussJordan {
    public static void main(String[] args) {
        Matrix matrix;
        if(args.length >= 2) {
            matrix = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }else {
            matrix = new Matrix(4, 3);
        }
        System.out.println(matrix);
        matrix.gauss();
        System.out.println(matrix);
        matrix.jordan();
        System.out.println(matrix + "\n");
        matrix.createNew();
        System.out.println(matrix);
        matrix.gaussJordan();
        System.out.println(matrix);
    }
}
