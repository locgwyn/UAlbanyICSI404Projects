public class Computer {

	private Bit running = new Bit(false);
	private Memory computerMemory = new Memory();
	private Longword PC = new Longword();
	private Longword currentInstruction = new Longword();
	private Longword[] registers = new Longword[16];

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
		Longword op1 = new Longword();
		Longword op2 = new Longword();
		
	}

	public void execute() {

	}

	public void store() {

	}
}
