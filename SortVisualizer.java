import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * Driver class. 
 * Creates the frame and initializes the component that contains all the three sorts
 * @author Bhaskar Singhvi
 */
public class SortVisualizer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setTitle("Sorting Visualizer");
		frame.setSize(1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		final SortComponent component2 = new SortComponent();
		frame.add(component2,BorderLayout.CENTER);

		frame.setVisible(true);
		component2.startAnimation();
	}
}
