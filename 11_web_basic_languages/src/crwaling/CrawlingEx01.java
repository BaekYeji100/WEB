package crwaling;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingEx01 {

	public static void main(String[] args) {
		
		// 최초 한번) lib 폴더에 jsoup.jar파일을 저장한다.
		
		try {
			
			String url = "https://www.naver.com";
			
			//1) 연결객체를 생성한다.
			Connection conn = Jsoup.connect(url);
			
			//2) get메서드를 통해 Document 객체에 저장한다.
			Document getHtml = conn.get();
			System.out.println(getHtml); // 확인
			
			//3) 원하는 데이터를 크롤링 한다.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
