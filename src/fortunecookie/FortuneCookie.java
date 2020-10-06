package fortunecookie;

import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FortuneCookie {

	public static void main(String[] args) {
		try {
			Random rand= new Random();
			int r=rand.nextInt(152);
			Document doc = Jsoup.connect(String.format("http://www.myfortunecookie.co.uk/fortunes/%d/", r)).get();
			String title= doc.select("div.fortune").first().text();
			System.out.println(title);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
