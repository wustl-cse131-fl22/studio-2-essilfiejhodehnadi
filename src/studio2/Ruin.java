package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter starting amount in dollars: ");
		double startAmount = in.nextDouble();
		System.out.println("Enter win probability as a decimal between 0 and 1: ");
		double winChance = in.nextDouble();
		System.out.println("Enter win limit in dollars: ");
		double winLimit = in.nextDouble();
		System.out.println("Enter number of simulations days you would like to run: ");
		int simNum = in.nextInt();
		double currentAmount = 0.0;
		int playCount = 0;
		double winCount = 0;
		double totalSimulations = 0;
		double winPct = 0;

		// Simulation
		for (int i = 1; i <= simNum; i++) {
			currentAmount = startAmount;
			playCount = 0;

			while ((currentAmount > 0) && (currentAmount < winLimit)) {
				double randomNum = Math.random();
				if (randomNum < winChance) {
					currentAmount = currentAmount + 1;
				} else {
					currentAmount = currentAmount - 1;
				}
				playCount++;
			}

			if (currentAmount <= 0) {
				totalSimulations++;
				System.out.println("Simulation " + i + ": " + playCount + " LOSS");

			} else {
				totalSimulations++;
				winCount++;
				System.out.println("Simulation " + i + ": " + playCount + " WIN");
			}
		}
		
		// Expected Value Calculation
		
		double expectedRuin = 0;
		double alpha = (1 - winChance) / winChance;
		if(winChance == 0.5) {
			expectedRuin = (1 - (startAmount / winLimit));
		} else {
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		
		
		winPct = winCount / totalSimulations;
		int lossCount = (int) (totalSimulations - winCount);
		System.out.println("Losses: " + lossCount + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: " + (1 - winPct) + " Expected ruin rate: " + expectedRuin);
		

	}

}
