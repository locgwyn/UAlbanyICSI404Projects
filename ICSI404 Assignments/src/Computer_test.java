
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
		System.out.println("----COMPUTER TEST 1----"); // TO FIND TESTS USE CTRL-F
		test1.run();
		Longword[] testRegs1 = test1.getRegisters();
		if (testRegs1[3].toString().equals("ffffffffffffffffffffffffffftffft")) {
			System.out.println("Expected in R3 17 : PASS");
		} else {
			System.out.println("Expected in R3 17 : FAIL");
		}
		System.out.println();
		

		Computer test2 = new Computer();
		// move 10 into register 3, move 6 into register 5, subtract register 3 and 5
		// into register 4, print registers, print memory, halt
		String[] testInstructions2 = new String[] { "ffftffttfffftftf", "ffftftftfffffttf", "ttttffttftftftff",
				"fftfffffffffffff", "fftfffffffffffft", "ffffffffffffffff" };
		test2.preload(testInstructions2);
		System.out.println("----COMPUTER TEST 2----");
		test2.run();
		Longword[] testRegs2 = test2.getRegisters();
		if (testRegs2[4].toString().equals("ffffffffffffffffffffffffffffftff")) {
			System.out.println("Expected in R4 4 : PASS");
		} else {
			System.out.println("Expected in R4 4 : FAIL");
		}
		System.out.println();

		Computer test3 = new Computer();
		// move 67 into register 9, move 3 into register 0, multiply register 9 and 0
		// into register 6, print registers, halt
		String[] testInstructions3 = new String[] { "fffttfftftfffftt", "ffftfffffffffftt", "fttttfftfffffttf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test3.preload(testInstructions3);
		System.out.println("----COMPUTER TEST 3----");
		test3.run();
		Longword[] testRegs3 = test3.getRegisters();
		if (testRegs3[6].toString().equals("ffffffffffffffffffffffffttfftfft")) {
			System.out.println("Expected in R6 201 : PASS");
		} else {
			System.out.println("Expected in R6 201 : FAIL");
		}
		System.out.println();

		Computer test4 = new Computer();
		// move 57 into register 0, move 34 into register 1, AND register 0 and 1 into
		// 2, print registers, halt
		String[] testInstructions4 = new String[] { "ffftfffffftttfft", "ffftffftfftffftf", "tfffffffffftfftf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test4.preload(testInstructions4);
		System.out.println("----COMPUTER TEST 4----");
		test4.run();
		Longword[] testRegs4 = test4.getRegisters();
		if (testRegs4[2].toString().equals("fffffffffffffffffffffffffftfffff")) {
			System.out.println("Expected in R2 32 : PASS");
		} else {
			System.out.println("Expected in R2 32 : FAIL");
		}
		System.out.println();

		Computer test5 = new Computer();
		// move 83 into register 2, move 122 into register 4, OR register 2 and 4 into
		// 6, print registers, halt
		String[] testInstructions5 = new String[] { "ffftfftfftftfftt", "ffftftfffttttftf", "tfftfftfftfffttf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test5.preload(testInstructions5);
		System.out.println("----COMPUTER TEST 5----");
		test5.run();
		Longword[] testRegs5 = test5.getRegisters();
		if (testRegs5[6].toString().equals("fffffffffffffffffffffffffttttftt")) {
			System.out.println("Expected in R6 123 : PASS");
		} else {
			System.out.println("Expected in R6 123 : FAIL");
		}
		System.out.println();

		Computer test6 = new Computer();
		// move 111 into register 9, move 30 into register 5, XOR register 9 and 5 into
		// 7, print registers, halt
		String[] testInstructions6 = new String[] { "fffttfftfttftttt", "ffftftftfffttttf", "tftftfftftftfttt",
				"fftfffffffffffff", "ffffffffffffffff" };
		test6.preload(testInstructions6);
		System.out.println("----COMPUTER TEST 6----");
		test6.run();
		Longword[] testRegs6 = test6.getRegisters();
		if (testRegs6[7].toString().equals("ffffffffffffffffffffffffftttffft")) {
			System.out.println("Expected in R7 113 : PASS");
		} else {
			System.out.println("Expected in R7 113 : FAIL");
		}
		System.out.println();

		Computer test7 = new Computer();
		// move 47 into register 14, move 6 into register 11, LEFTSHIFT register 14 by
		// 11 into 13, print registers, halt
		String[] testInstructions7 = new String[] { "fffttttffftftttt", "fffttfttfffffttf", "ttfftttftfttttft",
				"fftfffffffffffff", "ffffffffffffffff" };
		test7.preload(testInstructions7);
		System.out.println("----COMPUTER TEST 7----");
		test7.run();
		Longword[] testRegs7 = test7.getRegisters();
		if (testRegs7[13].toString().equals("fffffffffffffffffffftfttttffffff")) {
			System.out.println("Expected in R13 3008 : PASS");
		} else {
			System.out.println("Expected in R13 3008 : FAIL");
		}
		System.out.println();

		Computer test8 = new Computer();
		// move 117 into register 5, move 4 into register 7, RIGHTSHIFT register 5 by 7
		// into 10, print registers, halt
		String[] testInstructions8 = new String[] { "ffftftftftttftft", "ffftftttffffftff", "ttftftftfttttftf",
				"fftfffffffffffff", "ffffffffffffffff" };
		test8.preload(testInstructions8);
		System.out.println("----COMPUTER TEST 8----");
		test8.run();
		Longword[] testRegs8 = test8.getRegisters();
		if (testRegs8[10].toString().equals("fffffffffffffffffffffffffffffttt")) {
			System.out.println("Expected in R10 7 : PASS");
		} else {
			System.out.println("Expected in R10 7 : FAIL");
		}
		System.out.println();

		Computer test9 = new Computer();
		// move 75 into register 1, NOT register 1 and 0 into 2, print registers, halt
		String[] testInstructions9 = new String[] { "ffftffftftfftftt", "tfttffftfffffftf", "fftfffffffffffff",
				"ffffffffffffffff" };
		test9.preload(testInstructions9);
		System.out.println("----COMPUTER TEST 9----");
		test9.run();
		Longword[] testRegs9 = test9.getRegisters();
		if (testRegs9[2].toString().equals("tttttttttttttttttttttttttfttftff")) {
			System.out.println("Expected in R2 4294967220 : PASS");
		} else {
			System.out.println("Expected in R2 4294967220 : FAIL");
		}
		System.out.println();

	}
}
