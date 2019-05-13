package se.file.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.file.process.CsvReader;

public class CsvReaderTest {
	
	public static void main(String[] args) {
		System.out.println("Please enter file name : ");
		Scanner input = new Scanner(System.in);
		String fileName = input.next();

		input.close();

		CsvReader csvReader = new CsvReader(fileName);
		List<Integer> rates = new ArrayList<>();
		rates = csvReader.getRates();
		
		//test reader
		for(int i = 0; i < rates.size(); i++) {
			System.out.println(rates.get(i));
		}
		System.out.println("Rates count is : " + rates.size());
		
		//test integer
		System.out.println(rates.get(0)+ rates.get(1));
	}
}
