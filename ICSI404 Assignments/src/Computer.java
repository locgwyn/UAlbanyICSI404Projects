public class Computer {

	private Bit running = new Bit(false);
	
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
