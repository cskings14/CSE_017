public class ComparatorByDistance implements Comparator<Coordinate> {
    public int compare(Coordinate c1, Coordinate c2){
        int a = Math.sqrt(c1.getX() * c1.getX() + c1.getY() * c1.getY());
        int b = Math.sqrt(c2.getX() * c2.getX() + c2.getY() * c2.getY());
        return a - b;
    }
    
}
