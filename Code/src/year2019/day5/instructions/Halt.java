package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Halt implements IInstruction
{
	/**
	 * Never gets called as check for opcode 99 is in the loop
	 */
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		System.out.println("Halt");
	}

	@Override
	public int opcode()
	{
		return 99;
	}

	@Override
	public int parameters()
	{
		return 0;
	}
}
