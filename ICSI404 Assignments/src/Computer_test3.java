
public class Computer_test3 {
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
		Computer_test2.runTests();
		System.out.println();
		runTests();
	}

	public static void runTests() {
		Computer test1 = new Computer();
		String[] testInstructions1 = new String[] { "move R1 5", "move R2 10", "call 10", "interr 0", "halt",
				"add R1 R2 R3", "return" };
		test1.preload(Assembler.assemble(testInstructions1));
		System.out.println("----COMPUTER3 TEST 1----"); // TO FIND TESTS USE CTRL-F
		test1.run();
		Longword[] testRegs1 = test1.getRegisters();
		if (testRegs1[3].toString().equals("fffffffffffffffffffffffffffftttt")) {
			System.out.println("Expected in R3 15 : PASS");
		} else {
			System.out.println("Expected in R3 15 : FAIL");
		}
		System.out.println();

		Computer test2 = new Computer();
		String[] testInstructions2 = new String[] { "move R0 15", "move R1 25", "push R1", "push R0", "pop R3",
				"pop R4", "sub R3 R4 R5", "interr 0", "halt" };
		test2.preload(Assembler.assemble(testInstructions2));
		System.out.println("----COMPUTER3 TEST 2----");
		test2.run();
		Longword[] testRegs2 = test2.getRegisters();
		if (testRegs2[3].toString().equals("fffffffffffffffffffffffffffftttt")
				&& testRegs2[4].toString().equals("fffffffffffffffffffffffffffttfft")
				&& testRegs2[5].toString().equals("ttttttttttttttttttttttttttttfttf")) {
			System.out.println("Expected in R3 15, Expected in R4 25, Expected in R5 -10 : PASS");
		} else {
			System.out.println("Expected in R3 15, Expected in R4 25, Expected in R5 -10 : FAIL");
		}
		System.out.println();

		Computer test3 = new Computer();
		String[] testInstructions3 = new String[] { "move R3 10", "move R5 43", "move R7 66", "call 12", "interr 0",
				"halt", "push R5", "push R3", "push R7", "pop R9", "pop R10", "pop R11", "sub R9 R10 R12",
				"add R11 R12 R13", "return" };
		test3.preload(Assembler.assemble(testInstructions3));
		System.out.println("----COMPUTER3 TEST 3----");
		test3.run();
		Longword[] testRegs3 = test3.getRegisters();
		if (testRegs3[9].toString().equals("ffffffffffffffffffffffffftfffftf")
				&& testRegs3[10].toString().equals("fffffffffffffffffffffffffffftftf")
				&& testRegs3[11].toString().equals("fffffffffffffffffffffffffftftftt")
				&& testRegs3[12].toString().equals("fffffffffffffffffffffffffftttfff")
				&& testRegs3[13].toString().equals("fffffffffffffffffffffffffttffftt")) {
			System.out.println(
					"Expected in R9 66, Expected in R10 10, Expected in R11 43, Expected in R12 56, Expected in R13 99 : PASS");
		} else {
			System.out.println(
					"Expected in R9 66, Expected in R10 10, Expected in R11 43, Expected in R12 56, Expected in R13 99 : FAIL");
		}
		System.out.println();

	}
}
