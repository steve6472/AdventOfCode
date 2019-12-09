package year2019.day2;

import common.AdventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 01.12.2019
 * Project: AdventOfCode_2019
 *
 ***********************/
public class PartTwo extends AdventOfCode
{
	private static int[] ints;

	public static void main(String[] args) throws IOException
	{
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				run(i, j);

				if (ints[0] == 19690720)
				{
					System.out.println(100 * ints[1] + ints[2]); // 6429
					return;
				}
			}
		}
	}

	private static void run(int noun, int verb) throws IOException
	{
		String[] input = readInput(2019, 2);
		ints = toInt(input[0].split(","));

		ints[1] = noun;
		ints[2] = verb;

		int function = 0;

		int index = 0;

		while (function != 99)
		{
			function = ints[index];

			if (function == 1)
			{
				int a = ints[index + 1];
				int b = ints[index + 2];
				int c = ints[index + 3];
				ints[c] = ints[a] + ints[b];
				index += 4;
			}

			if (function == 2)
			{
				int a = ints[index + 1];
				int b = ints[index + 2];
				int c = ints[index + 3];
				ints[c] = ints[a] * ints[b];
				index += 4;
			}

			if (function != 1 && function != 2 && function != 99)
			{
				System.err.println("Opcode not found " + function);
				break;
			}

			System.out.println(Arrays.toString(ints));
		}
	}
}
