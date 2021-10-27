package maven01;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class App extends JFrame{
	public App() throws IOException {
		super();
		JPanel jpanel = new JPanel();
		
	
		BufferedReader inn = new BufferedReader(new FileReader("homeWork04.txt"));
		if(inn!=null) {
		String line;
		while ((line = inn.readLine()) != null) {
			JLabel labele = new JLabel(line);
			jpanel.add(labele);
			break;
		}
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/homeWork041.txt")));
		if(in!=null) {
		String line2;
		while ((line2 = in.readLine()) != null) {
			JLabel labele2 = new JLabel(line2);
			jpanel.add(labele2);
			break;
		}
		}
		
		URL url = this.getClass().getResource("/game.jpg");
		JLabel jlabelImage02 = new JLabel(new ImageIcon(url));
		File image = new File("pudge.jpg");
		JLabel jlabel = new JLabel(new ImageIcon(image.getAbsolutePath()));
		jpanel.setLayout(new GridLayout(2, 2));
		jpanel.add(jlabel);
		jpanel.add(jlabelImage02);
		add(jpanel);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
    public static void main( String[] args )throws IOException {
        new App();
    }
}
