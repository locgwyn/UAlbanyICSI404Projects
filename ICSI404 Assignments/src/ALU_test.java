public class ALU_test {
	public static void main(String args[]) {
		Bit_test.runTests();
		System.out.println();
		Longword_test.runTests();
		System.out.println();
		RippleAdder_test.runTests();
		System.out.println();
		Multiplier_test.runTests();
		System.out.println();
		runTests();
	}

	public static void runTests() {
		testALU();
	}

	public static void testALU() {
		// AND
		Bit[] and = new Bit[4];
		and[0] = new Bit(true);
		and[1] = new Bit(false);
		and[2] = new Bit(false);
		and[3] = new Bit(false);

		Longword test1 = new Longword();
		Longword test2 = new Longword();
		String result1 = "fffffffffffffffffffffffffffftftf";
		test1.set(26);
		test2.set(78);
		if (ALU.doOp(and, test1, test2).toString().equals(result1)) {
			System.out.println("Do and operation on binary 26 and 78, Expected " + result1 + " : PASS");
		} else {
			System.out.println("Do and operation on binary 26 and 78, Expected " + result1 + " : FAIL");
		}

		Longword test3 = new Longword();
		Longword test4 = new Longword();
		String result2 = "ffffffffffffffffffftffffffttffft";
		test3.set(54321);
		test4.set(12345);
		if (ALU.doOp(and, test3, test4).toString().equals(result2)) {
			System.out.println("Do and operation on binary 54321 and 12345, Expected " + result2 + " : PASS");
		} else {
			System.out.println("Do and operation on binary 54321 and 12345, Expected " + result2 + " : FAIL");
		}

		// OR
		Bit[] or = new Bit[4];
		or[0] = new Bit(true);
		or[1] = new Bit(false);
		or[2] = new Bit(false);
		or[3] = new Bit(true);

		Longword test5 = new Longword();
		Longword test6 = new Longword();
		String result3 = "fffffffffffffffffffffffftfttfttt";
		test5.set(38);
		test6.set(177);
		if (ALU.doOp(or, test5, test6).toString().equals(result3)) {
			System.out.println("Do or operation on binary 38 and 177, Expected " + result3 + " : PASS");
		} else {
			System.out.println("Do or operation on binary 38 and 177, Expected " + result3 + " : FAIL");
		}

		Longword test7 = new Longword();
		Longword test8 = new Longword();
		String result4 = "ffffffffffffffftttftttftffttfftt";
		test7.set(67891);
		test8.set(54321);
		if (ALU.doOp(or, test7, test8).toString().equals(result4)) {
			System.out.println("Do or operation on binary 67891 and 54321, Expected " + result4 + " : PASS");
		} else {
			System.out.println("Do or operation on binary 67891 and 54321, Expected " + result4 + " : FAIL");
		}

		// XOR
		Bit[] xor = new Bit[4];
		xor[0] = new Bit(true);
		xor[1] = new Bit(false);
		xor[2] = new Bit(true);
		xor[3] = new Bit(false);

		Longword test9 = new Longword();
		Longword test10 = new Longword();
		String result5 = "fffffffffffffffffffffffftftfffft";
		test9.set(49);
		test10.set(144);
		if (ALU.doOp(xor, test9, test10).toString().equals(result5)) {
			System.out.println("Do xor operation on binary 49 and 144, Expected " + result5 + " : PASS");
		} else {
			System.out.println("Do xor operation on binary 49 and 144, Expected " + result5 + " : FAIL");
		}

		Longword test11 = new Longword();
		Longword test12 = new Longword();
		String result6 = "fffffffffffffffttftfttfttttttfff";
		test11.set(34567);
		test12.set(76543);
		if (ALU.doOp(xor, test11, test12).toString().equals(result6)) {
			System.out.println("Do xor operation on binary 34567 and 76543, Expected " + result6 + " : PASS");
		} else {
			System.out.println("Do xor operation on binary 34567 and 76543, Expected " + result6 + " : FAIL");
		}

		// NOT
		Bit[] not = new Bit[4];
		not[0] = new Bit(true);
		not[1] = new Bit(false);
		not[2] = new Bit(true);
		not[3] = new Bit(true);

		Longword test13 = new Longword();
		Longword test14 = new Longword();
		String result7 = "tttttttttttttttttttttttfffttfttt";
		test13.set(456);
		test14.set(1);
		if (ALU.doOp(not, test13, test14).toString().equals(result7)) {
			System.out.println("Do not operation on binary 456 and ignore 1, Expected " + result7 + " : PASS");
		} else {
			System.out.println("Do xor operation on binary 456 and ignore 1, Expected " + result7 + " : FAIL");
		}

		Longword test15 = new Longword();
		Longword test16 = new Longword();
		String result8 = "tfttftffftftttttttfftttttffttttf";
		test15.set(1268789345);
		test16.set(1);
		if (ALU.doOp(not, test15, test16).toString().equals(result8)) {
			System.out.println("Do not operation on binary 1268789345 and ignore 1, Expected " + result8 + " : PASS");
		} else {
			System.out.println("Do xor operation on binary 1268789345 and ignore 1, Expected " + result8 + " : FAIL");
		}

		// LEFT SHIFT
		Bit[] lshift = new Bit[4];
		lshift[0] = new Bit(true);
		lshift[1] = new Bit(true);
		lshift[2] = new Bit(false);
		lshift[3] = new Bit(false);

		Longword test17 = new Longword();
		Longword test18 = new Longword();
		String result9 = "fffffffffffttftftffffttffftfffff";
		test17.set(54321);
		test18.set(5);
		if (ALU.doOp(lshift, test17, test18).toString().equals(result9)) {
			System.out.println("Do left shift operation using binary 54321 and 5, Expected " + result9 + " : PASS");
		} else {
			System.out.println("Do left shift operation using binary 54321 and 5, Expected " + result9 + " : FAIL");
		}

		Longword test19 = new Longword();
		Longword test20 = new Longword();
		String result10 = "ftttffffffffffffffffffffffffffff";
		test19.set(5678);
		test20.set(123); // Will be 27 since ignoring all but lowest 5 bits
		if (ALU.doOp(lshift, test19, test20).toString().equals(result10)) {
			System.out.println("Do left shift operation using binary 5678 and 123, Expected " + result10 + " : PASS");
		} else {
			System.out.println("Do left shift operation using binary 5678 and 123, Expected " + result10 + " : FAIL");
		}

		// RIGHT SHIFT
		Bit[] rshift = new Bit[4];
		rshift[0] = new Bit(true);
		rshift[1] = new Bit(true);
		rshift[2] = new Bit(false);
		rshift[3] = new Bit(true);

		Longword test21 = new Longword();
		Longword test22 = new Longword();
		String result11 = "ffffffffffffffffffffffffffffftft";
		test21.set(45);
		test22.set(3);
		if (ALU.doOp(rshift, test21, test22).toString().equals(result11)) {
			System.out.println("Do right shift operation using binary 45 and 3, Expected " + result11 + " : PASS");
		} else {
			System.out.println("Do right shift operation using binary 45 and 3, Expected " + result11 + " : FAIL");
		}

		Longword test23 = new Longword();
		Longword test24 = new Longword();
		String result12 = "ffffffffffffffffffffffffffftfftf";
		test23.set(9876543);
		test24.set(979); // Will be 19 since ignoring all but lowest 5 bits
		if (ALU.doOp(rshift, test23, test24).toString().equals(result12)) {
			System.out.println("Do right shift operation using binary 9876543 and 979, Expected " + result12 + " : PASS");
		} else {
			System.out.println("Do right shift operation using binary 9876543 and 979, Expected " + result12 + " : FAIL");
		}

		// ADD
		Bit[] add = new Bit[4];
		add[0] = new Bit(true);
		add[1] = new Bit(true);
		add[2] = new Bit(true);
		add[3] = new Bit(false);

		Longword test25 = new Longword();
		Longword test26 = new Longword();
		test25.set(123);
		test26.set(456);
		if (ALU.doOp(add, test25, test26).getSigned() == 579) {
			System.out.println("Do add operation using binary 123 and 456, Expected 579 : PASS");
		} else {
			System.out.println("Do add operation using binary 123 and 456, Expected 579 : FAIL");
		}

		Longword test27 = new Longword();
		Longword test28 = new Longword();
		test27.set(-12367);
		test28.set(7533);
		if (ALU.doOp(add, test27, test28).getSigned() == -4834) {
			System.out.println("Do add operation using binary -12367 and 7533, Expected -4834 : PASS");
		} else {
			System.out.println("Do add operation using binary -12367 and 7533, Expected -4834 : FAIL");
		}

		// SUBTRACT
		Bit[] sub = new Bit[4];
		sub[0] = new Bit(true);
		sub[1] = new Bit(true);
		sub[2] = new Bit(true);
		sub[3] = new Bit(true);

		Longword test29 = new Longword();
		Longword test30 = new Longword();
		test29.set(5467);
		test30.set(3421);
		if (ALU.doOp(sub, test29, test30).getSigned() == 2046) {
			System.out.println("Do subtract operation using binary 5467 and 4321, Expected 2046 : PASS");
		} else {
			System.out.println("Do subtract operation using binary 5467 and 4321, Expected 2046 : FAIL");
		}

		Longword test31 = new Longword();
		Longword test32 = new Longword();
		test31.set(56789);
		test32.set(-53123);
		if (ALU.doOp(sub, test31, test32).getSigned() == 109912) {
			System.out.println("Do subtract operation using binary 56789 and -53123, Expected 109912 : PASS");
		} else {
			System.out.println("Do subtract operation using binary 56789 and -53123, Expected 109912 : FAIL");
		}

		// MULTIPLY
		Bit[] mult = new Bit[4];
		mult[0] = new Bit(false);
		mult[1] = new Bit(true);
		mult[2] = new Bit(true);
		mult[3] = new Bit(true);

		Longword test33 = new Longword();
		Longword test34 = new Longword();
		test33.set(36);
		test34.set(963);
		if (ALU.doOp(mult, test33, test34).getSigned() == 34668) {
			System.out.println("Do multiply operation using binary 36 and 963, Expected 34668 : PASS");
		} else {
			System.out.println("Do multiply operation using binary 36 and 963, Expected 34668 : FAIL");
		}

		Longword test35 = new Longword();
		Longword test36 = new Longword();
		test35.set(-8743);
		test36.set(4589);
		if (ALU.doOp(mult, test35, test36).getSigned() == -40121627) {
			System.out.println("Do multiply operation using binary -8743 and 4589, Expected -40121627 : PASS");
		} else {
			System.out.println("Do multiply operation using binary -8743 and 4589, Expected -40121627 : FAIL");
		}
	}
}