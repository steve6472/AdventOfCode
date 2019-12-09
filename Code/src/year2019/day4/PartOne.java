package year2019.day4;

import common.AdventOfCode;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 04.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class PartOne extends AdventOfCode
{
	public static void main(String[] args) throws IOException
	{
		String[] input = readInput(2019, 4);
		String[] in = input[0].split("-");
		int out = 0;

		for (int i = Integer.parseInt(in[0]); i < Integer.parseInt(in[1]); i++)
		{
			if (!isSixDigit(i)) continue;
			if (!containsSameNumberTwice(i)) continue;
			if (!isIncresing(i)) continue;
			out++;
		}

		System.out.println(out);
	}

	private static boolean isSixDigit(int n)
	{
		return n > 99999 && n <= 999999;
	}

	private static boolean containsSameNumberTwice(int n)
	{
		String s = "" + n;

		for (int i = 0; i < 6; i++)
		{
			if (s.contains("" + s.charAt(i) + "" + s.charAt(i)))
				return true;
		}

		return false;
	}

	private static boolean isIncresing(int n)
	{
		String s = "" + n;

		int last = 0;

		for (int i = 0; i < 6; i++)
		{
			int now = Integer.parseInt("" + s.charAt(i));
			if (now >= last)
			{
				last = now;
			} else
			{
				return false;
			}
		}

		return true;
	}

}
