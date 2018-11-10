import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComponent;

/**
 * This class that constructs the arrays, and initializes and displays the three sort: selection sort, bubble sort, and insertion sort
 * @author Bhaskar Singhvi
 */
 
public class SortComponent extends JComponent
{
	private SelectionSorter sorter1;
	private BubbleSorter sorter2;
	private InsertionSorter sorter3;
	
	/**
 		Constructor that creates the randomized array and clones them, while also initializing individual sorter objects.
	 */
	public SortComponent()
	{
		int[] values1 = constructArray();
		sorter1 = new SelectionSorter(values1, this);
		int[] values2 = values1.clone();
		sorter2 = new BubbleSorter(values2, this);
		int[] values3 = values1.clone();
		sorter3 = new InsertionSorter(values3, this);
	}

	/**
	 * Draws the sorts onto the component
	 */
	public void paintComponent(Graphics g)
	{
		sorter1.draw(g);
		sorter2.draw(g);
		sorter3.draw(g);
	}
	
	/**
	 * Creates the randomized array used for the sorts
	 * @return the randomized array
	 */
	public static int[] constructArray() {
		ArrayList<Integer> initializers = new ArrayList<Integer>(); 
		int[] temp = new int[50];
		for(int i=1;i<=50;i++) {
			initializers.add(i);
		}
		Collections.shuffle(initializers);
		for(int i=0; i<50; i++) {
			temp[i] = initializers.get(i);
		}
		return temp;
	}
	
	/**
		Starts the the three threads by using classes that implement runnable that correspond to the three sorts (respective by name)
	 */
	public void startAnimation()
	{
		class SelectionRunnable implements Runnable {
			public void run() {
				try {
					sorter1.sort();
				} 
				catch (InterruptedException exception) {}
			}
		}
		class BubbleRunnable implements Runnable {
			public void run() {
				try {
					sorter2.sort();
				}
				catch (InterruptedException exception) {}
			}
		}
		class InsertionRunnable implements Runnable{
			public void run() {
				try{
					sorter3.sort();
				}
				catch (InterruptedException exception) {}
			}
		}
		Runnable r1 = new SelectionRunnable();
		Runnable r2 = new BubbleRunnable();
		Runnable r3 = new InsertionRunnable();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}
}
