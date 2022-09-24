
public class Memory {

	private Bit[] memory = new Bit[8192];

	// Fills the memory with false bits
	public Memory() {
		for (int x = 0; x < memory.length; x++) {
			memory[x] = new Bit(false);
		}
	}

	public Longword read(Longword address) {
		Longword readResult = new Longword();
		// Address is by byte for a total of 1024 possible address
		int memoryAddress = (address.getSigned() * 8);
		
		// Used to decrement the index of the longword to be returned
		int resultIndex = 31;
		
		// Reads the bits in memory from right to left, only reads 8 bits since reading by byte
		for (int x = memoryAddress + 7 ; x >= memoryAddress; x--) {
			Bit tempBit = new Bit(memory[x].getValue());
			readResult.setBit(resultIndex, tempBit);
			resultIndex--;
		}
		return readResult;
	}

	// address = 0, read from bit 0 to 7 and copy to another longword
	// address = 1, read from bit 8 to 15 and copy to another longword
	// address = 2, read from bit 16 to 23 and copy to another longword
	// address = 3, read from bit 24 to 31 and copy to another longword

	public void write(Longword address, Longword value) {
		int memoryAddress = (address.getSigned() * 8);
		int writeIndex = 31;
		for (int x = memoryAddress +7; x >= memoryAddress; x--) {
			memory[x] = value.getBit(writeIndex);
			writeIndex--;
		}
	}
}
