package crwaling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrwalingEx02 {

	public static void main(String[] args) {
		
		
		// 한페이지를 크롤링
		try {
			
			String url = "https://news.naver.com/main/factcheck/main.nhn";
			Connection conn = Jsoup.connect(url);
			Document html = conn.get();
			
			ArrayList<String> titles = new ArrayList<>();
			ArrayList<String> results = new ArrayList<>();
			ArrayList<String> urls = new ArrayList<>();
			
			Elements bodys = html.getElementsByClass("fact_lst _factcheck_body");
			for (Element body : bodys) {
				
				for (Element section : body.getElementsByClass("info_area")) {
					titles.add(section.getElementsByClass("txt").text());			// 기사 크롤링
				}
				
				for (Element section : body.getElementsByClass("result_fact")) {	// 펙트인지 여부 크롤링
					results.add(section.getElementsByClass("blind").text());
				}
				
				for (Element section : body.getElementsByClass("relation_lst")) {
					for ( Element ul : section.getElementsByClass("lst")) {
						urls.add(ul.getElementsByTag("a").attr("href"));			// 관련 기사 크롤링
					}
				}   
				
			}
			
			for (int i = 0; i < titles.size(); i++) {
				System.out.println(titles.get(i) + " /// " + results.get(i) + " /// " + urls.get(i));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
