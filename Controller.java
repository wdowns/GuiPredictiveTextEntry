/**
 * This class forms the controller part of the mobile phone GUI for 
 * text entry. It controls the interactions between the View and Model classes
 * for effective mobile phone GUI interaction. The class contains a constructor to allow 
 * Controller objects to be created which consist of View and Model objects.
 * The class contains numerous inner classes which implement action listener for the 
 * varying user inputs that may occur and which handle the interaction between the View and 
 * the Model.
 * @author William Downs
 * @version 22/02/16
 * 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Set;


public class Controller extends Observable {
// The instance variables, ArrayList and StringBuffer are created.
	private View view;
	
// Count is used for the star button to be able to cycle through words.
	private int count = 0;
// bFinal is used to append inputs.
	private StringBuffer bFinal = new StringBuffer();
// The constructor for controller objects.
	public Controller(View view, Model model){
// Add the listeners for buttons
		this.view = view;
		this.view.addButtonTwoListener(new ButtonTwoListener());
		this.view.addButtonThreeListener(new ButtonThreeListener());
		this.view.addButtonFourListener(new ButtonFourListener());
		this.view.addButtonFiveListener(new ButtonFiveListener());
		this.view.addButtonSixListener(new ButtonSixListener());
		this.view.addButtonSevenListener(new ButtonSevenListener());
		this.view.addButtonEightListener(new ButtonEightListener());
		this.view.addButtonNineListener(new ButtonNineListener());
		this.view.addButtonStarListener(new ButtonStarListener());
		this.view.addButtonZeroListener(new ButtonZeroListener());
		
	}
	// Button 2's inner class
	private class ButtonTwoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "2");
				// create model object to allow signatureToWords method to be called 	
				Model model = new Model();
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature 
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 3's inner class
	private class ButtonThreeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){ 
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "3");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 4's inner class
	private class ButtonFourListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){ 
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "4");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 5's inner class
	private class ButtonFiveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){ 
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "5");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 6's inner class
	private class ButtonSixListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){ 
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "6");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 7's inner class
	private class ButtonSevenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "7");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 8's inner class
	private class ButtonEightListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "8");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	//  Button 9's inner class
	private class ButtonNineListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				// set input display to itself plus the input number
				view.setInputDisplay(view.getInputDisplay() + "9");
				// create model object to allow signatureToWords method to be called 
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append content of input display (numerical signature) to buffer
				buffer.append(view.getInputDisplay());
				// convert to String 
				String string = buffer.toString();
				// create Set and call signatureToWords method on signature
				Set<String> mySet = model.signatureToWords(string);
				// create iterator for mySet containing words
				Iterator<String>iterator = mySet.iterator();
				// set main display as bFinal (appended previous inputs) and next element of mySet
				view.setDisplay(bFinal.toString() + iterator.next());
			}catch(NoSuchElementException Ex){

			}
		}
	}
	// Star button's inner class 
	private class ButtonStarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			try{
				// increment count if star button is pressed	
				count ++;	
				// create new model object to allow signatureToWords method to be called
				Model model = new Model();	
				// create new StringBuffer and initialise as empty String
				StringBuffer buffer = new StringBuffer("");
				// append current input display content (numerical signature)
				buffer.append(view.getInputDisplay());
				// convert to String
				String string = buffer.toString();
				// create Set and call signatureToWords method on String
				Set<String> mySet = model.signatureToWords(string);
				// return array containing all elements of Set
				Object[]myArray = mySet.toArray();
				// if the end of words to cycle through is reached reset count 
				// to 0 to go back to beginning of array to cycle again
				if(count == myArray.length){
					count = 0;
				}
				// set display as previous input plus next possible word
				view.setDisplay(bFinal.toString() + myArray[count].toString());
			}
			catch(NoSuchElementException Ex){

			}
		}
	}
	// Button 0's inner class 
	private class ButtonZeroListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			try{
				// reset count to 0 as moving on to next word
				count = 0;
				// reset bFinal to contain nothing
				bFinal.delete(0, bFinal.length());
				// append current display and a space to bFinal
				bFinal.append(view.getDisplay() + " ");
				// set display as bFinal to String
				view.setDisplay(bFinal.toString());
				// reset input display for next entry
				view.setInputDisplay("");
			}
			catch(NoSuchElementException Ex){

			}
		}
	}
}

		
	
	
	


