package org.example;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

public class FromFileTest {

	String url = "";

	private Iterator<Object[]> parseTestData(String fileName) throws IOException {
		BufferedReader input = null;
		File file = new File(fileName);
		input = new BufferedReader(new FileReader(file));
		String line = null;
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		while ((line = input.readLine()) != null) {
			String in = line.trim();
			String[] temp = in.split(",");
			List<Object> arrray = new ArrayList<Object>();
			for (String s : temp) {
				arrray.add(s);
			}
			data.add(arrray.toArray());
		}
		input.close();
		return data.iterator();
	}

	@DataProvider(name = "testData")
	public Iterator<Object[]> testData() throws IOException {

		return parseTestData("data.csv");
	}

	@Test(dataProvider = "testData")
	public void getFromFile(String v1, String v2, String v3) {
//		given()
//			.queryParam("v1", v1)
//			.queryParam("v2", v2)
//			.queryParam("v3", v3)
//				.ifValidationFails(LogDetail.BODY).statusCode(404);
	}

}
