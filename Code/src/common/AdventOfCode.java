package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 04.12.2019
 * Project: common.AdventOfCode
 *
 ***********************/
public class AdventOfCode
{
	protected static String[] readInput(int year, int day) throws IOException
	{
		List<String> lines = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(new File("Code\\inputs\\" + year + "\\day" + day + ".txt")));

		boolean endOfTheFile = false;
		while (!endOfTheFile)
		{
			String line = br.readLine();

			if (line == null)
			{
				endOfTheFile = true;
			} else
			{
				lines.add(line);
			}
		}

		br.close();

		return lines.toArray(new String[0]);
	}

	protected static int[] toInt(String[] arr)
	{
		int[] iarr = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			String s = arr[i];
			iarr[i] = Integer.parseInt(s);
		}

		return iarr;
	}
}
