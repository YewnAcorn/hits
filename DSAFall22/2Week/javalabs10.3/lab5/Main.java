import java.util.Scanner;
import java.util.Random;


public class Main
{
	public static void main(String args[])
	{
		Random rand = new Random();
		int upper = 15;
		Scanner scnr = new Scanner(System.in);
		int points = 0;
		for (int g = 0; g < 20; ++g)
		{
			int num1 = (rand.nextInt(upper) + 1);
			int num2 = (rand.nextInt(upper) + 1);
			int operation = (rand.nextInt(4));
			switch (operation)
			{
				case 0:
				System.out.println("what is " + num1 + " + " + num2);
				int answer = scnr.nextInt();
				if(answer == (num1 + num2))
				{
					System.out.println("correct");
					points++;
				}	
				else
				{
					System.out.println("incorrect");
				}

				break;
				case 1:
				System.out.println("what is " + num1 + " * " + num2);
				int answer1 = scnr.nextInt();
				if(answer1 == (num1 * num2))
				{
					System.out.println("correct");
					points++;
				}	
				else
				{
					System.out.println("incorrect");
				}
				break;
				case 2:
				System.out.println("what is " + num1 + " - " + num2);
				int answer2 = scnr.nextInt();
				if(answer2 == (num1 - num2))
				{
					System.out.println("correct");
					points++;
				}	
				else
				{
					System.out.println("incorrect");
				}
				break;
				case 3:
				System.out.println("what is " + num1 + " / " + num2);
				System.out.println("(rounded down)");
				int answer3 = scnr.nextInt();
				if(answer3 == (num1 / num2))
				{
					System.out.println("correct");
					points++;
				}	
				else
				{
					System.out.println("incorrect");
				}
				break;
			}
		}
		System.out.println("Points total: " + points + "/20");
	}
}
