package year2019.day2;

import common.AdventOfCode;

import java.io.IOException;
import java.util.Arrays;

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
		String[] input = readInput(2019, 2);
		int[] ints = toInt(input[0].split(","));

		ints[1] = 12;
		ints[2] = 2;

		int function;

		for (int i1 = 0; i1 < ints.length; i1++)
		{
			function = ints[i1];

			if (function == 1)
			{
				int a = ints[i1 + 1];
				int b = ints[i1 + 2];
				int c = ints[i1 + 3];
				ints[c] = ints[a] + ints[b];
				i1 += 3;
			}

			if (function == 2)
			{
				int a = ints[i1 + 1];
				int b = ints[i1 + 2];
				int c = ints[i1 + 3];
				ints[c] = ints[a] * ints[b];
				i1 += 3;
			}

			if (function == 99)
			{
				break;
			}

			System.out.println(Arrays.toString(ints));
		}

		System.out.println(ints[0]); // 3716293
	}
}
