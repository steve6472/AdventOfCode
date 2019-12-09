package year2019.day5;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class PartOne
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Input \"1\"\n" +
			"If the output is always \"0\" the tests are passing\n" +
			"The last output is diagnostic code!\n\n");

		IntcodeComputer cpu = new IntcodeComputer();
		cpu.setupBasicInstructionSet();
		cpu.read(2019, 5);
		cpu.run();
	}
}
