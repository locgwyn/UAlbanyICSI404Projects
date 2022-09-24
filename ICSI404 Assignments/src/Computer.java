public class Computer {

	private Bit running = new Bit(false);
	private Memory computerMemory = new Memory();
	
	public void run() {
		while (running.getValue() == true) {
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	public void fetch() {
		
	}
	
	public void decode() {
		
	}
	
	public void execute() {
		
	}
	
	public void store() {
		
	}
}
