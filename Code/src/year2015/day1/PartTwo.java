package year2015.day1;

import common.AdventOfCode;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 01.12.2019
 * Project: AdventOfCode_2015
 *
 ***********************/
public class PartTwo extends AdventOfCode
{
	public static void main(String[] args) throws IOException
	{
		String[] arr = readInput(2015, 1);

		int floor = 0;
		int index = 1;
		for (String s : arr[0].split(""))
		{
			if (s.equals("("))
				floor++;
			else if (s.equals(")"))
				floor--;

			if (floor == -1)
			{
				System.out.println("Basement: " + index);
				return;
			}
			index++;
		}
	}
}
