package se.file.simulate;


import java.util.Scanner;

import se.file.process.Processing;


public class Simulation {

	public static void main(String[] args) {
		

		// get file name from user
		System.out.println("Please enter file name : ");
		Scanner input = new Scanner(System.in);
		String fileName = input.next();
		
		//get number of processors
		System.out.println("Please enter number of processors : ");
		int p = input.nextInt();
		input.close();
		
		//use process class
		Processing process = new Processing();
		
		if(fileName.equals("FeedRates.csv")) {
			process.secondProess(fileName, p);
		}else {
			process.microProcess(fileName, p);
		}

	}
}
