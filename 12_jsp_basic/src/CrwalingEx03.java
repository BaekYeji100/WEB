

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
			
			for (int i = 1; i < 10 ; i++) {
				
				String url = "https://news.naver.com/main/factcheck/main.nhn?page="+i;
				Connection conn = Jsoup.connect(url);
				Document html = conn.get();
							
				Elements bodys = html.getElementsByClass("fact_lst _factcheck_body");
				for (Element body : bodys) {
					for (Element section : body.getElementsByClass("info_area")) {
						titles.add(section.getElementsByClass("txt").text());
					}
					
					for (Element section : body.getElementsByClass("result_fact")) {
						results.add(section.getElementsByClass("blind").text());
					}
					
					for (Element section : body.getElementsByClass("relation_lst")) {
						for ( Element ul : section.getElementsByClass("lst")) {
							urls.add(ul.getElementsByTag("a").attr("href"));
						}
					}   
					
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
