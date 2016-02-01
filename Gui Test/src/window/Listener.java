package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

class Listener implements ActionListener { // For when the button is pressed.
	private double click;
	private int clickCount = 0;
	double oneMinusClick;
	private static Icon hauntedIcon = new ImageIcon(Window.hauntedURL); // ooooOOOOhhhsdfsdfaw4etsdf

	public void actionPerformed(ActionEvent e) {
		click = Math.random();
		clickCount++; // Adds to click count.
		oneMinusClick = 1 - click;
		Window.closenessNumLabel.setText(" " + oneMinusClick);
		
		//Prints the text all the way to the right
		if (0 < oneMinusClick && oneMinusClick < 0.1){
			Window.closenessTextLabel.setText("SO CLOSE");
		} else if (0.1 < oneMinusClick && oneMinusClick < 0.2){
			Window.closenessTextLabel.setText("VERY CLOSE");
		} else if (0.2 < oneMinusClick && oneMinusClick < 0.3){
			Window.closenessTextLabel.setText("Pretty close");
		} else if (0.3 < oneMinusClick && oneMinusClick < 0.4){
			Window.closenessTextLabel.setText("Kinda close");
		} else if (0.4 < oneMinusClick && oneMinusClick < 0.5){
			Window.closenessTextLabel.setText("Half n half");
		} else if (0.5 < oneMinusClick && oneMinusClick < 0.6){
			Window.closenessTextLabel.setText("Not so close");
		} else if (0.6 < oneMinusClick && oneMinusClick < 0.7){
			Window.closenessTextLabel.setText("Get good");
		} else if (0.7 < oneMinusClick && oneMinusClick < 0.8){
			Window.closenessTextLabel.setText("UR BAD");
		} else if (0.8 < oneMinusClick && oneMinusClick < 0.9){
			Window.closenessTextLabel.setText("HOW ARE U THIS BAD");
		} else if (0.9 < oneMinusClick && oneMinusClick < 1){
			Window.closenessTextLabel.setText("LITERALLY THE WORST");
		}
			
		//Prints the text all the way to the left
		if (clickCount == 50) {
			Window.label.setText("You suck."); // Easter egg.
		} else if (clickCount == 90) {
			Window.label.setText("Give up."); // Easter egg.
		} else if (clickCount >= 120 && clickCount <= 128) {
			Window.label.setText("N3VER GONN4 G1VE Y0U UP!1!!11!");
		} else if (clickCount > 128 && clickCount <= 136) {
			Window.label.setText("N#V_R G0NN4 L33t y0# d_WN!1!1!");
		} else if (clickCount > 136 && clickCount <= 144) {
			Window.label.setText("N___R GOn54 RN aR##Nd");
		} else if (clickCount > 144 && clickCount <= 152) {
			Window.label.setText("AND D3S3RT YYYYYYY UUI YP UI YIUY JKSDH");
		} else if (clickCount > 152) { // You've gone too far...
			Window.label2.setIcon(hauntedIcon);
			Window.spooky = false;
		} else {
			Window.label.setText("" + clickCount); // Displays the number of
													// clicks (usually.)
		}
		
		//wtf is this
		if (Window.debugging)
			System.out.println(click);
		
		if (click >= 0.99)  // When you are lucky enough....
			Window.youCanLeave();
		
		Window.panel.requestFocusInWindow();
	}
	
}
