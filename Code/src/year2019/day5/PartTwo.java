package year2019.day5;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class PartTwo
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Input \"5\"");

		IntcodeComputer cpu = new IntcodeComputer();
		cpu.setupBasicInstructionSet();
		cpu.read(2019, 5);
//		cpu.setMemory(3,9,8,9,10,9,4,9,99,-1,8);
//		cpu.setMemory(3,9,7,9,10,9,4,9,99,-1,8);
//		cpu.setMemory(3,3,1108,-1,8,3,4,3,99);
//		cpu.setMemory(3,3,1107,-1,8,3,4,3,99);
//		cpu.setMemory(3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9);
//		cpu.setMemory(3,3,1105,-1,9,1101,0,0,12,4,12,99,1);
		cpu.run();
	}
}
