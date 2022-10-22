
public class Computer_test {
	public static void main(String args[]) {
		Bit_test.runTests();
		System.out.println();
		Longword_test.runTests();
		System.out.println();
		RippleAdder_test.runTests();
		System.out.println();
		Multiplier_test.runTests();
		System.out.println();
		ALU_test.runTests();
		System.out.println();
		Memory_test.runTests();
		runTests();
	}

	public static void runTests() {
		testComputer();
	}

	public static void testComputer() {
		Computer test1 = new Computer();
		String[] testInstructions1 = new String[] {};
	}
}
