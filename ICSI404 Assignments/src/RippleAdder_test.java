public class RippleAdder_test {
	public static void main(String args[]) {
		runTests();
	}

	public static void runTests() {
		testAdd();
		testSubtract();
	}

	public static void testAdd() {
		Longword test1 = new Longword();
		Longword test2 = new Longword();
		test1.set(5);
		test2.set(10);
		Longword result1 = RippleAdder.add(test1, test2); // 15
		if (result1.getSigned() == 15) {
			System.out.println("Add binary 5 and 10 together, Expected 15 : PASS");
		} else {
			System.out.println("Add binary 5 and 10 together, Expected 15 : FAIL");
		}

		Longword test3 = new Longword();
		Longword test4 = new Longword();
		test3.set(123455);
		test4.set(678991);
		Longword result2 = RippleAdder.add(test3, test4); // 802446
		if (result2.getSigned() == 802446) {
			System.out.println("Add binary 123455 and 678991 together, Expected 802446 : PASS");
		} else {
			System.out.println("Add binary 123455 and 678991 together, Expected 802446 : FAIL");
		}

		Longword test5 = new Longword();
		Longword test6 = new Longword();
		test5.set(123);
		test6.set(-73);
		Longword result3 = RippleAdder.add(test5, test6); // 50
		if (result3.getSigned() == 50) {
			System.out.println("Add binary 123 and -73 together, Expected 50 : PASS");
		} else {
			System.out.println("Add binary 123 and -73 together, Expected 50 : FAIL");
		}
		
		Longword test7 = new Longword();
		Longword test8 = new Longword();
		test7.set(27);
		test8.set(-92);
		Longword result4 = RippleAdder.add(test7, test8); // -65
		if (result4.getSigned() == -65) {
			System.out.println("Add binary 27 and -92 together, Expected -65 : PASS");
		} else {
			System.out.println("Add binary 27 and -92 together, Expected -65 : FAIL");
		}
		
		Longword test9 = new Longword();
		Longword test10 = new Longword();
		test9.set(-9);
		test10.set(-31);
		Longword result5 = RippleAdder.add(test9, test10); // -40
		if (result5.getSigned() == -40) {
			System.out.println("Add binary -9 and -31 together, Expected -40 : PASS");
		} else {
			System.out.println("Add binary -9 and -31 together, Expected -40 : FAIL");
		}
		
		Longword test11 = new Longword();
		Longword test12 = new Longword();
		test11.set(-54321);
		test12.set(-67890);
		Longword result6 = RippleAdder.add(test11, test12); // -122211
		if (result6.getSigned() == -122211) {
			System.out.println("Add binary -54321 and -67890 together, Expected -122211 : PASS");
		} else {
			System.out.println("Add binary -54321 and -67890 together, Expected -122211 : FAIL");
		}
	}

	public static void testSubtract() {

	}
}
