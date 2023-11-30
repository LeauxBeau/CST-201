package app;

import java.util.Scanner;

public class SumOfDigits 
{
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please a 5-digit integer: ");
		
		int num = kb.nextInt();
		
		int fNum = num % 10;
		int sNum = num / 10 % 10;
		int tNum = num / 100 % 10;
		int fourNum = num / 1000 % 10;
		int fiNum = num / 10000 % 10;
		
		int total = fNum + sNum + tNum + fourNum + fiNum;
		
		System.out.println("The sum of the digits is: " + fNum + "+" + sNum + "+" + tNum + "+" + 
		fourNum + "+" + fiNum + "=" + total);
		
	}

}
