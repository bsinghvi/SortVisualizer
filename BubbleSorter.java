import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * This class sorts an array of 50 numbers by using the bubble sort algorithm.
 * @author Bhaskar Singhvi
 */
public class BubbleSorter
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
	public BubbleSorter(int[] x, JComponent y) {
		a = x;
		component = y;
	}

	/**
	 * Sorts the array by the bubble sort algorithm
	 */
	public void sort() throws InterruptedException
	{
		boolean swapped = true; 
		int j = 0;
		int tmp;

		while(swapped) {
			alreadySorted = a.length-j-1;
			swapped = false;
			j++;
			for(int i=0; i<a.length-j;i++) {
				try {
					if(a[i]>a[i+1]) {
						tmp = a[i];
						a[i] = a[i+1];
						markedPosition = i;
						a[i+1] = tmp;
						swapped=true;
					}
				} finally {}
				pause(1);
			}
			/*if(swapped==false) {
				alreadySorted=0;
			}*/
		}
	}

	/**
	 * Draws the bars and text for the sort
	 * @param g the graphics context
	 */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fill3DRect(280, 700, 18, 18, true);
		g.setColor(Color.BLUE);
		g.fill3DRect(680, 700, 18, 18, true);
		g.setColor(Color.GREEN);
		g.fill3DRect(1100, 700, 18, 18, true);
		g.setColor(Color.DARK_GRAY);
		g.drawString(" = Sort is on value ", 300, 715);
		g.drawString(" = Value to be swapped", 700, 715);
		g.drawString("   (for insertion sort, value swapped)", 700, 740);
		g.drawString(" = Value is correctly placed ",1120, 715);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Bubble Sort", 670, 40);
		g.fill3DRect(670, 45, 170, 5, true);
		g.setFont(new Font("Times New Roman", Font.BOLD, 14));

		try {
			for (int i = 0; i < a.length; i++) {
				if (i == markedPosition+1){
					g.setColor(Color.BLUE);
				}
				else if (i-1 >= alreadySorted) {
					g.setColor(Color.GREEN);
				}
				else {
					g.setColor(Color.GRAY);
				}
				g.fillRect(550, i*7+60+5*i, a[i]*8, 7);
				g.drawString("" + a[i], 528, i*7+63+5*i);
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
