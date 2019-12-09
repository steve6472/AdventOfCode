package year2019.day7;

import year2019.day5.IntcodeComputer;
import year2019.day5.instructions.ManualInput;
import year2019.day5.instructions.ManualOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		IntcodeComputer cpu = new IntcodeComputer();
		cpu.setupBasicInstructionSet();
		cpu.setExitAtHalt(false);
		cpu.setPrintHalt(false);

		cpu.replaceInstruction(2, new ManualInput(false, PartOne::process, () ->
		{
			if (step == Step.PHASE)
				return sequence[index];
			else
				return output;
		}));

		cpu.replaceInstruction(3, new ManualOutput(false, PartOne::apply));

		int maxOutput = -1;
		int[] maxSequence = new int[0];

		long start = System.currentTimeMillis();

		for (int i = 0; i <= 44444; i++)
		{
			if (output > maxOutput)
			{
				maxOutput = output;
				maxSequence = new int[5];
				System.arraycopy(sequence, 0, maxSequence, 0, 5);
			}
			output = 0;
			if (toSequence(i)) continue;
			for (int j = 0; j < 5; j++)
			{
				index = j;
				cpu.read(2019, 7);
				cpu.run();
			}

			System.out.println(Arrays.toString(sequence) + " " + output);

			if (System.currentTimeMillis() >= start + 2000)
			{
				System.out.println(i);
				start = System.currentTimeMillis();
			}
		}

		System.out.println("Max Output: " + maxOutput);
		System.out.println("Max Sequence: " + Arrays.toString(maxSequence));
	}

	private static boolean toSequence(int i)
	{
		StringBuilder s = new StringBuilder(Integer.toString(i));
		for (int j = 0; j < 5; j++)
		{
			s.insert(0, "0");
		}

		List<Integer> inputed = new ArrayList<>();

		sequence = new int[5];
		for (int j = 0; j < 5; j++)
		{
			int a = Character.getNumericValue(s.charAt(s.length() - j - 1));
			if (a > 4) return true;

			if (inputed.contains(a))
				return true;
			else
				inputed.add(a);

			sequence[4 - j] = a;
		}

		return false;
	}

	private static Step step = Step.INPUT;
	private static int output = 0;
	private static int index = -1;
	private static int[] sequence= {1, 0, 4, 3, 2};

	private static void process()
	{
		if (step == Step.PHASE)
		{
			step = Step.INPUT;
		} else
		{
			step = Step.PHASE;
		}
	}

	private static Object apply(int i)
	{
		output = i;
		return 0;
	}

	enum Step
	{
		PHASE, INPUT
	}
}
