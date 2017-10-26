import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Soundboard
{
	public Soundboard()
	{
		//Create a new frame
		JFrame j = new JFrame("Soundboard");
        
        //make sure the program exits when the frame closes
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the size of the frame
        j.setSize(900,900);
		
		//create the Audrey Hepburn button			
		JButton b = makeSoundboardButton("audrey.jpg", "Hepburn.wav");
		
		//create the Mama T button
		JButton m = makeSoundboardButton("bb.jpg", "bbb.wav");
		
		//create a JPanel for the button
		JPanel p = new JPanel();
		
		//add the button to a JPanel
		p.add(b);
		p.add(m);
	
		//add the panel to the content pane of the frame
		j.add(p);
		
		//make sure the JFrame is visible
		j.setVisible(true);
	}
	
	/**
	 * Creates a JButton which displays the specified image and plays the specified sound when it is clicked.
	 * @param imageFile the name of the image to display on the button, including the file extension
	 * @param soundFile the name of the audio clip to play when the button is clicked
	 * @return the JButton
	 **/
	private JButton makeSoundboardButton(String imageFile, String soundFile)
	{
		JButton button;
		try{
			BufferedImage icon = ImageIO.read(new File(imageFile));
			button = new JButton(new ImageIcon(icon));
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			//add action listener
			button.addActionListener(new SoundboardActionListener(soundFile));
		}
		catch (IOException e) {
			System.out.println(e);
			button = new JButton();
		}
		return button;
	}
}