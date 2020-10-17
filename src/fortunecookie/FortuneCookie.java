package fortunecookie;

import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FortuneCookie {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setTitle("Fortune Cookie");
		frame.setSize(420,420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon("fortunecookie.png");
		frame.setIconImage(icon.getImage());
		frame.setVisible(true);
		
		try {
			
			Random rand= new Random();
			int r=rand.nextInt(152);
			Document doc = Jsoup.connect(String.format("http://www.myfortunecookie.co.uk/fortunes/%d/", r)).get();
			String title= doc.select("div.fortune").first().text();
			System.out.println(title);
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
