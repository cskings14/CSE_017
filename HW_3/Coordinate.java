public class Coordinate extends Pair<Integer, Integer> {
    public Coordinate(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return super.getFirst();
    }

    public int getY() {
        return super.getSecond();
    }

    public void setX(int x) {
        super.setFirst(x);
    }

    public void setY(int y) {
        super.setSecond(y);
    }

    public void translateX(int d){
        super.setFirst(super.getFirst() + d);

    }

    public void translateY(int d){
        super.setSecond(super.getSecond() + d);
    }

    public void scaleX(int f){
        super.setFirst(super.getFirst() * f);
    }

    public void scaleY(int f){
        super.setSecond(super.getSecond() * f);
    }

    public boolean equals(Object obj){
        if(obj instanceof Coordinate){
            Coordinate c = (Coordinate) obj;
            return super.getFirst() == c.getX() && super.getSecond() == c.getY();
        }
        return false;
    }

    public String toString(){
        return "(" + super.getFirst() + ", " + super.getSecond() + ")";
    }

    
}
    

