package application;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	            	direction = carQueue.deleteQueue();
	            	while(!(Thread.interrupted()))
	            	{
	            	   if(direction == 0)
	            	   {
	            		   y += 10;
	            		   if(y >= 325)
	            			   direction = 1;
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            	   }
	            	   else if(direction == 1)
	            	   {
	            		   y -= 10;
	            		   if(y <= 25)
	            			   direction = 0;
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            	   }
	            	   else if(direction == 2)
	            	   {
	            		   x += 10;
	            		   if(x >= 225)
	            			   direction = 3;
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            	   }
	            	   else if(direction == 3)
	            	   {
	            		   x -= 10;
	            		   if(x <= 25)
	            			   direction = 2;
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            	   }
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}