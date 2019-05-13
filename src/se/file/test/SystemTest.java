package se.file.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SystemTest {
	public static void main(String[] args) {
		System.out.println("Please enter times your want to input : ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		//get number of processors
		double p;
		System.out.println("Please enter number of processors : ");
		p = input.nextInt();

		List<Double> message = new ArrayList<>();
		List<Double> rate = new ArrayList<>();
		//get message
		System.out.println("Please enter microsecond input rates : ");
		int j = 0,k = 0;
		while (j < n) {
			double inputRates = input.nextInt();
			message.add(inputRates);
			j++;
		}
		//get rate
		System.out.println("Please enter processor speeds : ");
		while (k < n) {
			double inputSpeed = input.nextInt();
			rate.add(inputSpeed);
			k++;
		}
		input.close();
		
		//calculate average latency
		List<Double> latency = new ArrayList<>();
		double allLatency = 0, averLatency = 0;
		for(int i = 0; i < n; i++) {
			double time = 0;
			time = message.get(i) / (rate.get(i) * p) - 1;
			latency.add(time);
			allLatency += time;
		}
		averLatency = allLatency / latency.size();
		System.out.println("average latency is :" + averLatency);
		
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
