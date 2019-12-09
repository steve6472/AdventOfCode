package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Add implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		int a =      getParameter(ic, modes[0], input[0]);
		int b =      getParameter(ic, modes[1], input[1]);
		int output = input[2];

		ic.setValue(output, a + b);
	}

	@Override
	public int opcode()
	{
		return 1;
	}

	@Override
	public int parameters()
	{
		return 3;
	}
}
