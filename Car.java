/**
 * The Car class uses multiple shapes to construct the picture of the car 
 * @author Ashley Handoko
 * Period: 3
 * Date: 09-22-14
 */
 
//import statements 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Line2D;

public class Car implements Racer
{
	//declare variables
	private int xLoc;
	private int yLoc;
	private Color carColor;
	
	//declare and instantiate constants
	private static final int RECT_WIDTH = 200;
	private static final int RECT_HEIGHT = 50; 
	private static final int DIST_WHEEL_X = 10;
	private static final int DIST_WHEEL_Y = 40;
	private static final int DIST_WINDOW_X = 10;
	private static final int DIST_WINDOW_Y = 15;
	private static final int WHEEL_SIZE = 30;
	

	/** Accepts the (x,y) of the upper left corner of the bounding rectangle that ecompasses the shapes of this car
	 *	Also accepts the color for each car object
	 *	@param x x coordinate of bounding rectangle
	 *	@param y y coordinate of bounding rectangle
	 *	@parm color color of each car object
	 */
    public Car(int x, int y) 
    {
    	xLoc = x;
    	yLoc = y;
    	carColor = new Color((float) Math.random(), (float) Math.random(),(float) Math.random());			    	
    }
    
   	/** Draws the racer using the given graphics context
	 *  @param gr the graphics context for drawing
	 */
	public void draw(Graphics2D gr)
	{
		
		Graphics2D g2 = (Graphics2D)gr;
		//draw top of car
		Ellipse2D.Double topCar = new Ellipse2D.Double(xLoc + RECT_WIDTH / 6, yLoc - RECT_HEIGHT / 1.25 , RECT_WIDTH / 1.5 , RECT_HEIGHT * 1.5 );
		gr.setColor(carColor);
		gr.fill(topCar);
		
		//draw windows
		gr.setColor(Color.WHITE);
		Ellipse2D.Double windows = new Ellipse2D.Double(xLoc + RECT_WIDTH / 4, yLoc - RECT_HEIGHT / 1.5 , RECT_WIDTH / 2 , RECT_HEIGHT * 1.2 );
		gr.fill(windows);

		//draw bottom of car
		gr.setColor(carColor);
		gr.fill(getBox());
		
		//create wheels
		gr.setColor(Color.WHITE);
		Ellipse2D.Double circle1 = new Ellipse2D.Double(xLoc + DIST_WHEEL_X, yLoc + DIST_WHEEL_Y, WHEEL_SIZE,WHEEL_SIZE);
		Ellipse2D.Double circle2 = new Ellipse2D.Double(xLoc + RECT_WIDTH - 4 * DIST_WHEEL_X, yLoc + DIST_WHEEL_Y, WHEEL_SIZE, WHEEL_SIZE);
		gr.fill(circle1);
		gr.fill(circle2);
		gr.setColor(Color.BLACK);
		gr.draw(circle1);
		gr.draw(circle2);
		
	}
	
	/** Advances the racer forward in the race by amount
	 *  @param amount the number of pixels to advance
	 */
    public void moveForward(int amount)
    {
    	xLoc += amount;	
    }
    
    /** Retrieves the shape's bounding rectangle
     *  @return the bounding rectangle that encompasses this shape
     */
    public Rectangle getBox()
    {
    	return new Rectangle(xLoc, yLoc, RECT_WIDTH, RECT_HEIGHT);
    
    }
}