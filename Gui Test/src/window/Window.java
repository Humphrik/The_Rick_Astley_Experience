package window;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import  java.text.DecimalFormat;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	static JFrame frame = new JFrame("Never Gonna Give You Up.");
	static JPanel panel = new JPanel();
	static Label label = new Label("DOOOOH DOOOOHHH DO DOOOOH DOOOOH.");
	static Button button = new Button("Press to Close ;) .");
	static Icon icon;
	static JLabel label2;
	static Label closenessLabel = new Label("How close was that click?");
	static JLabel closenessNumLabel = new JLabel();
	static Label closenessTextLabel = new Label();
	static URL url, hauntedURL;
	static Boolean spooky = true;
	static Boolean reopen = false;
	static Clip clip, clip2;
	public static boolean debugging = false; // MAY be set to true at start of main();
	public static int konami = 0;
	static int time = 1000;
	static DecimalFormat df = new DecimalFormat("#.###");
	// static WindowListener exitListener;
	// static MalformedURLException error = new MalformedURLException("");

	public static void main(String[] args) throws MalformedURLException { // Accommodates
																			// URL
																			// errors.
		checkParameters(args);

		df.setRoundingMode(RoundingMode.DOWN);
		hauntedURL = new URL("https://media.giphy.com/media/1dPTVv6FaQmZ2/giphy.gif"); // ??? (spooky gif)
		url = new URL(
				"http://2.bp.blogspot.com/-baqmxAt8YHg/UMRuNx6uNdI/AAAAAAAAD1s/TzmvfnYyP8E/s1600/rick-astely.gif"); // Ricky
		icon = new ImageIcon(url);
		label2 = new JLabel(icon);
		// Image created. ^^
		play("src/audio/Ricky.wav"); // Creates and plays main music.
		playOther("src/audio/xfiles.wav"); // ???
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Makes sure the
																// window does
																// not terminate
																// early.
		frame.setSize(1280, 800); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		button.addActionListener(new Listener()); // Adds function to button.
		panel.add(label); //main label
		panel.add(button);//main button
		panel.add(label2);//spooky image applied to this label
		panel.add(closenessLabel);
		panel.add(closenessNumLabel);//the long decimal on the window
		panel.add(closenessTextLabel);//the text next to it
		closenessTextLabel.setBounds(30, 300, 18, 23);//positions
		closenessLabel.setBounds(25, 5, 18, 23);
		closenessNumLabel.setBounds(25, 10, 18, 23);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.addKeyListener(new KeyListener(){
			
			//Konami code exit
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode()==38 && konami == 0){
					konami = 1;
				}
				if (e.getKeyCode()==38 && konami == 1){
					konami = 2;
				}
				if (e.getKeyCode()==40 && konami == 2){
					konami = 3;
				}
				if (e.getKeyCode()==40 && konami == 3){
					konami = 4;
				}
				if (e.getKeyCode()==37 && konami == 4){
					konami = 5;
				}
				if (e.getKeyCode()==39 && konami == 5){
					konami = 6;
				}
				if (e.getKeyCode()==37 && konami == 6){
					konami = 7;
				}
				if (e.getKeyCode()==39 && konami == 7){
					konami = 8;
				}
				if (e.getKeyChar()=='b' && konami == 8){
					konami = 9;
				}
				if (e.getKeyChar()=='a' && konami == 9){
					konami = 10;
				}
				if (konami == 10){
					youCanLeave();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
		frame.add(panel); // Everything put together.
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) { // Upon attempting to
															// close early.
				clip.stop();
				// clip2.start();

				reopen = true; // This is to avoid issues and allow time to
								// updated.
			}
		});
		frame.setVisible(true); // Displays window.

		
		//When its playing keep playing, but when it's closed, call reopen(time);
		while (spooky) { // While running functionally.
			System.out.print("");
			if (reopen) {
				reopen(time); // Reopens a 'closed' window.
				if(time<15000){
				time+=3000;
				}
				reopen = false;
			}
		}
		spooked(); // U boutta get spooked boiiii

	}

	// Meant to be called by main
	// Checks if there are any parameters and sends them to the
	// checkAllowedParameters method to actually check if the given
	// Parameters are accepted.
	static void checkParameters(String[] args) {
		if (args.length == 0) {
			return;
		} else {
			for (int i = 0; i < args.length; i++) {
				// Checks all of the parameters entered against the
				// list of accepted parameters.
				checkAllowedParameters(args[i]);
			}
		}
	}

	// Meant to be called by checkParameters function
	// Checks the given parameter against the list of accepted parameters
	static void checkAllowedParameters(String arg) {
		if (arg.equals("debug")) {
			System.out.println("Debugging enabled");
			debugging = true;
		}
	}

	public static void play(String filename) { // Creates music for clip.
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(filename)));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void reopen(int time) { // "Reopens" after a delay.
		try {
			Thread.sleep(time); //how long it stays closed (milliseconds)
			clip.start();
			// clip2.stop();
			frame.setVisible(true);
			frame.setState(JFrame.NORMAL);
			System.out.println("Nope"); // lol
		} catch (Exception exc) {
		}
	}

	public static void playOther(String filename) { // Creates music for clip 2.
		try {
			clip2 = AudioSystem.getClip();
			clip2.open(AudioSystem.getAudioInputStream(new File(filename))); //opens audio file
			clip2.start();
			clip2.stop();
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	// public static void close() {
	// }
	public static void spooked() { // For the unlucky.
		try {
			clip.stop();
			clip2.start();
			Thread.sleep(1000); //stops method for 1000 milliseconds
		} catch (InterruptedException ex) {
		}
		frame.setVisible(false);
		while (clip2.isRunning()) { // ???
			System.out.print("");
		}
		System.out.println("I want to believe.");
		frame.dispose();
	}
	public static void youCanLeave(){
		Window.label.setText("You may Leave.");
		Window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Window will no longer "reopen."
		Window.button.setEnabled(false); // Turns off button.
	}
}

