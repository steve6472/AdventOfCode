package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class Multiply implements IInstruction
{
	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		/*
		System.out.println(Arrays.toString(memory));
		System.out.println(Arrays.toString(modes));
		System.out.println(Arrays.toString(input));
		*/

		int a =      getParameter(ic, modes[0], input[0]);
		int b =      getParameter(ic, modes[1], input[1]);
		int output = input[2];

		/*
		System.out.println(String.format("%d, %d, %d", a, b, output));
		 */

		ic.setValue(output, a * b);
	}

	@Override
	public int opcode()
	{
		return 2;
	}

	@Override
	public int parameters()
	{
		return 3;
	}
}
