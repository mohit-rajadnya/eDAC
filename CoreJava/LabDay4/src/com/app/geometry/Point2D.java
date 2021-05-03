//userdefined package meant for function separation
package com.app.geometry;
import java.lang.Math;
//class representing a point in x-y coordinate system
public class Point2D
{
	//state : x,y : tight encapsulation : private
	private int x, y;
	//parameterised ctor to initialise x,y
	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String getDetails()
	{
		return "The point is at" + "(" + x + " , " + y + ")"; 
	}
	
	public boolean isEqual(Point2D anotherPoint)
	{
		return (this.x == anotherPoint.x)&& (this.y == anotherPoint.y);
	}
	//New method to create a point with offset from particular point
	public Point2D createNewPoint(int xOff , int yOff)
	{
		Point2D newPoint = new Point2D(this.x+xOff , this.y+yOff);
		return newPoint;
	}
	
	public double calcDistance(Point2D newPoint)
	{
		return Math.sqrt(((Math.pow(this.x,2))-(Math.pow(newPoint.x,2)))+((Math.pow(this.y,2))-(Math.pow(newPoint.y,2))));
	}			

}
















