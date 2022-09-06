public class Longword_test {

	public static void main(String args[]) {
		runTests();
		System.out.println();
		Bit_test.runTests();
	}

	public static void runTests() {
		testGetUnsigned();
		testGetSigned();
		testCopy();
		testSet();
		testGetBit();
		testSetBit();
		testAnd();
		testOr();
		testXOr();
		testNot();
		testLeftShift();
		testRightShift();
	}

	public static void testGetUnsigned() {
		Longword test1 = new Longword();
		Bit temp1 = new Bit(true);
		Bit temp2 = new Bit(true);

		test1.setBit(29, temp1);
		test1.setBit(25, temp2);
		if (test1.getUnsigned() == 68) {
			System.out.println("Get unsigned value of " + test1 + ", Expected 68 : PASS");
		} else {
			System.out.println("Get unsigned value of " + test1 + ", Expected 68 : FAIL");
		}

		Longword test2 = new Longword();
		Bit temp3 = new Bit(true);
		Bit temp4 = new Bit(true);

		test2.setBit(17, temp3);
		test2.setBit(14, temp4);
		if (test2.getUnsigned() == 147456) {
			System.out.println("Get unsigned value of " + test2 + ", Expected 147456 : PASS");
		} else {
			System.out.println("Get unsigned value of " + test2 + ", Expected 147456 : FAIL");
		}

	}

	public static void testSet() {
		Longword test1 = new Longword();
		test1.set(13);
		int temp1 = test1.getSigned();
		if (temp1 == 13) {
			System.out.println("Set value to 13, Expected 13 : PASS");
		} else {
			System.out.println("Set value to 13, Expected 13 : FAIL");
		}

		Longword test2 = new Longword();
		test2.set(1234567899);
		int temp2 = test2.getSigned();
		if (temp2 == 1234567899) {
			System.out.println("Set value to 1234567899, Expected 1234567899 : PASS");
		} else {
			System.out.println("Set value to 1234567899, Expected 1234567899 : FAIL");
		}

		Longword test3 = new Longword();
		test3.set(-20);
		int temp3 = test3.getSigned();
		if (temp3 == -20) {
			System.out.println("Set value to -20, Expected -20 : PASS");
		} else {
			System.out.println("Set value to -20, Expected -20 : FAIL");
		}

		Longword test4 = new Longword();
		test4.set(-123456789);
		int temp4 = test4.getSigned();
		if (temp4 == -123456789) {
			System.out.println("Set value to -123456789, Expected -123456789 : PASS");
		} else {
			System.out.println("Set value to -123456789, Expected -123456789 : FAIL");
		}
	}

	public static void testGetSigned() {
		Longword test1 = new Longword();
		test1.set(-123456);
		int temp1 = test1.getSigned();
		if (temp1 == -123456) {
			System.out.println("Get signed value of " + test1 + ", Expected -123456 : PASS");
		} else {
			System.out.println("Get signed value of " + test1 + ", Expected -123456 : FAIL");
		}

		Longword test2 = new Longword();
		test2.set(23456789);
		int temp2 = test2.getSigned();
		if (temp2 == 23456789) {
			System.out.println("Get signed value of " + test2 + ", Expected 23456789 : PASS");
		} else {
			System.out.println("Get signed value of " + test2 + ", Expected 23456789 : PASS");
		}
	}

	public static void testCopy() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();

		test1.set(100);
		test2.set(1578);

		test1.copy(test2);
		if (test1.toString().equals(test2.toString())) {
			System.out.println("Copy binary 1578 to binary 100, Expected " + test2 + " : PASS");
		} else {
			System.out.println("Copy binary 1578 to binary 100, Expected " + test2 + " : FAIL");
		}

		Longword test3 = new Longword();
		Longword test4 = new Longword();

		test3.set(100);
		test4.set(-531);

		test3.copy(test4);
		if (test3.toString().equals(test4.toString())) {
			System.out.println("Copy binary -531 to binary 100, Expected " + test4 + " : PASS");
		} else {
			System.out.println("Copy binary -531 to binary 100, Expected " + test4 + " : FAIL");
		}
	}

	public static void testGetBit() {
		Longword test1 = new Longword();
		test1.set(11);
		if (test1.getBit(29).getValue() == false) {
			System.out.println("Get 3rd bit from binary 11, Expected false : PASS");
		} else {
			System.out.println("Get 3rd bit from binary 11, Expected false : FALSE");
		}

		Longword test2 = new Longword();
		test2.set(54321);
		if (test2.getBit(17).getValue() == true) {
			System.out.println("Get 15th bit from binary 54321, Expected true : PASS");
		} else {
			System.out.println("Get 15th bit from binary 54321, Expected true : FALSE");
		}
	}

	public static void testSetBit() {
		Longword test1 = new Longword();
		Bit tempBit1 = new Bit(true);
		test1.set(8);
		test1.setBit(31, tempBit1);
		if (test1.getBit(31).getValue() == true) {
			System.out.println("Set the first bit in binary 8 to true, Expected true : PASS");
		} else {
			System.out.println("Set the first bit in binary 8 to true, Expected true : FALSE");
		}

		Longword test2 = new Longword();
		Bit tempBit2 = new Bit(false);
		test2.set(123456);
		test2.setBit(17, tempBit1);
		if (test1.getBit(17).getValue() == false) {
			System.out.println("Set the 16th bit in binary 123456 to false, Expected false : PASS");
		} else {
			System.out.println("Set the 16th bit in binary 123456 to false, Expected false : FALSE");
		}
	}

	public static void testAnd() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();
		Longword test3;
		String result1 = "ffffffffffffffffffffffffffffffff";
		test1.set(15);
		test2.set(16);
		test3 = test1.and(test2);
		if (test3.toString().equals(result1)) {
			System.out.println("And binary 15 and binary 16, Expected " + result1 + " : PASS");
		} else {
			System.out.println("And binary 15 and binary 16, Expected " + result1 + " : FAIL");
		}

		Longword test4 = new Longword();
		Longword test5 = new Longword();
		Longword test6;
		String result2 = "fffffffffffffffffffffffffttftftf";
		test4.set(123);
		test5.set(234);
		test6 = test4.and(test5);
		if (test6.toString().equals(result2)) {
			System.out.println("AND binary 123 and binary 234, Expected " + result2 + " : PASS");
		} else {
			System.out.println("AND binary 123 and binary 234, Expected " + result2 + " : FAIL");
		}
	}

	public static void testOr() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();
		Longword test3;
		String result1 = "fffffffffffffffffffffffffffttttt";
		test1.set(15);
		test2.set(16);
		test3 = test1.or(test2);
		if (test3.toString().equals(result1)) {
			System.out.println("OR binary 15 and binary 16, Expected " + result1 + " : PASS");
		} else {
			System.out.println("OR binary 15 and binary 16, Expected " + result1 + " : FAIL");
		}

		Longword test4 = new Longword();
		Longword test5 = new Longword();
		Longword test6;
		String result2 = "fffffffffffffffffffffffftttttftt";
		test4.set(123);
		test5.set(234);
		test6 = test4.or(test5);
		if (test6.toString().equals(result2)) {
			System.out.println("OR binary 123 and binary 234, Expected " + result2 + " : PASS");
		} else {
			System.out.println("OR binary 123 and binary 234, Expected " + result2 + " : FAIL");
		}

	}

	public static void testXOr() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();
		Longword test3;
		String result1 = "fffffffffffffffffffffffffffttftt";
		test1.set(15);
		test2.set(20);
		test3 = test1.xor(test2);
		if (test3.toString().equals(result1)) {
			System.out.println("XOR binary 15 and binary 20, Expected " + result1 + " : PASS");
		} else {
			System.out.println("XOR binary 15 and binary 20, Expected " + result1 + " : FAIL");
		}

		Longword test4 = new Longword();
		Longword test5 = new Longword();
		Longword test6;
		String result2 = "fffffffffffffffffffffffttfttfftt";
		test4.set(123);
		test5.set(456);
		test6 = test4.xor(test5);
		if (test6.toString().equals(result2)) {
			System.out.println("XOR binary 123 and binary 456, Expected " + result2 + " : PASS");
		} else {
			System.out.println("OR binary 123 and binary 456, Expected " + result2 + " : FAIL");
		}

	}

	public static void testNot() {
		Longword test1 = new Longword();
		String result1 = "tttttttttttttttffffttttfftfffttf";
		test1.set(123321);
		if (test1.not().toString().equals(result1)) {
			System.out.println("NOT binary 123321, Expected " + result1 + " : PASS");
		} else {
			System.out.println("NOT binary 123321, Expected " + result1 + " : FAIL");
		}

		Longword test2 = new Longword();
		String result2 = "tfffffffffffffffffffffffffffffff";
		test2.set(2147483647);
		if (test2.not().toString().equals(result2)) {
			System.out.println("NOT binary 2147483647, Expected " + result2 + " : PASS");
		} else {
			System.out.println("NOT binary 2147483647, Expected " + result2 + " : FAIL");
		}
	}

	public static void testLeftShift() {
		Longword test1 = new Longword();
		String result1 = "fffffffffffffffffffffffttttfttff";
		test1.set(123);
		test1.copy(test1.leftShift(2));
		if (test1.toString().equals(result1)) {
			System.out.println("Left shift binary 123 by two, Expected " + result1 + " : PASS");
		} else {
			System.out.println("Left shift binary 123 by two, Expected " + result1 + " : FAIL");
		}

		Longword test2 = new Longword();
		String result2 = "fffffffffffttftftffffttffftfffff";
		test2.set(54321);
		test2.copy(test2.leftShift(5));
		if (test2.toString().equals(result2)) {
			System.out.println("Left shift binary 54331 by five, Expected " + result2 + " : PASS");
		} else {
			System.out.println("Left shift binary 54321 by five, Expected " + result2 + " : FAIL");
		}

		Longword test3 = new Longword();
		String result3 = "ttttttttttttttttttttttffffffffff";
		test3.set(2147483647);
		test3.copy(test3.leftShift(10));
		if (test3.toString().equals(result3)) {
			System.out.println("Left shift binary 2147483647 by 10, Expected " + result3 + " : PASS");
		} else {
			System.out.println("Left shift binary 2147483647 by 10, Expected " + result3 + " : FAIL");
		}
	}

	public static void testRightShift() {
		Longword test1 = new Longword();
		String result1 = "ffffffffffffffffffffffffffftffff";
		test1.set(128);
		test1.copy(test1.rightShift(3));
		if (test1.toString().equals(result1)) {
			System.out.println("Right shift binary 128 by three, Expected " + result1 + " : PASS");
		} else {
			System.out.println("Right shift binary 128 by three, Expected " + result1 + " : FAIL");
		}

		Longword test2 = new Longword();
		String result2 = "ffffffffffffffffffffffffttftftff";
		test2.set(54321);
		test2.copy(test2.rightShift(8));
		if (test2.toString().equals(result2)) {
			System.out.println("Right shift binary 54321 by 8, Expected " + result2 + " : PASS");
		} else {
			System.out.println("Right shift binary 54321 by 8, Expected " + result2 + " : FAIL");
		}

		Longword test3 = new Longword();
		String result3 = "ffffffffffffffffffffffffffffffft";
		test3.set(10);
		test3.copy(test3.rightShift(3));
		if (test3.toString().equals(result3)) {
			System.out.println("Right shift binary 10 by 3, Expected " + result3 + " : PASS");
		} else {
			System.out.println("Right shift binary 10 by 3, Expected " + result3 + " : FAIL");
		}
	}
}
