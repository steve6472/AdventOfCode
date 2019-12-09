package year2019.day5.instructions;

import year2019.day5.IntcodeComputer;

import java.util.function.IntSupplier;

/**********************
 * Created by steve6472 (Mirek Jozefek)
 * On date: 05.12.2019
 * Project: AdventOfCode
 *
 ***********************/
public class ManualInput implements IInstruction
{
	private IntSupplier supplier;
	private Procedure procedure;
	private boolean print;

	public ManualInput(boolean print, Procedure procedure, IntSupplier supplier)
	{
		this.print = print;
		this.procedure = procedure;
		this.supplier = supplier;
	}

	@Override
	public void run(IntcodeComputer ic, int[] modes, int[] input)
	{
		int output = input[0];

		procedure.process();
		int i = supplier.getAsInt();

		if (print)
			System.out.println("Intput: " + i);

		ic.setValue(output, i);
	}

	@Override
	public int opcode()
	{
		return 3;
	}

	@Override
	public int parameters()
	{
		return 1;
	}
}
