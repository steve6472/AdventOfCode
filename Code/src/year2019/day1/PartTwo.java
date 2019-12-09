package year2019.day1;

import common.AdventOfCode;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 01.12.2019
 * Project: AdventOfCode_2019
 *
 ***********************/
public class PartTwo extends AdventOfCode
{
	public static void main(String[] args) throws IOException
	{
		String[] input = readInput(2019, 1);
		int[] ints = toInt(input);

//		int[] ints = {24207, 34612};

		int sum = 0;
		for (int i : ints)
		{
			System.out.println("Input: " + i);
			int temp = i / 3 - 2;
			int tsum = temp;
			while (temp > 0)
			{
				temp = temp / 3 - 2;
				if (temp <= 0)
					break;
				tsum += temp;
				System.out.println("Fuel for fuel: " + temp);
			}
			System.out.println("Fuel for module: " + tsum);
			sum += tsum;
		}

		System.out.println("Fuel for all modules: " + sum); // 5106777
	}
}
