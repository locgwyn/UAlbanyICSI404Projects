
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
		System.out.println();
		runTests();
	}

	public static void runTests() {
		testComputer();
	}

	public static void testComputer() {
		Computer test1 = new Computer();
		// move 10 into register 2, move 7 into register 1, add register 1 and 2 into register 3, print registers, halt 
		String[] testInstructions1 = new String[] {"ffftfftffffftftf","ffftffftfffffttt","tttfffftfftffftt","fftfffffffffffff","ffffffffffffffff"};
		test1.preload(testInstructions1);
		test1.run();
	}
}
