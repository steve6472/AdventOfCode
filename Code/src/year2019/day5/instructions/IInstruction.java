package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public interface IInstruction
{
	void run(IntcodeComputer ic, int[] modes, int[] input);

	/**
	 * Do NOT use on input where the instructions writes data to
	 *
	 * @param ic Intcode Computer Instance
	 * @param mode either position or immediate
	 * @param input input
	 * @return input or value at position of input
	 */
	default int getParameter(IntcodeComputer ic, int mode, int input)
	{
		if (mode == 0)
		{
			return ic.readValue(input);
		} else
		{
			return input;
		}
	}

	int opcode();

	int parameters();
}
