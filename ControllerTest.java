/**
 * Class to create a Controller object and uses a main method to put it on the screen.
 * Run this class to produce the GUI. 
 * @author William Downs
 * @version 22/02/16 
 */
public class ControllerTest {

	public static void main(String[] args) {
		
		View myView = new View();
		Model model = new Model();
		new Controller(myView, model);
		myView.setVisible(true);
	}
}