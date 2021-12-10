import java.awt.*;
import javax.swing.*;
import java.awt.Color;

// interface is a Full Abstract but not put  abstract word in declared and it always be public
// dealing with interface , as dealing with the abstract class , and methods has no body it is abstract method to must be override it
// any variable declared in interface be -public final static- by default

// default interface contain one method -move- must be override it
interface Moveable
{
	public void move(int x1 , int y1);
}

// abstract class can't be instantiation object , just references variable as pointer in c++
// implements from interface -Moveable- ,must be override all function -move function- in interface -Moveable-
public abstract class Shape implements Moveable //SuperClass -base class-
{

    // attributes
	protected int x;
	protected int y;
	protected Color mycolor;
	protected Color background;


    // parameterized constructor
 	public Shape(int x1, int y1, Color color, Color ground)
	{
		this.x=x1;
		this.y=y1;
		this.mycolor=color;
		this.background=ground;

	  StdDraw.setXscale(-20, 20);  //set the x range from -20 to 20
      StdDraw.setYscale(-20, 20);  //set the y range from-20 to 20

	}

	//not important methods
	//public int getX(){ return x; }
	//public int getY(){ return y; }
	//public void setX(int x1){ this.x=x1; }
	//public void setY(int y1){ this.y=y1; }

	//abstract method must be override in derived class
	public abstract void draw();
	public abstract void clear();
	public abstract void resize(double s);

	//overridden move method from interface -Moveable-
	public void move(int x1 , int y1)
	{
		clear();    // clear the shape
		x=(x+x1);  // delta-x:(x2-x1) : move x axis
		y=(y+y1); // delta-y:(y2-y1) : move y axis
		draw();  // draw the shape after move to new point
		//clear();
	}

}

//derived class from SuperClass -Shape-
class Circle extends Shape
{
	// It contains SuperClass attributes
	// new attributes
	private double radius;

	// parameterized constructor
	public Circle(int x1, int y1, double r, Color color, Color ground)
	{
		super(x1,y1,color,ground);// SuperClass constructor
		if(r <= 0.0){ throw new IllegalArgumentException("must be Radius > 0.0");/* inline Exception handing */ } else{ this.radius = r; }
	}

	//not important methods
	//public double getRadius(){ return radius; }

	public void draw()
	{
	  double x1=x; double y1=y; //point(x,y)

	  StdDraw.setPenColor(mycolor);	// set color of pen to mycolor
	  //StdDraw.circle(x1,y1,radius); //draw circle border in point(x,y) with radius
	  //StdDraw.setPenColor(mycolor);
	  StdDraw.filledCircle(x1,y1,radius); //fill that circle by color mycolor

	  StdDraw.show(100); //delay 100ms
	}

	public void clear()
	{
		//just clear this shape not all screen
		StdDraw.setPenColor(background); // set color of pen to background color
		StdDraw.filledCircle(x,y,radius); // re fill shape with background color to clear shape
		StdDraw.setPenColor(mycolor); // re set color of pen to mycolor

		/* i can use this method "StdDraw.clear(background);" but this clear all screen and i want just clear this shape ,so i do it by that way */
		//StdDraw.clear(background);
	}

	public void resize(double s)
	{
		/*
		   Note:
		   the factor S must be number between 0.0 and 1.0 "(s <= 0.0 || s > 1)"
		   but it used in ShapeDemo test and MoveableDemo test by factor S biger than 1.0 to  resize to big size
		   so i be it to be between 0.0 and 2.0 "(s <= 0.0 || s > 2)"
		*/
		if(s <= 0.0 || s > 2){ throw new IllegalArgumentException("must be Radius > 0.0 and Radius <= 2"); /* inline Exception handing */ }
		else
		 {
			this.clear();  // clear old shape
			this.radius *= s; // re set size -radius-
			this.draw();  // re draw shape with new size
		 }
	}

}

//derived class from SuperClass -Shape-
class Square  extends Shape
{
	// It contains SuperClass attributes
	// new attributes
	private double length;

	// parameterized constructor
	public Square(int x1, int y1, double len, Color color, Color ground)
	{
		super(x1,y1,color,ground); // SuperClass constructor
		if(len <= 0.0){ throw new IllegalArgumentException("must be Length > 0.0"); /* inline Exception handing */ } else{ this.length = len; }
	}

	//not important methods
	//public double getLength(){ return length; }

	public void draw()
	{
	  	  double x1=x; double y1=y; //point(x,y)

	  	  StdDraw.setPenColor(mycolor); // set color of pen to mycolor
	  	  //StdDraw.square(x1,y1,length); //draw square border in point(x,y) with length
	  	  //StdDraw.setPenColor(mycolor);
	      StdDraw.filledSquare(x1,y1,length); //fill that square by color mycolor

	      StdDraw.show(100); //delay 100ms
	}

	public void clear()
	{
		//just clear this shape not all screen
		StdDraw.setPenColor(background); // set color of pen to background color
		StdDraw.filledSquare(x,y,length); // re fill shape with background color to clear shape
		StdDraw.setPenColor(mycolor); // re set color of pen to mycolor

		/* i can use this method "StdDraw.clear(background);" but this clear all screen and i want just clear this shape ,so i do it by that way */
		//StdDraw.clear(background);
	}

	public void resize(double s)
	{
		/*
		   Note:
		   the factor S must be number between 0.0 and 1.0 "(s <= 0.0 || s > 1)"
		   but it used in ShapeDemo test and MoveableDemo test by factor S biger than 1.0 to  resize to big size
		   so i be it to be between 0.0 and 2.0 "(s <= 0.0 || s > 2)"
		*/
		if(s <= 0.0 || s > 2){ throw new IllegalArgumentException("must be Length > 0.0 and Length <= 2"); /* inline Exception handing */ }
		else
		 {
		   this.clear(); // clear old shape
		   this.length *= s; // re set size -length-
		   this.draw(); // re draw shape with new size
		 }

	}

}