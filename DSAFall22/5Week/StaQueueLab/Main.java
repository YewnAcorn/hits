import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//import System.IO.File.WriteAllLines;
//import System.IO.File.ReadAllLines;

public class Main
{
	public static void main(String args[]) throws FileNotFoundException
	{
		myStack stacky = new myStack();
		StaticQueue quey = new StaticQueue(5);
		stacky.push("h");
		stacky.push("e");
		stacky.push("l");
		stacky.push("l");
		stacky.push("o");

		quey.enqueue(stacky.pop());
		quey.enqueue(stacky.pop());
		quey.enqueue(stacky.pop());
		quey.enqueue(stacky.pop());
		quey.enqueue(stacky.pop());

		System.out.println(quey.dequeue());
		System.out.println(quey.dequeue());
		System.out.println(quey.dequeue());
		System.out.println(quey.dequeue());
		System.out.println(quey.dequeue());
		//prints the reverse
		//o
		//l
		//l
		//e
		//h
		File file = new File("/Users/cart/DSAFall22/5Week/StaQueueLab/input.txt");
		Scanner scnr = new Scanner(file);
		String input = scnr.nextLine();
		System.out.println(input);
		
		myStack leStaque = new myStack();
		StaticQueue monQueue = new StaticQueue(input.length());	
       		for(int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			String s = String.valueOf(c); 
			leStaque.push(s);
		}
		
		for(int j = 0; j < input.length(); j++)
		{
			monQueue.enqueue(leStaque.pop());
		}

		for(int k = 0; k < input.length(); k++)
		{
			System.out.println(monQueue.dequeue());
		}

	
		Queuethulu<String> cute = new Queuethulu<String>();
		cute.enqueue("hello");
		cute.enqueue("self");
		cute.enqueue("good morning");
		cute.enqueue("good night");
		System.out.println(cute.dequeue());
		System.out.println(cute.dequeue());
		System.out.println(cute.dequeue());
		System.out.println(cute.dequeue());

	}
	//this was a brutal lab for some reason it took me forever to get 
	//all these parts to work together just right
	//my question is: how do you get a file read/write to work on another machine
	//like I'll upload this to github and the code wont work for the file parts
	//because its specified to the path on my machine
}
