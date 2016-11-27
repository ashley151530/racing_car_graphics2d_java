/**
 * The RaceViewer class creates a frame and components that draws the race, resetting the race when it is over
 * @author Ashley Handoko
 * Period: 3
 * Date: 09-22-14
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class RaceViewer
{
	public static void main(String[] args)
	{
		final int FRAME_WIDTH = 1250;
		final int FRAME_HEIGHT = 750;
		JFrame frame = new JFrame("Ready, Set, Go!");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		final RaceComponent add = new RaceComponent();
		frame.add(add);
		frame.setVisible(true);
		
		/**  Adds ClickListener which prints statement
		 */
		class ClickListener implements ActionListener
		{
		   public void actionPerformed(ActionEvent event)
		   {
		      System.out.println("Restart race?");
		   }            
		}
      	
	    JPanel panel = new JPanel();
	    JButton button = new JButton("Click to Start Race!");
	    panel.add(button);
	    frame.add(panel);
	    ActionListener cListener = new ClickListener();
	    button.addActionListener(cListener);
	     
	    /** Adds TimerListener which stops the race if the cars have already reached the finish line
	     */ 	      
	    class TimerListener implements ActionListener
	    {
	         public void actionPerformed(ActionEvent event)
	         {
	         	if(!add.isRaceOver())
	         	{
	         		add.advanceCars();	
	         	}
	         	else
	         	{
	         		add.stopCars();
	         	}
	         }
	     }
		
		/** Adds listener which resets the timer
		 */
		 ActionListener listener = new TimerListener();
		 final int DELAY_TIME = 15; // Milliseconds between timer ticks
		 Timer t = new Timer(DELAY_TIME, listener);
		 t.start();      
		 
		 /** Adds MouseListener which includes do nothing methods
		  */     
		 class MousePressListener implements MouseListener
	     {  
	        public void mousePressed(MouseEvent event)
	        {  
	           add.startRace();
	        }

	        // Do-nothing methods
	        public void mouseReleased(MouseEvent event) {}
	        public void mouseClicked(MouseEvent event) {}
	        public void mouseEntered(MouseEvent event) {}
	        public void mouseExited(MouseEvent event) {}
	     }
	        
	     MouseListener mListener = new MousePressListener();
	     add.addMouseListener(mListener);
	     
	     
	      
	      
	     
	    	
      	
	}
}