package com.spring.basic.step01_DI;

import java.util.List;
import java.util.Map;

// 컬렉션 프레임워크 주입 예시
public class ClassTester3 {
	List<String> testList;
	Map<String, String> testMap;
	Map<String, ClassTester1> testMapObj;
	
	public List<String> getTestList() {
		return testList;
	}
	public void setTestList(List<String> testList) {
		this.testList = testList;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public Map<String, ClassTester1> getTestMapObj() {
		return testMapObj;
	}
	public void setTestMapObj(Map<String, ClassTester1> testMapObj) {
		this.testMapObj = testMapObj;
	}
	
	
}
