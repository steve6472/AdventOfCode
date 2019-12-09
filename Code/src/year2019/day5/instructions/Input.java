package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

import java.util.Scanner;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Input implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		int output = input[0];

		System.out.print("Intput: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		int i = 0;

		try
		{
			i = Integer.parseInt(s);
		} catch (NumberFormatException ex)
		{
			System.err.println("Input is not a number!");
		}

		ic.setValue(output, i);
	}

	@Override
	public int opcode()
	{
		return 3;
	}

	@Override
	public int parameters()
	{
		return 1;
	}
}
