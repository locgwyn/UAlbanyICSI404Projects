public class Computer {

	private Bit running = new Bit(true);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();

	private Longword[] registers = new Longword[16];

	private Bit[] opCode = new Bit[4]; // Holds the opCode from the instruction

	// Regular Instructions
	private Longword op1 = new Longword(); // operand 1
	private Longword op2 = new Longword(); // operand 2

	// Move Instruction
	private Longword moveVal = new Longword();

	// Interrupt Instruction
	private Longword interruptParam = new Longword();

	// Final result
	private int resultRegister = 0;
	private Longword result = new Longword(); // result of operation

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
		Longword fourBitMask = new Longword();
		fourBitMask.set(15); // (tttt)/(1111)
		Longword eightBitMask = new Longword();
		eightBitMask.set(255); // (tttttttt)/(11111111)

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

				// INTERRUPT instruction
			} else if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
					&& opCode[3].getValue() == false) {
				interruptParam.copy(currentInstruction.rightShift(16).leftShift(28).rightShift(28).and(fourBitMask));
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
			// tttt
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
			} else { // Print all 1024 bytes of memory
				for (int x = 0; x < 1024; x++) {
					Longword address = new Longword();
					address.set(x);
					System.out.println(computerMemory.read(address).toString());
				}
			}
			// Otherwise do regular op instruction
		} else {
			result.copy(ALU.doOp(opCode, op1, op2));
		}
	}

	public void store() {
		if (opCode[0].getValue() == false && opCode[1].getValue() == false && opCode[2].getValue() == true
				&& opCode[3].getValue() == false) { // INTERRUPT, nothing happens in store
			return;
		}
		registers[resultRegister].copy(result);
	}

	// IDEA: Create a temporary longword to store the 1st set of instructions and
	// then check if there are more,
	// if yes then get the next instruction and append it to the temporary
	// instruction to make the full longword
	// otherwise, pad the temporary instruction with 0's/f's

	public void preload(String[] preloadBits) {
		Longword currentAddress = new Longword();
		int add = 0; // Address to store the current instruction in
		currentAddress.set(add); // address as a longword

		// Iterate through array of strings
		for (int x = 0; x < preloadBits.length; x++) {
			Longword completeInstructions = new Longword(); // holds the final set of bits to be stored into memory
			int currentStringIndex = 16; // Keeps track of the current index of the string

			if (x % 2 == 0) { // Retrieve 1st instruction
				// Writes from the string to the current byte from right to left
				for (int currentBitIndex = 31; currentBitIndex > 15; currentBitIndex--) {
					// For bitGroup1
					if (preloadBits[x].charAt(currentStringIndex) == 'f') { // if char is f, create a new false bit
						completeInstructions.setBit(currentBitIndex, new Bit(false));
					} else { // otherwise, create a new true bit
						completeInstructions.setBit(currentBitIndex, new Bit(true));
					}
					currentStringIndex--;
				}
			} else { // Retrieve 2nd instruction and then store to memory
				for (int currentBitIndex = 15; currentBitIndex > 0; currentBitIndex--) {
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
			// Case where we have an odd amount of instructions, pad with 0's/f's and store
			if (preloadBits.length % 2 == 1) { 
				for (int currentBitIndex = 15; currentBitIndex > 0; currentBitIndex--) {
					completeInstructions.setBit(currentBitIndex, new Bit(false));
				}
				computerMemory.write(currentAddress, completeInstructions);
			}
		}
	}
}
