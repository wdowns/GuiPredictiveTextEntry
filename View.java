/**
 * This class forms the view part of the mobile phone GUI for predictive text entry. It 
 * assembles the mobile phone GUI using Swing. The different components of the GUI are 
 * named as instance variables. A constructor is then used to create the GUI which consists 
 * of a panel containing the display, input display and a button panel. The class contains 
 * getters and setters for both displays which are used by the controller class to change 
 * the information displayed and the listeners for each button to return their value.
 * @author William Downs
 * @version 22/02/16
 * 
 */

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	//Components created, the sizes specified and the content defined where applicable.
	private JTextArea display = new JTextArea(5, 20);
	private JTextArea inputDisplay = new JTextArea(2, 20);
	private JPanel buttonPanel = new JPanel();
	private JButton one = new JButton("1");
	private JButton two = new JButton("abc 2");
	private JButton three = new JButton("def 3");
	private JButton four = new JButton("ghi 4");
	private JButton five = new JButton("jkl 5");
	private JButton six = new JButton("mno 6");
	private JButton seven = new JButton("pqrs 7");
	private JButton eight = new JButton("tuv 8");
	private JButton nine = new JButton("wxyz 9");
	private JButton star = new JButton(" * ");
	private JButton zero = new JButton("0");
	private JButton hash = new JButton(" # ");

	// GUI constructor
	public View(){
		JPanel phonePanel = new JPanel(); // Contains all of the components.
		// Set close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set size of the panel.
		this.setSize(250, 275);
		// Call method to assemble buttons into grid layout.
		buildButtonPanel();
		// Set visibility to true.
		this.setVisible(true);

		// Add components.
		phonePanel.add(display);
		phonePanel.add(inputDisplay);
		phonePanel.add(buttonPanel);
		// Add phone panel.
		this.add(phonePanel);
	}

	// Method for constructing button panel in a grid layout.
	public void buildButtonPanel () {
		buttonPanel.setLayout(new GridLayout(4,3));
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(star);
		buttonPanel.add(zero);
		buttonPanel.add(hash);
	}
// getters and setters for display and inputDisplay to allow it to be modified by controller.
	public String getInputDisplay(){
		return inputDisplay.getText();
	}

	public String getDisplay(){
		return display.getText();
	}

	public void setDisplay(String solution){
		display.setText(solution);
	}

	public void setInputDisplay(String text){
		inputDisplay.setText(text);
	}
// Add ActionListeners for buttons to link to the controller 
// class to make sure that it is aware that a button has been pressed.

	public void addButtonOneListener(ActionListener listenForOne){
		one.addActionListener(listenForOne);
	}
	public void addButtonTwoListener(ActionListener listenForTwo){
		two.addActionListener(listenForTwo);
	}
	public void addButtonThreeListener(ActionListener listenForThree){
		three.addActionListener(listenForThree);
	}
	public void addButtonFourListener(ActionListener listenForFour){
		four.addActionListener(listenForFour);
	}
	public void addButtonFiveListener(ActionListener listenForFive){
		five.addActionListener(listenForFive);
	}
	public void addButtonSixListener(ActionListener listenForSix){
		six.addActionListener(listenForSix);
	}
	public void addButtonSevenListener(ActionListener listenForSeven){
		seven.addActionListener(listenForSeven);
	}
	public void addButtonEightListener(ActionListener listenForEight){
		eight.addActionListener(listenForEight);
	}
	public void addButtonNineListener(ActionListener listenForNine){
		nine.addActionListener(listenForNine);
	}
	public void addButtonStarListener(ActionListener listenForStar){
		star.addActionListener(listenForStar);
	}
	public void addButtonZeroListener(ActionListener listenForZero){
		zero.addActionListener(listenForZero);
	}
	public void addButtonHashListener(ActionListener listenForHash){
		hash.addActionListener(listenForHash);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	}
}
