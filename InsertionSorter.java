import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

/**
 * This class sorts an array, using the selection sort algorithm.
 * @author Bhaskar Singhvi
 */
 
public class InsertionSorter
{
	private int[] a;

	private int markedPosition = -1;
	private int alreadySorted = -1;

	private JComponent component;

	private static final int DELAY = 200;

	/**
	 * Constructor for this class
	 * @param x is the array to sort
	 * @param aComponent the component to be repainted when the animation pauses
	 */
	public InsertionSorter(int[] x, JComponent y)
	{
		a = x;
		component = y;
	}

	/**
	 * Sorts the array by the insertion sort algorithm
	 */
	public void sort() throws InterruptedException
	{
		int temp, j;
		for (int i = 1; i < a.length; i++)
		{
			markedPosition = i;
			alreadySorted = i;
			try {
				temp = a[i];
				j = i; 
				while (j > 0 && a[j - 1] > temp)
				{
					a[j] = a[j - 1];
					markedPosition=j;
					j--;
				}
				a[j] = temp;
			}
			finally {}
			pause(2);
		}
	}

	/**
	 * Draws the bars and text for the sort
	 * @param g the graphics context
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Insertion Sort", 1150, 40);
		g.fill3DRect(1150, 45, 190, 5, true);
		g.setFont(new Font("Times New Roman", Font.BOLD, 14));
		try {
			for (int i = 0; i < a.length; i++){
				if (i-1 == alreadySorted && alreadySorted!=a.length-1){
					g.setColor(Color.RED);
				}
				else if (i <= alreadySorted){
					g.setColor(Color.GREEN);
				}
				else{
					g.setColor(Color.GRAY);
				}
				if(i==markedPosition && alreadySorted!=a.length-1) {
					g.setColor(Color.BLUE);
				}
				g.fillRect(1050, i*7+60+5*i, a[i]*8, 7);
				g.drawString("" + a[i], 1028, i*7+63+5*i);
			}
		}
		finally{}
	}

	/**
	 * Pauses the animation that is currently running
	 * @param number is number of steps the animation pauses for
	 */
	public void pause(int steps) throws InterruptedException
	{
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}
