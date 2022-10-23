
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
		// move 10 into register 2, move 7 into register 1, add register 1 and 2 into
		// register 3, print registers, print memory, halt
		String[] testInstructions1 = new String[] { "ffftfftffffftftf", "ffftffftfffffttt", "tttfffftfftffftt",
				"fftfffffffffffff", "fftfffffffffffft", "ffffffffffffffff" };
		test1.preload(testInstructions1);
		System.out.println("----TEST 1----"); // TO FIND TESTS USE CTRL-F
		test1.run();
		System.out.println();

		Computer test2 = new Computer();
		// move 10 into register 3, move 6 into register 5, subtract register 3 and 5
		// into register 4, print registers, print memory, halt
		String[] testInstructions2 = new String[] { "ffftffttfffftftf", "ffftftftfffffttf", "ttttffttftftftff",
				"fftfffffffffffff", "fftfffffffffffft", "ffffffffffffffff" };
		test2.preload(testInstructions2);
		System.out.println("----TEST 2----");
		test2.run();
		System.out.println();

		Computer test3 = new Computer();
		// move 67 into register 9, move 3 into register 0, multiply register 9 and 0
		// into register 6, print registers, halt
		String[] testInstructions3 = new String[] { "fffttfftftfffftt", "ffftfffffffffftt", "fttttfftfffffttf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test3.preload(testInstructions3);
		System.out.println("----TEST 3----");
		test3.run();
		System.out.println();

		Computer test4 = new Computer();
		// move 15 into register 4, move 8 into register 8, add register 4 and 8 into 2,
		// add register 4 and 2 into 12, subtract register 12 and 8 into 15, print
		// registers, halt
		String[] testInstructions4 = new String[] { "ffftftfffffftttt", "fffttffffffftfff", "tttfftfftffffftf",
				"tttfftfffftfttff", "ttttttffftfftttt", "fftfffffffffffff", "ffffffffffffffff" };
		test4.preload(testInstructions4);
		System.out.println("----TEST 4----");
		test4.run();
		System.out.println();

		Computer test5 = new Computer();
		// move 57 into register 0, move 34 into register 1, AND register 0 and 1 into
		// 2, print registers, halt
		String[] testInstructions5 = new String[] { "ffftfffffftttfft", "ffftffftfftffftf", "tfffffffffftfftf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test5.preload(testInstructions5);
		System.out.println("----TEST 5----");
		test5.run();
		System.out.println();

		Computer test6 = new Computer();
		// move 83 into register 2, move 122 into register 4, OR register 2 and 4 into
		// 6, print registers, halt
		String[] testInstructions6 = new String[] { "ffftfftfftftfftt", "ffftftfffttttftf", "tfftfftfftfffttf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test6.preload(testInstructions6);
		System.out.println("----TEST 6----");
		test6.run();
		System.out.println();

		Computer test7 = new Computer();
		// move 185 into register 9, move 30 into register 5, XOR register 9 and 5 into
		// 7, print registers, halt
		String[] testInstructions7 = new String[] { "fffttffttftttfft", "ffftftftfffttttf", "tftftfftftftfttt",
				"fftfffffffffffff", "ffffffffffffffff" };
		test7.preload(testInstructions7);
		System.out.println("----TEST 7----");
		test7.run();
		System.out.println();

		Computer test8 = new Computer();
		// move 47 into register 14, move 6 into register 11, LEFTSHIFT register 14 by
		// 11 into 13, print registers, halt
		String[] testInstructions8 = new String[] { "fffttttffftftttt", "fffttfttfffffttf", "ttfftttftfttttft",
				"fftfffffffffffff", "ffffffffffffffff" };
		test8.preload(testInstructions8);
		System.out.println("----TEST 8----");
		test8.run();
		System.out.println();

		Computer test9 = new Computer();
		// move 117 into register 5, move 4 into register 7, RIGHTSHIFT register 5 by 7
		// into 10, print registers, halt
		String[] testInstructions9 = new String[] { "ffftftftftttftft", "ffftftttffffftff", "ttftftftfttttftf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test9.preload(testInstructions9);
		System.out.println("----TEST 9----");
		test9.run();
		System.out.println();

		Computer test10 = new Computer();
		// move 75 into register 1, NOT register 1 and 0 into 2, print registers, halt
		String[] testInstructions10 = new String[] { "ffftffftftfftftt", "tfttffftfffffftf", "fftfffffffffffff",
				"ffffffffffffffff" };
		test10.preload(testInstructions10);
		System.out.println("----TEST 10----");
		test10.run();
		System.out.println();

	}
}
