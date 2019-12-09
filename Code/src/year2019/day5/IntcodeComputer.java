package year2019.day5;

import common.AdventOfCode;
import year2019.day5.instructions.*;

import java.io.IOException;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class IntcodeComputer extends AdventOfCode
{
	private int[] memory;
	private int index;
	private boolean indexFlag = false;
	private boolean exitAtHalt = true;
	private boolean printHalt = true;

	private IInstruction[] instructions;

	public static void main(String[] args) throws IOException
	{
		IntcodeComputer cpu = new IntcodeComputer();
		cpu.read(2019, 5);
//		cpu.setState(1, 12, 2, 2);
//		cpu.setMemory(1102, 33, 3, 4, 0);
//		cpu.setMemory(1101, 100, -1, 4, 0);
//		cpu.setMemory(3, 0, 4, 0, 99);
//		cpu.setMemory(1101, 100, -1, 4, 0);
		cpu.run();
//		System.out.println(cpu.readValue(0));
	}

	public void setInstructions(IInstruction... instructions)
	{
		this.instructions = instructions;
	}

	public void setupBasicInstructionSet()
	{
		instructions = new IInstruction[] {
			new Add(),
			new Multiply(),
			new Input(),
			new Output(),
			new Halt(),
			new Equals(),
			new JumpIfTrue(),
			new JumpIfFalse(),
			new LessThan()
		};
	}

	public void replaceInstruction(int index, IInstruction instruction)
	{
		this.instructions[index] = instruction;
	}

	public void run()
	{
		int opcode;

		main : while (true)
		{
			opcode = memory[index];

			if (opcode == 99)
			{
				index = 0;
				if (printHalt)
					System.out.println("Halt");
				if (exitAtHalt)
					System.exit(99);
				return;
			}

			for (IInstruction instruct : instructions)
			{
				if (instruct.opcode() == parseOpcode(opcode))
				{
					int[] input = getInput(instruct, index);
					int[] modes = getParameterModes(instruct, opcode);

					try
					{
						instruct.run(this, modes, input);
					} catch (Exception ex)
					{
						System.err.println(String.format("Error at index '%d'", index));
						ex.printStackTrace();
						System.exit(0);
					}
					if (!indexFlag)
					{
						index += instruct.parameters() + 1;
					} else
					{
						indexFlag = false;
					}
					continue main;
				}
			}

			throw new IllegalArgumentException(String.format("Opcode '%d' not found at index '%d'", parseOpcode(opcode), index));
		}
	}

	public void setIndex(int index)
	{
		this.index = index;
		indexFlag = true;
	}

	private int[] getParameterModes(IInstruction instruction, int opcode)
	{
		int[] modes = new int[instruction.parameters()];
		for (int i = 0; i < modes.length; i++)
		{
			modes[i] = getDigit(opcode, 2 - i);
		}
		return modes;
	}

	private int getDigit(int value, int digit)
	{
		return Character.getNumericValue(intToString(value).charAt(digit));
	}

	private String intToString(int value)
	{
		StringBuilder s = new StringBuilder(Integer.toString(value));
		while (s.length() < 5)
		{
			s.insert(0, "0");
		}
		return s.toString();
	}

	private int parseOpcode(int value)
	{
		String s = intToString(value);
		return Integer.parseInt(s.substring(s.length() - 2));
	}

	private int[] getInput(IInstruction instruction, int index)
	{
		int[] input = new int[instruction.parameters()];
		for (int i = 0; i < instruction.parameters(); i++)
		{
			input[i] = memory[index + i + 1];
		}
		return input;
	}

	public void setState(int... state)
	{
		if (state.length % 2 == 1)
			throw new IllegalStateException("State has no pair! (address, value)");

		for (int i = 0; i < state.length / 2; i++)
		{
			memory[state[i * 2]] = state[i * 2 + 1];
		}
	}

	public void setValue(int address, int value)
	{
		memory[address] = value;
	}

	public int readValue(int address)
	{
		return memory[address];
	}

	public void setMemory(int... memory)
	{
		this.memory = memory;
	}

	public int[] getMemory()
	{
		return memory;
	}

	public void read(int year, int day) throws IOException
	{
		String[] input = readInput(year, day);
		setMemory(toInt(input[0].split(",")));
	}

	public boolean isExitAtHalt()
	{
		return exitAtHalt;
	}

	public void setExitAtHalt(boolean exitAtHalt)
	{
		this.exitAtHalt = exitAtHalt;
	}

	public boolean isPrintHalt()
	{
		return printHalt;
	}

	public void setPrintHalt(boolean printHalt)
	{
		this.printHalt = printHalt;
	}
}
