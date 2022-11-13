public class Computer {

	private Bit running = new Bit(true);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();

	private Longword[] registers = new Longword[16];

	private Bit[] opCode = new Bit[] { new Bit(false), new Bit(false), new Bit(false), new Bit(false) };

	// Regular Instructions
	private Longword op1 = new Longword(); // operand 1
	private Longword op2 = new Longword(); // operand 2

	// Move Instruction
	private Longword moveVal = new Longword();

	// Interrupt Instruction
	private Longword interruptParam = new Longword();

	// Jump Instruction
	private Longword jumpAddress = new Longword();

	// Compare and Branch Instructions
	private Bit comp0 = new Bit(false); // result from compare
	private Bit comp1 = new Bit(false);
	private Bit cond0 = new Bit(false); // condition code from instruction
	private Bit cond1 = new Bit(false);
	private Longword regA = new Longword(); // comparison operands
	private Longword regB = new Longword();
	private Longword jumpAmt = new Longword(); // amount to jump
	private Bit willBranch = new Bit(false);

	// Final result
	private int resultRegister = 0;
	private Longword result = new Longword(); // result of operation

	public void run() {
		for (int x = 0; x < 16; x++) { // Initializes the registers
			registers[x] = new Longword();
		}
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
		PC.copy(RippleAdder.add(PC, increment));
	}

	public void decode() {
		Longword fourBitMask = new Longword();
		fourBitMask.set(15); // (tttt)/(1111)
		Longword eightBitMask = new Longword();
		eightBitMask.set(255); // (tttttttt)/(11111111)
		Longword tenBitMask = new Longword();
		tenBitMask.set(1023); // (tttttttttt)/(1111111111) - used for jump address

		// Retrieve the opCode from the current instruction, get nibble 1
		for (int x = 0; x < 4; x++) {
			opCode[x].setBit(currentInstruction.getBit(x).getValue());
		}

		// MOVE instruction
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) {

			// Determine register to move value to (nibble 2)
			resultRegister = currentInstruction.rightShift(24).leftShift(28).rightShift(28).and(fourBitMask)
					.getSigned();

			// Determine the value to move into the register (nibbles 3 and 4)
			moveVal.copy(currentInstruction.rightShift(16).leftShift(24).rightShift(24).and(eightBitMask));

			// Case for negative value, set remaining bits to true
			if (moveVal.getBit(24).getValue() == true) {
				for (int x = 0; x < 24; x++) {
					moveVal.setBit(x, new Bit(true));
				}
			}
			// INTERRUPT instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == false) {
			interruptParam.copy(currentInstruction.rightShift(16).leftShift(28).rightShift(28).and(fourBitMask));

			// JUMP instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == true) {
			// shift to get last 10 bits
			jumpAddress.copy(currentInstruction.rightShift(16).leftShift(22).rightShift(22).and(tenBitMask));

			// COMPARE instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == false) {

			// Determine registers to be compared
			regA.copy(registers[currentInstruction.rightShift(20).leftShift(28).rightShift(28).and(fourBitMask)
					.getSigned()]);
			regB.copy(registers[currentInstruction.rightShift(16).leftShift(28).rightShift(28).and(fourBitMask)
					.getSigned()]);

			// BRANCH instructions
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) {

			// retrieve condition codes
			cond0.setBit(currentInstruction.getBit(20).getValue());
			cond1.setBit(currentInstruction.getBit(21).getValue());

			// Determine amount to jump by
			jumpAmt.copy(currentInstruction.rightShift(16).leftShift(22).rightShift(22).and(tenBitMask));

			// If number is negative, sign extend
			if (jumpAmt.getBit(22).getValue() == true) {
				for (int x = 0; x < 22; x++) {
					jumpAmt.setBit(x, new Bit(true));
				}
			}

		} else { // Otherwise regular decode

			// Determine op1 register, shift to get nibble 2 and then AND with mask of tttt
			// (1111)
			int op1Index = currentInstruction.rightShift(24).leftShift(28).rightShift(28).and(fourBitMask).getSigned();
			op1.copy(registers[op1Index]);

			// Determine op2 register, shift to get nibble 3 and then AND with mask of tttt
			// (1111)
			int op2Index = currentInstruction.rightShift(20).leftShift(28).rightShift(28).and(fourBitMask).getSigned();
			op2.copy(registers[op2Index]);

			// Determine result register, shift to get nibble 4 and then AND with mask of
			// tttt (1111)
			resultRegister = currentInstruction.rightShift(16).leftShift(28).rightShift(28).and(fourBitMask)
					.getSigned();
		}
	}

	public void execute() {
		// HALT instruction
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == false
				&& opCode[3].getValue() == false) { // HALT instruction
			running.setBit(false);
		}
		// MOVE instruction
		else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) { // MOVE instruction
			result.copy(moveVal);

			// INTERRUPT instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == false) {
			if (interruptParam.getBit(31).getValue() == false) { // Print all of the registers
				for (int x = 0; x < 16; x++) {
					System.out.println(registers[x].toString());
				}
				System.out.println();
			} else { // Print all 1024 bytes of memory
				for (int x = 0; x < 1024; x++) {
					Longword address = new Longword();
					address.set(x);
					System.out.println(computerMemory.read(address).toString());
				}
				System.out.println();
			}

			// JUMP instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == true) { // Nothing done in execute
			return;

			// COMPARE instruction
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == false) {
			int regAVal = regA.getSigned();
			int regBVal = regB.getSigned();

			if (regAVal > regBVal) {
				comp0.setBit(true);
				comp1.setBit(false);
			} else if (regAVal >= regBVal) {
				comp0.setBit(true);
				comp1.setBit(true);
			} else {
				comp0.setBit(false);
				comp1.setBit(false);
			}
			return;

			// BRANCH instructions
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) {

			// IfGreaterThanOrEqual (t,t)
			if (cond0.getValue() == true && cond1.getValue() == true) {
				if (comp0.getValue() == cond0.getValue() && comp1.getValue() == cond1.getValue()) {
					willBranch.setBit(true);
					return;
				}
			}

			// IfGreaterThan (t,f)
			else if (cond0.getValue() == true && cond1.getValue() == false) {
				if (comp0.getValue() == cond0.getValue() && comp1.getValue() == cond1.getValue()) {
					willBranch.setBit(true);
					return;
				}
			}

			// IfEqual (f/t,t)
			else if ((cond0.getValue() == false || cond0.getValue() == true) && cond1.getValue() == true) {
				if (comp1.getValue() == cond1.getValue()) {
					willBranch.setBit(true);
					return;
				}
			}
			
			// IfNotEqual (f/t,f)
			else if ((cond0.getValue() == false || cond0.getValue() == true) && cond1.getValue() == false) {
				if (comp1.getValue() == cond1.getValue()) {
					willBranch.setBit(true);
					return;
				}
			}

			// Otherwise do regular op instruction
		} else {
			result.copy(ALU.doOp(opCode, op1, op2));
		}
	}

	public void store() {
		// INTERRUPT, nothing happens in store
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == false) {
			return;

			// JUMP, set PC to new value
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == true) {
			PC.set(jumpAddress.getSigned());
			return;

			// COMPARE, nothing happens in store
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == false) {
			return;

			// BRANCH, if willBranch true then jump, otherwise no jump
		} else if (opCode[0].getValue() == false && opCode[1].getValue() == true && opCode[2].getValue() == false
				&& opCode[3].getValue() == true) {

			if (willBranch.getValue() == true) {
				PC.copy(RippleAdder.add(PC, jumpAmt));
				willBranch.setBit(false);
			} else {
				return;
			}

		} else {
			registers[resultRegister].copy(result);
		}
	}

	public void preload(String[] preloadBits) {
		Longword currentAddress = new Longword();
		Longword completeInstructions = new Longword(); // holds the final set of bits to be stored into memory
		int add = 0; // Address to store the current instruction in
		currentAddress.set(add); // address as a longword

		// Iterate through array of strings
		for (int x = 0; x < preloadBits.length; x++) {
			int currentStringIndex = 15; // Keeps track of the current index of the string

			if (x % 2 == 0) { // Retrieve 1st instruction
				// Writes from the string to the current byte from right to left
				for (int currentBitIndex = 15; currentBitIndex >= 0; currentBitIndex--) {
					// For bitGroup1
					if (preloadBits[x].charAt(currentStringIndex) == 'f') { // if char is f, create a new false bit
						completeInstructions.setBit(currentBitIndex, new Bit(false));
					} else { // otherwise, create a new true bit
						completeInstructions.setBit(currentBitIndex, new Bit(true));
					}
					currentStringIndex--;
				}
			} else { // Retrieve 2nd instruction and then store to memory
				for (int currentBitIndex = 31; currentBitIndex > 15; currentBitIndex--) {
					// For bitGroup1
					if (preloadBits[x].charAt(currentStringIndex) == 'f') { // if char is f, create a new false bit
						completeInstructions.setBit(currentBitIndex, new Bit(false));
					} else { // otherwise, create a new true bit
						completeInstructions.setBit(currentBitIndex, new Bit(true));
					}
					currentStringIndex--;
				}
				computerMemory.write(currentAddress, completeInstructions);

				// Sets a new address to store the next set of instructions
				add += 4;
				currentAddress.set(add);
			}
		}
		// Case where we have an odd amount of instructions, pad with 0's/f's and store
		if (preloadBits.length % 2 == 1) {
			for (int currentBitIndex = 31; currentBitIndex > 15; currentBitIndex--) {
				completeInstructions.setBit(currentBitIndex, new Bit(false));
			}
			computerMemory.write(currentAddress, completeInstructions);
		}
	}

	// Access registers
	public Longword[] getRegisters() {
		return registers;
	}
}
