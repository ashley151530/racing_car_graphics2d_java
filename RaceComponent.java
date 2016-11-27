/**
 * The RaceComponent class draws two cars and the finish line for the race
 * @author Ashley Handoko
 * Period: 3
 * Date: 09-22-14
 */

//import statements
import javax.swing.JComponent;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Font;

public class RaceComponent extends JComponent
{
	//instatiate variables
	private Car car1;
	private Car car2;
	private Rectangle finishLine;
	
	//instantiate and declare variables
	private String winner = "";
	
	//instantiate and declare constants
	private static final int FINISH_LINE_WIDTH = 150;
	private static final int STOP_FINISH_LINE = 1085;
	private static final int X_LOC_CAR = 5;
	private static final int Y_LOC_CAR_1 = 225;
	private static final int Y_LOC_CAR_2 = 500;
	
	/** Calls the method to instantiate the two cars in the race
	 */
    public RaceComponent() 
    {
    	startRace();
    }
    
    /** Draws the 2 cars and the finish line
     *  @param gr the graphics context for drawing
     */
	public void paintComponent(Graphics gr)
    {	
    	Graphics2D g2 = (Graphics2D)gr;
    	int width = getWidth();
   		int height = getHeight();
   		//draw cars
    	car1.draw(g2);
    	car2.draw(g2);
    	
    	//draw finish line
    	finishLine = new Rectangle(width - FINISH_LINE_WIDTH, 0, FINISH_LINE_WIDTH, height);	
    	int xGradient = 5;
		int yGradient = height / 2 + 10;
		g2.setPaint(new GradientPaint(xGradient, yGradient - height/2, Color.BLUE, xGradient + width, yGradient - height/2, Color.CYAN));
		g2.fill(finishLine);
		
		//display results of number of wins for each car
		g2.setColor(Color.MAGENTA);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 24);
		g2.setFont(f);
		g2.drawString("WINNER IS:" + winner, width/2, height - 10);
		
		
    }
    
    /** Moves each car forward by a random number of pixels in the range [1,5] and repaints the picture
     */
    public void advanceCars()
    {
    	int moveRan1 = (int) (Math.random()* 5 + 1 );
    	car1.moveForward(moveRan1);
    	repaint();
		int moveRan2 = (int) (Math.random()* 5 + 1 );    
		car2.moveForward(moveRan2);
    	repaint();
    	
    }
    
    /**	Stops the movement of the cars at the location where they are at the moment
     */
    public void stopCars()
    {
    	car1.moveForward(0);
    	car2.moveForward(0);
    }
    
    
    /** Returns whether or not at least 1 car has crosses the finish line 
     */
    public boolean isRaceOver()
    {
    	if(car1.getBox().getMaxX() >= STOP_FINISH_LINE || car2.getBox().getMaxX() >= STOP_FINISH_LINE)
    	{
    		if(car1.getBox().getMaxX() >= STOP_FINISH_LINE)
     			winner = " Car 1 ";
     		else
     			winner = " Car 2 ";
     		return true;
     		
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    /** Instantiates the two cars in the race
     */
    public void startRace()
    {
    	car1 = new Car( X_LOC_CAR,Y_LOC_CAR_1);
    	car2 = new Car( X_LOC_CAR,Y_LOC_CAR_2);
    }
  
    
}