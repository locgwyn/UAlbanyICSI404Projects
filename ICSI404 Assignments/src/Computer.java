public class Computer {

	private Bit running = new Bit(false);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();

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
		int currentInstructionIndex = 31;
	}

	public void decode() {
		// USE MASKING BY SHIFTING BITS
	}

	public void execute() {

	}

	public void store() {

	}
}
