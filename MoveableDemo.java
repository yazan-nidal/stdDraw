import java.util.*;

public class MoveableDemo {
    ArrayList<Moveable> movers;
    
    public MoveableDemo() {
        movers = new ArrayList<Moveable>();
        
        movers.add(new Circle(2, 2, 2.5, StdDraw.BLUE, StdDraw.DEFAULT_CLEAR_COLOR));
        movers.add(new Square(0, -4, 3, StdDraw.RED, StdDraw.DEFAULT_CLEAR_COLOR));
        movers.add(new Square(-5, 3, 3.4, StdDraw.BLACK, StdDraw.DEFAULT_CLEAR_COLOR));
        
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
    }
    
    private void drawAll() {
        for (Moveable m: movers) {
            ((Shape)m).draw();
        }
    }

    private void moveAll(int dx, int dy) {
        for (int i = 0; i < 5; i++) {
            for (Moveable m: movers) {
                m.move(dx, dy);
            }
        }
    }

    private void resizeAll(double s) {
        for (Moveable m: movers) {
            ((Shape)m).resize(s);
        }
    }
    
    private void shrink(int n, double s) {
        for (int i = 0; i < n; i++) {
            resizeAll(s);
        }
    }
       
    public static void main(String[] args) {
        MoveableDemo sd = new MoveableDemo();
        
        sd.moveAll(1, 1);
        sd.moveAll(-1, 0);
        sd.moveAll(0, -1);
        sd.resizeAll(.75);
        sd.moveAll(1, -1);
        sd.moveAll(-1, 0);
        sd.moveAll(0, 1);
        sd.resizeAll(.75);
        sd.moveAll(-1, -1);
        sd.shrink(5, .75);
        
    }
}