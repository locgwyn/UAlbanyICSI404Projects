public class Memory_test {
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
		runTests();
	}

	public static void runTests() {
		testMemory();
	}

	// NEEDS TO BE REWRITTEN TO REFLECT THE NEW LOGIC OF MEMORY USING LONGWORDS
	// NEEDS TO BE REWRITTEN TO REFLECT THE NEW LOGIC OF MEMORY USING LONGWORDS
	// NEEDS TO BE REWRITTEN TO REFLECT THE NEW LOGIC OF MEMORY USING LONGWORDS
	// NEEDS TO BE REWRITTEN TO REFLECT THE NEW LOGIC OF MEMORY USING LONGWORDS

	public static void testMemory() {
		Memory test1 = new Memory();
		Longword testData1 = new Longword();
		Longword testAddress1 = new Longword();
		String data1 = "fffffffffffffffffffffffftftfftft";
		testData1.set(165); // 10100101 or fffffffffffffffffffffffftftfftft
		testAddress1.set(1); // Address 1

		test1.write(testAddress1, testData1);
		if (test1.read(testAddress1).toString().equals(data1)) {
			System.out.println("Write binary 165 (tftfftft) to memory address 1, Expected read " + data1 + " : PASS");
		} else {
			System.out.println("Write binary 165 (tftfftft) to memory address 1, Expected read " + data1 + " : FAIL");
		}

		Memory test2 = new Memory();
		Longword testData2 = new Longword();
		Longword testAddress2 = new Longword();
		String data2 = "fffffffffffffffffffffffftffftttf";
		testData2.set(142); // 10001110 or fffffffffffffffffffffffftffftttf
		testAddress2.set(1023);

		test2.write(testAddress2, testData2);
		if (test2.read(testAddress2).toString().equals(data2)) {
			System.out
					.println("Write binary 142 (tffftttf) to memory address 1023, Expected read " + data2 + " : PASS");
		} else {
			System.out
					.println("Write binary 142 (tffftttf) to memory address 1023, Expected read " + data2 + " : FAIL");
		}

		Memory test3 = new Memory();
		Longword testData3 = new Longword();
		Longword testAddress3 = new Longword();
		String data3 = "ffffffffffffffffffffffffftftfttt";
		testData3.set(87); // 01010111 or ffffffffffffffffffffffffftftfttt
		testAddress3.set(591);

		test3.write(testAddress3, testData3);
		if (test3.read(testAddress3).toString().equals(data3)) {
			System.out.println("Write binary 87 (ftftfttt) to memory address 591, Expected read " + data3 + " : PASS");
		} else {
			System.out.println("Write binary 87 (ftftfttt) to memory address 591, Expected read " + data3 + " : FAIL");
		}

		Memory test4 = new Memory();
		Longword testData4 = new Longword();
		Longword testAddress4 = new Longword();
		String data4 = "fffffffffffffffffffffffffffttfft";
		testData4.set(25); // 00011001 or fffffffffffffffffffffffffffttfft
		testAddress4.set(0);

		test4.write(testAddress4, testData4);
		if (test4.read(testAddress4).toString().equals(data4)) {
			System.out.println("Write binary 25 (fffttfft) to memory address 0, Expected read " + data4 + " : PASS");
		} else {
			System.out.println("Write binary 25 (fffttfft) to memory address 0, Expected read " + data4 + " : FAIL");
		}

		Memory test5 = new Memory();
		Longword testData5 = new Longword();
		Longword testData6 = new Longword();
		Longword testAddress5 = new Longword();
		Longword testAddress6 = new Longword();
		String data5 = "tfftfttftfttftfffftttttttffffttt"; // Result after two writes
		testData5.set(1234567); // 100101101011010000111 or ffffffffffftfftfttftfttftffffttt
		testData6.set(9876543); // 100101101011010000111111 or fffffffftfftfttftfttftfffftttttt
		testAddress5.set(6);
		testAddress6.set(5);

		test5.write(testAddress5, testData5);
		test5.write(testAddress6, testData6);
		if (test5.read(testAddress5).toString().equals(data5)) {
			System.out.println("Write binary 1234567 into memory address 6 and also write binary 9876543 to"
					+ " memory address 5, Expected read at address 6 " + data5 + " : PASS");
		} else {
			System.out.println("Write binary 1234567 into memory address 6 and also write binary 9876543 to"
					+ " memory address 5, Expected read at address 6 " + data5 + " : FAIL");
		}

	}
}
