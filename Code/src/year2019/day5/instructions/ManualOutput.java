package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

import java.util.function.IntFunction;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class ManualOutput implements IInstruction
{
	private IntFunction function;
	private boolean print;

	public ManualOutput(boolean print, IntFunction function)
	{
		this.print = print;
		this.function = function;
	}

	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		function.apply(getParameter(ic, modes[0], input[0]));
		if (print)
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
