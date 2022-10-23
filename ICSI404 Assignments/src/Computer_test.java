
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
		// move 10 into register 2, move 7 into register 1, add register 1 and 2 into register 3, print registers, print memory, halt 
		String[] testInstructions1 = new String[] {"ffftfftffffftftf","ffftffftfffffttt","tttfffftfftffftt","fftfffffffffffff","fftfffffffffffft","ffffffffffffffff"};
		test1.preload(testInstructions1);
		test1.run();
		System.out.println();
		
		Computer test2 = new Computer();
		// move 10 into register 3, move 6 into register 5, subtract register 3 and 5 into register 4, print registers, halt
		String[] testInstructions2 = new String[] {"ffftffttfffftftf","ffftftftfffffttf","ttttffttftftftff","fftfffffffffffff","fftfffffffffffft","ffffffffffffffff"};
		test2.preload(testInstructions2);
		test2.run();
		System.out.println();
		
		Computer test3 = new Computer();
		//
		
		Computer test4 = new Computer();
		//
	}
}
