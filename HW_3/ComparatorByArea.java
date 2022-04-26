public class ComparatorByArea implements Comapator<Coordinate> {
    
    public int compare(Coordinate c1, Coordinate c2){
        int a = (c1.getX() * c1.getY()) / (1/2);
        int b = c2.getX() * c2.getY() / (1/2);
        return a - b;
    }
    

    
}
