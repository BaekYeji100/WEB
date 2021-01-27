<%@page import="org.jsoup.Jsoup"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>크롤링 실습</title>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<style>
	* {
		margin: 10px 10px 10px 10px;	
	}
	
  	a:visited { color:purple; }  /* 방문된 링크의 스타일 */	
</style>
</head>
<body>
	<% 
		ArrayList<String> titles = new ArrayList<>();
		ArrayList<String> results = new ArrayList<>();
		ArrayList<String> urls = new ArrayList<>();
			
		// 10page 크롤링
		try {
			
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	%>
	
	  <div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header" align="center">
              <h1>네이버 팩트체크 크롤링</h1>
              <br>
            </div>
            <div class="bs-component">
              <table class="table table-hover">
                <thead>
                  <tr class="table-primary" align="center">
                    <th>순서</th>
                    <th>기사 제목</th>
                    <th>팩트 체크 결과</th>
                    <th>관련 기사</th>        
                  </tr>
                </thead>
                <tbody>
                  
     <% 
     				for (int i = 0; i< titles.size(); i++) {
     %>
     					<tr class="table-default" align="center">
     						<td><%=i+1 %></td>
     						<td><%=titles.get(i)%></td>
     						<td  style="color: red"><%=results.get(i)%></td>
     						<td><a href="<%=urls.get(i)%>" target="_blank">관련 기사 확인하기</a></td>
                  		</tr>
     <% 
     				}
     %>
                </tbody>
              </table>
              <button style="float: right"type="button" class="btn btn-primary" onclick="window.open('https://news.naver.com/main/factcheck/main.nhn')">펙트체크 홈</button>
             </div>
          </div>
        </div>
      </div>
	
	
</body>
</html>