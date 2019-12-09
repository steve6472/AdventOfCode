package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Output implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		System.out.println("Out: " + getParameter(ic, modes[0], input[0]));
	}

	@Override
	public int opcode()
	{
		return 4;
	}

	@Override
	public int parameters()
	{
		return 1;
	}
}
