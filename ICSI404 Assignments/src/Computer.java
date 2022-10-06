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
		
		// Determine op1, shift and then AND
		
		// Determine op2, shift and then AND
		
	}

	public void execute() {

	}

	public void store() {

	}
}
