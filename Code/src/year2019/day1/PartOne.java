package year2019.day1;

import common.AdventOfCode;

import java.io.File;
import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 01.12.2019
 * Project: AdventOfCode_2019
 *
 ***********************/
public class PartOne extends AdventOfCode
{
	public static void main(String[] args) throws IOException
	{
		String[] input = readInput(2019, 1);
		int[] ints = toInt(input);

		int sum = 0;
		for (int i : ints)
		{
			sum += i / 3 - 2;
		}

		System.out.println(sum); // 3406432
	}
}
