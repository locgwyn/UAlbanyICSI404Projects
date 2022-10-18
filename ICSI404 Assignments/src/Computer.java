public class Computer {

	// TEST
	private Bit running = new Bit(true);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();

	private Longword[] registers = new Longword[16];
	private Bit[] opCode = new Bit[4]; // Holds the opCode from the instruction
	private Longword op1 = new Longword(); // operand 1
	private Longword op2 = new Longword(); // operand 2
	private int moveVal;
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
		currentInstruction.copy(computerMemory.read(PC));
		// Increment PC by 2
		Longword increment = new Longword();
		increment.set(2);
		RippleAdder.add(PC, increment);
	}

	public void decode() {
		Longword mask = new Longword();
		mask.set(15);

		// Retrieve the opCode from the current instruction, get nibble 1
		for (int x = 0; x < 4; x++) {
			opCode[x].setBit(currentInstruction.getBit(x).getValue());
		}

		// MOVE instruction
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) {
			// Determine register to move value to (nibble 2)
			int op1Index = currentInstruction.rightShift(24).leftShift(28).rightShift(28).and(mask).getSigned();
			op1.copy(registers[op1Index]);
			
			// Determine the value to move into the register
			
		} else {
			// Determine op1 register, shift to get nibble 2 and then AND with mask of tttt
			// (1111)
			int op1Index = currentInstruction.rightShift(24).leftShift(28).rightShift(28).and(mask).getSigned();
			op1.copy(registers[op1Index]);

			// Determine op2 register, shift to get nibble 3 and then AND with mask of tttt
			// (1111)
			int op2Index = currentInstruction.rightShift(20).leftShift(28).rightShift(28).and(mask).getSigned();
			op2.copy(registers[op2Index]);

		}
	}

	public void execute() {
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == false
				&& opCode[3].getValue() == false) { // HALT instruction
			running.setBit(false);
		} else { // Otherwise regular op instruction
			result.copy(ALU.doOp(opCode, op1, op2));
		}
	}

	public void store() {
		Longword mask = new Longword();
		mask.set(15);
		// Determine result register, shift to get nibble 4, and then AND with mask
		int resultIndex = currentInstruction.rightShift(16).leftShift(28).rightShift(28).and(mask).getSigned();
		registers[resultIndex].copy(result);
	}
}
