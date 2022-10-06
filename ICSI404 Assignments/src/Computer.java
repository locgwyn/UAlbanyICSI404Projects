public class Computer {

	private Bit running = new Bit(false);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();
	private Longword[] registers = new Longword[16];
	private Longword op1 = new Longword();
	private Longword op2 = new Longword();
	private Longword opCode = new Longword();
	private Longword result = new Longword();

	public void run() {
		PC.set(0);
		while (running.getValue() == true) {
			fetch();
			decode();
			execute();
			store();
		}
	}

	public void fetch() {
		currentInstruction = computerMemory.read(PC);
		Longword increment = new Longword();
		increment.set(2);
		RippleAdder.add(PC, increment);
	}

	public void decode() {
		
		// Determine op1, shift to get nibble 2 and then AND with 16 bit instruction
		op1 = currentInstruction.rightShift(24).leftShift(28).rightShift(28).and(currentInstruction.rightShift(16));
		// Determine op2, shift to get nibble 3 and then AND with 16 bit instruction
		op2 = currentInstruction.rightShift(20).leftShift(24).rightShift(24).and(currentInstruction.rightShift(16));
		
		// Both result in the index of the register to be copied from, need the actual value from the registers
	}

	public void execute() {

	}

	public void store() {

	}
}
