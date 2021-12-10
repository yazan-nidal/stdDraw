import java.util.*;

public class ShapeDemo {

    private Circle cir;
    private Square sq1;
    private Square sq2;
    
    public ShapeDemo() {
        cir = new Circle(2, 2, .25, StdDraw.BLUE, StdDraw.DEFAULT_CLEAR_COLOR);
        sq1 = new Square(0, -4, .3, StdDraw.RED, StdDraw.DEFAULT_CLEAR_COLOR);
        sq2 = new Square(-6, 3, .35, StdDraw.BLACK, StdDraw.DEFAULT_CLEAR_COLOR);
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
    }
    
    private void resizeAll(double s) {
        cir.resize(s);
        sq1.resize(s);
        sq2.resize(s);       
    }
    
    private void displayAll() {
        cir.draw();
        sq1.draw();
        sq2.draw();
    }
    
    public static void main(String[] args) {
        ShapeDemo sd = new ShapeDemo();
        
        sd.displayAll();
        
        for (int i = 0; i < 11; i ++) {
            sd.resizeAll(1.25);
        }

        for (int i = 0; i < 8; i++) {
            sd.resizeAll(.75);
        }     
    }
}