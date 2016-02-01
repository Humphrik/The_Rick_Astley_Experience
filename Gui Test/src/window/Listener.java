package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Listener implements ActionListener { // For when the button is pressed.
	private double click;
	private int clickCount = 0;
	private static Icon hauntedIcon = new ImageIcon(Window.hauntedURL); // ooooOOOOhhh.

	public void actionPerformed(ActionEvent e) {
		click = Math.random();
		clickCount++; // Adds to click count.
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
		if (Window.debugging)
			System.out.println(click);
		if (click >= 0.995) { // When you are lucky enough....
			Window.label.setText("You may Leave.");
			Window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Window
																			// will
																			// no
																			// longer
																			// "reopen."
			Window.button.setEnabled(false); // Turns off button.

		}

	}
}
