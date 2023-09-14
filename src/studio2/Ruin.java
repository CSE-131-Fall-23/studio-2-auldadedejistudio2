package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		//variables
		double startAmount = 100;
		double winChance = .50;
		double winLimit = 200;
		int roundsPlayed = 0; 
		double winProbability = (1-winChance)/winChance; 
		double expectedRuinRate = ((((1-startAmount)/ startAmount)- winProbability)/ (1- winProbability))/100;
		int wins = 0;
		int loses = 0;
		int doneDays =0; 


		//how many days
		System.out.println ("How many days?");
		int wantedDays = in.nextInt();

		while (wantedDays > doneDays)
		{
			while ( startAmount > 0 && startAmount < winLimit)
			{
				double gameResult = Math.random();

				if (gameResult <= winChance)
				{
					startAmount++;

				}
				else 
				{
					startAmount--;

				}

				roundsPlayed++;
				
				
			}
			if (startAmount == 0)
			{
				loses++;
				System.out.println("Boo! You lost in " + roundsPlayed + ".");
			}
			else if (startAmount >= winLimit)

			{
				wins++;
				System.out.println("Yay! You won in " + roundsPlayed + ".");
			}
			roundsPlayed = 0;
			startAmount = 100;
			doneDays++;

		}
		// ruin rate from game
		double gameRuinRate = (double) loses/ (doneDays); 
		System.out.println("Expected Ruin Rate: " + expectedRuinRate);
		System.out.println("Loses: " + loses + ". Wins: " + wins);
		System.out.println("Game Ruin Rate: " + gameRuinRate);

	}

}
