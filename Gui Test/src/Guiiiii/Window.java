package Guiiiii;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

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
	static URL hauntedURL;
	static Boolean spooky = true;
	static Boolean reopen = false;
	static Clip clip, clip2;
	// static WindowListener exitListener;

	static MalformedURLException error = new MalformedURLException("");

	public static void main(String[] args) throws MalformedURLException {
		hauntedURL = new URL("https://media.giphy.com/media/1dPTVv6FaQmZ2/giphy.gif");
		URL url = new URL(
				"http://2.bp.blogspot.com/-baqmxAt8YHg/UMRuNx6uNdI/AAAAAAAAD1s/TzmvfnYyP8E/s1600/rick-astely.gif");
		icon = new ImageIcon(url);
		label2 = new JLabel(icon);
		play("src\\Guiiiii\\Ricky.wav", true);
		playOther("src\\Guiiiii\\xfiles.wav", false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(1280, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		button.addActionListener(new Listener());
		panel.add(label);
		panel.add(button);
		panel.add(label2);
		frame.add(panel);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				clip.stop();
				// clip2.start();

				reopen = true;
			}
		});
		frame.setVisible(true);
		while (spooky) {
			System.out.print("");
			if (reopen) {
				reopen();
				reopen = false;
			}
		}
		spooked();

	}

	public static void play(String filename, Boolean startup) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File(filename)));
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			if (!startup) {
				clip.stop();
			}
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	public static void playOther(String filename, Boolean startup) {
		try {
			clip2 = AudioSystem.getClip();
			clip2.open(AudioSystem.getAudioInputStream(new File(filename)));
			clip2.start();
			if (!startup) {
				clip2.stop();
			}
		} catch (Exception exc) {
			exc.printStackTrace(System.out);
		}
	}

	// public static void close() {
	// }
	public static void spooked() {
		try {
			clip.stop();
			clip2.start();
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
		frame.setVisible(false);
		while (clip2.isRunning()) {
			System.out.print("");
		}
		System.out.println("I want to believe.");
		frame.dispose();
	}

	public static void reopen() {
		try {
			Thread.sleep(6000);
			clip.start();
			// clip2.stop();
			frame.setVisible(true);
			frame.setState(JFrame.NORMAL);
			System.out.println("Nope");
		} catch (Exception exc) {

		}
	}
}

class Listener implements ActionListener {
	private double click;
	private int clickCount = 0;
	private static Icon hauntedIcon = new ImageIcon(Window.hauntedURL);

	public void actionPerformed(ActionEvent e) {
		click = Math.random();
		clickCount++;
		if (Window.label2.getIcon() == hauntedIcon) {
		}
		if (clickCount == 50) {
			Window.label.setText("You suck.");
		} else if (clickCount == 75) {
			Window.label.setText("Give up.");
		} else if (clickCount >= 100 && clickCount <= 108) {
			Window.label.setText("N3VER GONN4 G1VE Y0U UP!1!!11!");
		} else if (clickCount > 108 && clickCount <= 116) {
			Window.label.setText("N#V_R G0NN4 L33t y0# d_WN¡!!¡!);");
		} else if (clickCount > 116 && clickCount <= 124) {
			Window.label.setText("N___R GOn54 RN aR##Nd");
		} else if (clickCount > 124 && clickCount <= 132) {
			Window.label.setText("AND D3S3RT YYYYYYY UUI YP UI YIUY JKSDH");
		} else if (clickCount > 132) {
			Window.label2.setIcon(hauntedIcon);
			Window.spooky = false;
		} else {
			Window.label.setText("" + clickCount);
		}
		System.out.println(click);
		if (click >= 0.99) {
			Window.label.setText("You may Leave.");
			Window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Window.button.setEnabled(false);

		}

	}
}
