import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * This class sorts an array of 50 numbers by using the selection sort algorithm.
 * @author Bhaskar Singhvi
 */
public class SelectionSorter
{
	private int[] a;
	
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private int minPos;

	private JComponent component;

	private static final int DELAY = 200;

	/**
		Constructor for this class
		@param anArray the array to sort
		@param aComponent the component to be repainted when the animation
		pauses
	 */
	public SelectionSorter(int[] x, JComponent y) {
		a = x;
		component = y;
	}

	/**
	 * Sorts the array by the selection sort algorithm
	 */
	public void sort() throws InterruptedException {
		for (int i = 0; i < a.length - 1; i++) {
			minPos = minimumPosition(i);
			try {
				int temp = a[minPos];
				a[minPos] = a[i];
				a[i] = temp;
				alreadySorted = i;
			}
			finally{}
			pause(1);
		}
	}

	/**
		Finds the smallest element in the range of the array.
		@param starting position
		@return the smallest element in array a from 'start' to the end of the array
	 */
	private int minimumPosition(int start) throws InterruptedException {
		minPos = start;
		for (int i = start + 1; i < a.length; i++) {
			try {
				if (a[i] < a[minPos]) { 
					minPos = i; 
				}
				markedPosition = i;
			}
			finally{}
			pause(2);
		}
		return minPos;
	}
	
	/**
		Draws the bars and text for the sort
		@param g the graphics context
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Selection Sort", 150, 40);
		g.fill3DRect(150, 45, 200, 5, true);
		g.setFont(new Font("Times New Roman", Font.BOLD, 14));
		try {
			for (int i = 0; i < a.length; i++) {
				if (i == markedPosition && alreadySorted+1!=a.length-1) {
					g.setColor(Color.RED);
				}
				else if (i <= alreadySorted || alreadySorted+1==a.length-1 ) {
					g.setColor(Color.GREEN);
				}
				else {
					g.setColor(Color.GRAY);
				}
				if (i == minPos && alreadySorted+1!=a.length-1) {
					g.setColor(Color.BLUE);
				}
				g.fillRect(50, i*7+60+5*i, a[i]*8, 7);
				g.drawString("" + a[i], 22, i*7+63+5*i);
			}
		}
		finally{}
	}

	/**
		Pauses the animation that is currently running
		@param number is number of steps the animation pauses for
	 */
	public void pause(int number) throws InterruptedException {
		component.repaint();
		Thread.sleep(number * DELAY);
	}
}
