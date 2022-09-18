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
		
		Longword test7 = new Longword();
		Longword test8 = new Longword();
		test7.set(-5);
		test8.set(5);
		Longword result4 = Multiplier.multiply(test7, test8); // -25
		if (result4.getSigned() == -25) {
			System.out.println("Multiply binary -5 by 5, Expected -25 : PASS");
		} else {
			System.out.println("Multiply binary -5 by 5, Expected -25 : FAIL");
		}
		
		Longword test9 = new Longword();
		Longword test10 = new Longword();
		test9.set(-4321);
		test10.set(53);
		Longword result5 = Multiplier.multiply(test9, test10); // -229013
		if (result5.getSigned() == -229013) {
			System.out.println("Multiply binary -4321 by 53, Expected -229013 : PASS");
		} else {
			System.out.println("Multiply binary -4321 by 53, Expected -229013 : FAIL");
		}
		
		Longword test11 = new Longword();
		Longword test12 = new Longword();
		test11.set(-752304);
		test12.set(120);
		Longword result6 = Multiplier.multiply(test11, test12); // -90276480
		if (result6.getSigned() == -90276480) {
			System.out.println("Multiply binary -752304 by 120, Expected -90276480 : PASS");
		} else {
			System.out.println("Multiply binary -752304 by 120, Expected -90276480 : FAIL");
		}
		
		Longword test13 = new Longword();
		Longword test14 = new Longword();
		test13.set(-12);
		test14.set(-5);
		Longword result7 = Multiplier.multiply(test13, test14); // 60
		if (result7.getSigned() == 60) {
			System.out.println("Multiply binary -12 by -5, Expected 60 : PASS");
		} else {
			System.out.println("Multiply binary -12 by -5, Expected 60 : FAIL");
		}
		
		Longword test15 = new Longword();
		Longword test16 = new Longword();
		test15.set(-6789);
		test16.set(-72);
		Longword result8 = Multiplier.multiply(test15, test16); // 488808
		if (result8.getSigned() == 488808) {
			System.out.println("Multiply binary -6789 by -72, Expected 488808 : PASS");
		} else {
			System.out.println("Multiply binary -6789 by -72, Expected 488808 : FAIL");
		}
		
		Longword test17 = new Longword();
		Longword test18 = new Longword();
		test17.set(-345678);
		test18.set(-687);
		Longword result9 = Multiplier.multiply(test17, test18); // 237480786
		if (result9.getSigned() == 237480786) {
			System.out.println("Multiply binary -345678 by -687, Expected 237480786 : PASS");
		} else {
			System.out.println("Multiply binary -345678 by -687, Expected 237480786 : FAIL");
		}
		
		Longword test19 = new Longword();
		Longword test20 = new Longword();
		test19.set(23478);
		test20.set(-96);
		Longword result10 = Multiplier.multiply(test19, test20); // -2253888
		if (result10.getSigned() == -2253888) {
			System.out.println("Multiply binary 23478 by -96, Expected -2253888 : PASS");
		} else {
			System.out.println("Multiply binary 23478 by -96, Expected -2253888 : FAIL");
		}
		
		Longword test21 = new Longword();
		Longword test22 = new Longword();
		test21.set(5671239);
		test22.set(-109);
		Longword result11 = Multiplier.multiply(test21, test22); // -618165051
		if (result11.getSigned() == -618165051) {
			System.out.println("Multiply binary 5671239 by -109, Expected -618165051 : PASS");
		} else {
			System.out.println("Multiply binary 5671239 by -109, Expected -618165051 : FAIL");
		}
	}
}
