package com.mystore.testcases;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.mystore.utilities.ReadExcelFile;

public class Demo {
	
	public static void m1() {
		String fileName = "./TestData/MyStoreTestData.xlsx";
		String sheetName="LoginTestData";
		String[][] text =ReadExcelFile.excelData(fileName, sheetName);
		System.out.println(Arrays.deepToString(text));
	}
	public static void main(String[] args) {
		m1();
	}

}
