package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 06.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Equals implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		int val0 = getParameter(ic, modes[0], input[0]);
		int val1 = getParameter(ic, modes[1], input[1]);

		if (val0 == val1)
		{
			ic.setValue(input[2], 1);
		} else
		{
			ic.setValue(input[2], 0);
		}
	}

	@Override
	public int opcode()
	{
		return 8;
	}

	@Override
	public int parameters()
	{
		return 3;
	}
}
