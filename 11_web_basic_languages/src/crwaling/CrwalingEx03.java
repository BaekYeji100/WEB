package crwaling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrwalingEx03 {

	public static void main(String[] args) {
		
		// 10page를 크롤링
		try {
			
			ArrayList<String> titles = new ArrayList<>();
			ArrayList<String> results = new ArrayList<>();
			ArrayList<String> urls = new ArrayList<>();
			
			
			for (int i = 1; i < 11; i++) {
					
				String url = "https://news.naver.com/main/factcheck/main.nhn?page="+i;
				Connection conn = Jsoup.connect(url);
				Document html = conn.get();
							
				Elements temp = html.getElementsByClass("fact_lst _factcheck_body");
				Elements section = temp.get(0).getElementsByClass("section");
				
				for (Element sec : section) {
								
					Element info = sec.getElementsByClass("info_area").get(0);
					titles.add(info.getElementsByClass("txt").text());
					
					
					Element result_fact = sec.getElementsByClass("result_fact").get(0);
					results.add(result_fact.getElementsByClass("blind").text());
					
					
					Element ul  = sec.getElementsByClass("lst").get(0); 
					urls.add(ul.getElementsByTag("a").get(0).attr("href"));
										   					
				}
			
			}
			
			
			for (int i = 0; i < titles.size(); i++) {
				System.out.println("\n" + (i+1));
				System.out.println(titles.get(i) +  " : " + results.get(i));
				System.out.println(urls.get(i));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
