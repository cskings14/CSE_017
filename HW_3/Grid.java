public class Grid<E1> {

    private ArrayList<E1> cells;
    private int rows;
    private int cols;

    /**
     * Constructor for the class Grid
     * @param rows number of rows
     * @param cols number of columns
     */

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cells = new ArrayList<E1>();
        for (int i = 0; i < rows * cols; i++) {
            cells.add(null);
        }

    public Grid(E1[][] array){
        this.rows = array.length;
        this.cols = array[0].length;
        cells = new ArrayList<E1>();
        for (int i = 0; i < rows * cols; i++) {
            cells.add(null);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                set(i, j, array[i][j]);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void checkRows(int rows){
        if (rows < 0 || rows > this.rows) {
            throw new ArrayIndexOutOfBoundsException("Invalid row number");
        }

    }

    public void checkCols(int cols){
        if (cols < 0 || cols > this.cols) {
            throw new ArrayIndexOutOfBoundsException("Invalid column number");
        }
    }
    public E get(int row, int col) {
        checkRows(row);
        checkCols(col);
        return (E) cells.get(row * cols + col);
    }

    public void set(int row, int col, E value) {
        checkRows(row);
        checkCols(col);
        cells.set(row * cols + col, value);
    }

    public toString() {
        String s = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                s += get(i, j) + " ";
            }
            s += "\n";
        }
        return s;
    }
    
}
