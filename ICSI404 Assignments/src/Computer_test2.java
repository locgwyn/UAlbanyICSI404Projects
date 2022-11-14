
public class Computer_test2 {
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
		Computer_test.runTests();
		System.out.println();
		Assembler_test.runTests();
		System.out.println();
		runTests();
	}

	public static void runTests() {
		Computer test1 = new Computer();
		String[] testInstructions1 = new String[] { "move R1 10", "jump 6", "move R2 20", "interr 0", "halt" };
		test1.preload(Assembler.assemble(testInstructions1));
		System.out.println("----COMPUTER2 TEST 1----"); // TO FIND TESTS USE CTRL-F
		test1.run();
		Longword[] testRegs1 = test1.getRegisters();
		if (testRegs1[1].toString().equals("fffffffffffffffffffffffffffftftf")
				&& testRegs1[2].toString().equals("ffffffffffffffffffffffffffffffff")) {
			System.out.println("Expected in R1 10 and nothing in R2 : PASS");
		} else {
			System.out.println("Expected in R1 10 and nothing in R2 : FAIL");
		}
		System.out.println();

		Computer test2 = new Computer();
		// Create a simple loop that adds and iterates 3 times using greater than
		String[] testInstructions2 = new String[] { "move R1 3", "move R3 20", "move R4 20", "move R10 1",
				"add R3 R4 R4", "add R0 R10 R0", "compare R1 R0", "branchifgreater -8", "interr 0", "halt" };
		test2.preload(Assembler.assemble(testInstructions2));
		System.out.println("----COMPUTER2 TEST 2----");
		test2.run();
		Longword[] testRegs2 = test2.getRegisters();
		if (testRegs2[4].toString().equals("ffffffffffffffffffffffffftftffff")) {
			System.out.println("Expected in R4 80 : PASS");
		} else {
			System.out.println("Expected in R4 80 : FAIL");
		}
		System.out.println();

		Computer test3 = new Computer();
		// Create a simple loop that iterates by one until R0 equals R1 using not equal
		String[] testInstructions3 = new String[] { "move R0 5", "move R1 10", "move R2 1", "move R10 5", "move R11 5",
				"add R0 R2 R0", "mult R10 R11 R11", "compare R0 R1", "branchifnotequal -8", "interr 0", "halt" };
		test3.preload(Assembler.assemble(testInstructions3));
		System.out.println("----COMPUTER2 TEST 3----");
		test3.run();
		Longword[] testRegs3 = test3.getRegisters();
		if (testRegs3[11].toString().equals("ffffffffffffffffffttttftfffftfft")) {
			System.out.println("Expected in R11 15625 : PASS");
		} else {
			System.out.println("Expected in R11 15625 : FAIL");
		}
		System.out.println();

		Computer test4 = new Computer();
		// Create a simple if statement that subtracts two registers if true using equal
		String[] testInstructions4 = new String[] { "move R2 5", "move R3 6", "move R0 1", "move R6 122", "move R5 21",
				"jump 18", "sub R6 R5 R7", "interr 0", "halt", "compare R3 R2", "branchifequal -10", "add R0 R2 R2",
				"jump 18" };
		test4.preload(Assembler.assemble(testInstructions4));
		System.out.println("----COMPUTER2 TEST 4----");
		test4.run();
		Longword[] testRegs4 = test4.getRegisters();
		if (testRegs4[7].toString().equals("fffffffffffffffffffffffffttfftft")) {
			System.out.println("Expected in R7 101 : PASS");
		} else {
			System.out.println("Expected in R7 101 : FAIL");
		}
		System.out.println();

		Computer test5 = new Computer();
		// Create a simple loop that iterates by 3 until R0 is greater than or equal to R1
		String[] testInstructions5 = new String[] { "move R1 9", "move R2 3", "move R4 56", "move R5 75", "move R6 99",
				"add R4 R5 R5", "add R2 R0 R0", "compare R1 R0", "branchifgreaterorequal -8", "sub R5 R6 R9",
				"interr 0", "halt" };
		test5.preload(Assembler.assemble(testInstructions5));
		System.out.println("----COMPUTER2 TEST 5----");
		test5.run();
		Longword[] testRegs5 = test5.getRegisters();
		if (testRegs5[9].toString().equals("ffffffffffffffffffffffffttfftfff")) {
			System.out.println("Expected in R9 200 : PASS");
		} else {
			System.out.println("Expected in R9 200 : FAIL");
		}
		System.out.println();
	}
}
