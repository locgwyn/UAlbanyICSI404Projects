
public class Assembler_test {
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
		runTests();
	}

	public static void runTests() {
		Computer test1 = new Computer(); // add
		String[] testInstructions1 = new String[] { "move R2 10", "move R1 7", "add R1 R2 R3", "interr 0", "halt" };
		test1.preload(Assembler.assemble(testInstructions1));
		System.out.println("----ASSEMBLER TEST 1----"); // TO FIND TESTS USE CTRL-F
		test1.run();
		Longword[] testRegs1 = test1.getRegisters();
		if (testRegs1[3].toString().equals("ffffffffffffffffffffffffffftffft")) {
			System.out.println("Expected in R3 17 : PASS");
		} else {
			System.out.println("Expected in R3 17 : FAIL");
		}
		System.out.println();

		Computer test2 = new Computer(); // sub
		String[] testInstructions2 = new String[] { "move R5 -5", "move R6 21", "sub R5 R6 R7", "interr 0", "halt" };
		test2.preload(Assembler.assemble(testInstructions2));
		System.out.println("----ASSEMBLER TEST 2----");
		test2.run();
		Longword[] testRegs2 = test2.getRegisters();
		if (testRegs2[7].toString().equals("tttttttttttttttttttttttttttffttf")) {
			System.out.println("Expected in R7 -26 : PASS");
		} else {
			System.out.println("Expected in R7 -26 : FAIL");
		}
		System.out.println();
		
		Computer test3 = new Computer(); // mult
		String[] testInstructions3 = new String[] { "move R10 54", "move R6 5", "mult R10 R6 R8", "interr 0", "halt" };
		test3.preload(Assembler.assemble(testInstructions3));
		System.out.println("----ASSEMBLER TEST 3----");
		test3.run();
		Longword[] testRegs3 = test3.getRegisters();
		if (testRegs3[8].toString().equals("ffffffffffffffffffffffftfffftttf")) {
			System.out.println("Expected in R8 270 : PASS");
		} else {
			System.out.println("Expected in R8 270 : FAIL");
		}
		System.out.println();
		
		Computer test4 = new Computer(); // and
		String[] testInstructions4 = new String[] { "move R15 100", "move R14 123", "and R15 R14 R13", "interr 0", "halt" };
		test4.preload(Assembler.assemble(testInstructions4));
		System.out.println("----ASSEMBLER TEST 4----");
		test4.run();
		Longword[] testRegs4 = test4.getRegisters();
		if (testRegs4[13].toString().equals("fffffffffffffffffffffffffttfffff")) {
			System.out.println("Expected in R13 96 : PASS");
		} else {
			System.out.println("Expected in R13 96 : FAIL");
		}
		System.out.println();
		
		Computer test5 = new Computer(); // or
		String[] testInstructions5 = new String[] { "move R4 75", "move R8 21", "or R4 R8 R6", "interr 0", "halt" };
		test5.preload(Assembler.assemble(testInstructions5));
		System.out.println("----ASSEMBLER TEST 5----");
		test5.run();
		Longword[] testRegs5 = test5.getRegisters();
		if (testRegs5[6].toString().equals("ffffffffffffffffffffffffftfttttt")) {
			System.out.println("Expected in R6 95 : PASS");
		} else {
			System.out.println("Expected in R6 95 : FAIL");
		}
		System.out.println();
		
		Computer test6 = new Computer(); // xor
		String[] testInstructions6 = new String[] { "move R1 120", "move R7 66", "xor R1 R7 R13", "interr 0", "halt" };
		test6.preload(Assembler.assemble(testInstructions6));
		System.out.println("----ASSEMBLER TEST 6----");
		test6.run();
		Longword[] testRegs6 = test6.getRegisters();
		if (testRegs6[13].toString().equals("fffffffffffffffffffffffffftttftf")) {
			System.out.println("Expected in R13 58 : PASS");
		} else {
			System.out.println("Expected in R13 58 : FAIL");
		}
		System.out.println();

		Computer test7 = new Computer(); // not
		String[] testInstructions7 = new String[] { "move R5 88", "not R5 R0 R3", "interr 0", "halt" };
		test7.preload(Assembler.assemble(testInstructions7));
		System.out.println("----ASSEMBLER TEST 7----");
		test7.run();
		Longword[] testRegs7 = test7.getRegisters();
		if (testRegs7[3].toString().equals("tttttttttttttttttttttttttftffttt")) {
			System.out.println("Expected in R3 4294967207 : PASS");
		} else {
			System.out.println("Expected in R3 4294967207 : FAIL");
		}
		System.out.println();
		
		Computer test8 = new Computer(); // lshift
		String[] testInstructions8 = new String[] { "move R5 45", "move R10 5", "lshift R5 R10 R15", "interr 0", "halt" };
		test8.preload(Assembler.assemble(testInstructions8));
		System.out.println("----ASSEMBLER TEST 8----");
		test8.run();
		Longword[] testRegs8 = test8.getRegisters();
		if (testRegs8[15].toString().equals("ffffffffffffffffffffftfttftfffff")) {
			System.out.println("Expected in R13 1440 : PASS");
		} else {
			System.out.println("Expected in R13 1440 : FAIL");
		}
		System.out.println();
		
		
		Computer test9 = new Computer(); // rshift
		String[] testInstructions9 = new String[] { "move R4 127", "move R9 3", "rshift R4 R9 R14", "interr 0", "halt" };
		test9.preload(Assembler.assemble(testInstructions9));
		System.out.println("----ASSEMBLER TEST 9----");
		test9.run();
		Longword[] testRegs9 = test9.getRegisters();
		if (testRegs9[14].toString().equals("fffffffffffffffffffffffffffftttt")) {
			System.out.println("Expected in R13 15 : PASS");
		} else {
			System.out.println("Expected in R13 15 : FAIL");
		}
		System.out.println();
		
	}
}
