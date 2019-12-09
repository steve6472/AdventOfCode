package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 06.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class JumpIfTrue implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		int val = getParameter(ic, modes[0], input[0]);

		if (val != 0)
		{
			ic.setIndex(getParameter(ic, modes[1], input[1]));
		}
	}

	@Override
	public int opcode()
	{
		return 5;
	}

	@Override
	public int parameters()
	{
		return 2;
	}
}
