public class Multiplier_test {
	public static void main(String args[]) {
		Bit_test.runTests();
		System.out.println();
		Longword_test.runTests();
		System.out.println();
		RippleAdder_test.runTests();
		System.out.println();
		runTests();
	}

	public static void runTests() {
		testMultiply();
	}

	public static void testMultiply() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();
		test1.set(5);
		test2.set(5);
		Longword result1 = Multiplier.multiply(test1, test2); // 25
		if (result1.getSigned() == 25) {
			System.out.println("Multiply binary 5 by 5, Expected 25 : PASS");
		} else {
			System.out.println("Multiply binary 5 by 5, Expected 25 : FAIL");
		}

		Longword test3 = new Longword();
		Longword test4 = new Longword();
		test3.set(321);
		test4.set(36);
		Longword result2 = Multiplier.multiply(test3, test4); // 11556
		if (result2.getSigned() == 11556) {
			System.out.println("Multiply binary 321 by 36, Expected 11556 : PASS");
		} else {
			System.out.println("Multiply binary 321 by 36, Expected 11556 : FAIL");
		}

		Longword test5 = new Longword();
		Longword test6 = new Longword();
		test5.set(54321);
		test6.set(8789);
		Longword result3 = Multiplier.multiply(test5, test6); // 477427269
		if (result3.getSigned() == 477427269) {
			System.out.println("Multiply binary 54321 by 8789, Expected 477427269 : PASS");
		} else {
			System.out.println("Multiply binary 54321 by 38789, Expected 477427269 : FAIL");
		}
	}
}
