package se.file.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Processing {

	public void secondProess(String fileName, int processor) {
		// get Rates List from CSV file
		CsvReader csvReader = new CsvReader(fileName);
		List<Integer> rates = new ArrayList<>();
		rates = csvReader.getRates();

		// calculate average throughput
		int averThroughput = 0;
		int allMessage = 0;
		for (int i = 0; i < rates.size(); i++) {
			allMessage += rates.get(i);
		}
		averThroughput = allMessage / rates.size();

		System.out.println("average Throughput is: " + averThroughput + " per second");

		// get message
		List<Integer> message = new ArrayList<>();
		Message m = new Message(rates.size());
		message = m.createMessage();

		// calculate average latency
		List<Double> latency = new ArrayList<>();
		double allLatency = 0;
		double averLatency = 0;
		for (int i = 0; i < message.size(); i++) {
			double time = 0;
			time = (double) message.get(i) / ((double) rates.get(i) * processor) - 1;
			latency.add(time);
			allLatency += time;
		}
		averLatency = allLatency / rates.size();
		System.out.println("Average latency is : " + averLatency + "s");

		// get microsecond rates
		List<Double> microRates = new ArrayList<>();
		for (int i = 0; i < rates.size(); i++) {
			double rate = 0;
			rate = (double) rates.get(i) / 1000000;

			microRates.add(rate);
		}

		// get per microsecond message count
		List<Integer> microMessage = new ArrayList<>();
		microMessage = m.createMicroMessage();

		// calculate microsecond latency
		List<Double> microLatency = new ArrayList<>();
		for (int i = 0; i < microMessage.size(); i++) {
			double time = 0;
			time = (double) microMessage.get(i) / (microRates.get(i) * processor) - 1;
			microLatency.add(time);
		}

		// get distribution of latency
		Collections.sort(microLatency);
		int oneP = 0, twoP = 0, threeP = 0, fourP = 0, fiveP = 0;
		oneP = (int) (microLatency.size() * 0.5);
		twoP = (int) (microLatency.size() * 0.75);
		threeP = (int) (microLatency.size() * 0.9);
		fourP = (int) (microLatency.size() * 0.99);
		fiveP = (int) (microLatency.size() * 0.999);
		System.out.println("The latency of 50th percentiles is : " + microLatency.get(oneP) + "us");
		System.out.println("The latency of 75th percentiles is : " + microLatency.get(twoP) + "us");
		System.out.println("The latency of 90th percentiles is : " + microLatency.get(threeP) + "us");
		System.out.println("The latency of 99th percentiles is : " + microLatency.get(fourP) + "us");
		System.out.println("The latency of 99.9th percentiles is : " + microLatency.get(fiveP) + "us");

	}

	public void microProcess(String fileName, int processor) {
		// get Rates List from CSV file
		CsvReader csvReader = new CsvReader(fileName);
		List<Integer> rates = new ArrayList<>();
		rates = csvReader.getRates();

		// calculate average throughput
		int averThroughput = 0;
		int allRates = 0;
		for (int i = 0; i < rates.size(); i++) {
			allRates += rates.get(i);
		}
		averThroughput = allRates / rates.size();

		System.out.println("average Throughput is: " + averThroughput + " per microsecond");

		// get message
		List<Integer> message = new ArrayList<>();
		Message m = new Message(rates.size());
		message = m.createMicroMessage();

		

		// calculate average latency
		List<Double> latency = new ArrayList<>();
		double allLatency = 0;
		double averLatency = 0;
		for (int i = 0; i < message.size(); i++) {
			double time = 0;
			time = (double) message.get(i) / ((double) rates.get(i) * processor) - 1;
			latency.add(time);
			allLatency += time;
		}
		averLatency = allLatency / rates.size();
		System.out.println("Average latency is : " + averLatency + "us");

		// get distribution of latency
		Collections.sort(latency);
		int oneP = 0, twoP = 0, threeP = 0, fourP = 0, fiveP = 0;
		oneP = (int) (latency.size() * 0.5);
		twoP = (int) (latency.size() * 0.75);
		threeP = (int) (latency.size() * 0.9);
		fourP = (int) (latency.size() * 0.99);
		fiveP = (int) (latency.size() * 0.999);
		System.out.println("The latency of 50th percentiles is : " + latency.get(oneP) + "us");
		System.out.println("The latency of 75th percentiles is : " + latency.get(twoP) + "us");
		System.out.println("The latency of 90th percentiles is : " + latency.get(threeP) + "us");
		System.out.println("The latency of 99th percentiles is : " + latency.get(fourP) + "us");
		System.out.println("The latency of 99.9th percentiles is : " + latency.get(fiveP) + "us");
	}
}
