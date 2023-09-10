
public class CartesianGrid {
    //important variables
    private final int x;
    private final int y;

    public CartesianGrid(int x, int y) {
        //overloaded constructor
        this.x = x;
        this.y = y;

    }
    //method to make a 2D array
    public String[][] gridMaker() {
        String[][] cartesianGrid = new String[x][y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                cartesianGrid[i][j] = "(" + Integer.toString(i) + ", " + Integer.toString(j) + ")";
            }
        }
        return cartesianGrid;
    }
    //method that takes a 2D array and prints it in a nice format
    public void gridPrinter(String[][] cartesianGrid) {
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {

                if (j == 0) {
                    System.out.print("[ " + cartesianGrid[i][j] + ", ");
                }
                else if (j == y - 1) {
                    System.out.println(cartesianGrid[i][j] + " ]");
                }

                else {
                    System.out.print(cartesianGrid[i][j] + ", ");
                }
            }
        }
    }

}
