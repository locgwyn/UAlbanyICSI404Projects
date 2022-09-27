
public class Memory {

	private Bit[] memory = new Bit[8192];

	// Fills the memory with false bits
	public Memory() {
		for (int x = 0; x < memory.length; x++) {
			memory[x] = new Bit(false);
		}
	}

	// address = 0, read/write from bit 0 to 7
	// address = 1, read/write from bit 8 to 15
	// ... and so on

	public Longword read(Longword address) {
		Longword readResult = new Longword();

		// Address is by byte for a total of 1024 possible address
		int memoryAddress = address.getSigned();

		// Used to decrement the index of the longword to be returned
		int resultIndex = 31;

		// Reads the bits in memory from right to left, reads up to 32 bits since
		// reading by longword except in last 3 bytes, if statements added for these
		// cases

		if (memoryAddress == 1021) { // Reads the last 3 bytes of memory
			for (int x = (memoryAddress * 8) + 23; x >= memoryAddress * 8; x--) {
				Bit tempBit = new Bit(memory[x].getValue());
				readResult.setBit(resultIndex, tempBit);
				resultIndex--;
			}
		} else if (memoryAddress == 1022) { // Reads the last 2 bytes of memory
			for (int x = (memoryAddress * 8) + 15; x >= memoryAddress * 8; x--) {
				Bit tempBit = new Bit(memory[x].getValue());
				readResult.setBit(resultIndex, tempBit);
				resultIndex--;
			}
		} else if (memoryAddress == 1023) { // Reads the last byte of memory
			for (int x = (memoryAddress * 8) + 7; x >= memoryAddress * 8; x--) {
				Bit tempBit = new Bit(memory[x].getValue());
				readResult.setBit(resultIndex, tempBit);
				resultIndex--;
			}
		} else { // Addresses 0 - 1020
			for (int x = (memoryAddress * 8) + 31; x >= memoryAddress * 8; x--) {
				Bit tempBit = new Bit(memory[x].getValue());
				readResult.setBit(resultIndex, tempBit);
				resultIndex--;
			}
		}
		return readResult;
	}

	public void write(Longword address, Longword value) {

		// total 1024 addresses
		int memoryAddress = address.getSigned();

		// Used to decrement the index of the longword to be written to memory
		int writeIndex = 31;

		// Writes the bits in memory from right to left, writes up to 32 bits since
		// writing by Longword except in last 3 bytes, if statements added for these
		// cases

		if (memoryAddress == 1021) { // Writes to last 3 bytes of memory
			for (int x = (memoryAddress * 8) + 23; x >= memoryAddress * 8; x--) {
				memory[x] = value.getBit(writeIndex);
				writeIndex--;
			}
		} else if (memoryAddress == 1022) { // Writes to last 2 bytes of memory
			for (int x = (memoryAddress * 8) + 15; x >= memoryAddress * 8; x--) {
				memory[x] = value.getBit(writeIndex);
				writeIndex--;
			}
		} else if (memoryAddress == 1023) { // Writes to last byte of memory
			for (int x = (memoryAddress * 8) + 7; x >= memoryAddress * 8; x--) {
				memory[x] = value.getBit(writeIndex);
				writeIndex--;
			}
		} else { // Addresses 0 - 1020
			for (int x = (memoryAddress * 8) + 31; x >= memoryAddress * 8; x--) {
				memory[x] = value.getBit(writeIndex);
				writeIndex--;
			}
		}
	}
}
