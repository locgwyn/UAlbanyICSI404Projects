
public class Memory {

	private Bit[] memory = new Bit[8192];

	public Longword read(Longword address) {
		Longword readResult = new Longword();
		int memoryAddress = (address.getSigned() * 31) + address.getSigned();
		for (int x = memoryAddress; x < x + 32; x++) {
			Bit tempBit = new Bit(memory[x].getValue());
			readResult.setBit(x, tempBit);
		}

		return readResult;
	}

	// address = 0, read from bit 0 to 31 and copy to another longword
	// address = 1, read from bit 32 to 63 and copy to another longword
	// address = 2, read from bit 64 to 95 and copy to another longword
	// address = 3, read from bit 96 to 127 and copy to another longword

	public void write(Longword address, Longword value) {
		int memoryAddress = (address.getSigned() * 31) + address.getSigned();
		for (int x = memoryAddress; x < x + 32; x++) {
			memory[x] = value.getBit(x);
		}
	}
}
