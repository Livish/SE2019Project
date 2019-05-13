package se.file.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	
	private String fileName;


	public CsvReader() {

	}


	public CsvReader(String fileName) {
		this.setFileName(fileName);
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// read column of Rates and save as string List
	public List<Integer> getRates() {
		List<String> allRates = new ArrayList<>();
		List<Integer> rates = new ArrayList<>();

		try {
			
			BufferedReader reader = new BufferedReader(
					new FileReader(fileName));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String item[] = line.split(","); 
				String last = item[1];
				allRates.add(last);
			}

			reader.close();
			
			// remove title
			allRates.remove(0);

			// transfer rates to Integer
			for (String x : allRates) {
				Integer z = Integer.parseInt(x);
				rates.add(z);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rates;
	}



}
