package Vista;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class main {

	public static void main(String arg[]) throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		Menu menu = new Menu();
		menu.setVisible(true);
	}
}
