public class Bit_test {

	public static void runTests() {
		testConstructors();
		testSetBit();
		testToggle();
		testSet();
		testClear();
		testAnd();
		testOr();
		testXOr();
		testNot();
		testToString();
	}

	public static void testConstructors() {
		// Retrieve the value of each test bit after construction
		// Tests getValue() at the same time
		
		// Bit is false
		Bit test1 = new Bit(false);
		if (test1.getValue() == false)
			System.out.println("Construct false bit : PASS");
		else
			System.out.println("Construct false bit : FAIL");
		
		// Bit is true
		Bit test2 = new Bit(true);
		if (test2.getValue() == true)
			System.out.println("Construct true bit : PASS");
		else
			System.out.println("Construct true bit : FAIL");
	}

	public static void testSetBit() {
		// Set the initial bit from false to true
		Bit test1 = new Bit(false);
		test1.setBit(true);
		if (test1.getValue() == true)
			System.out.println("Set bit to true : PASS");
		else
			System.out.println("Set bit to true : FAIL");

		// Set the initial bit from true to false
		Bit test2 = new Bit(true);
		test2.setBit(false);
		if (test2.getValue() == false)
			System.out.println("Set bit to false : PASS");
		else
			System.out.println("Set bit to false : FAIL");
	}

	public static void testToggle() {
		// Toggle bit from false to true
		Bit test1 = new Bit(false);
		test1.toggle();
		if (test1.getValue() == true)
			System.out.println("Toggle bit to true : PASS");
		else
			System.out.println("Toggle bit to true : FAIL");

		// Toggle bit from true to false
		Bit test2 = new Bit(true);
		test2.toggle();
		if (test2.getValue() == false)
			System.out.println("Toggle bit to false : PASS");
		else
			System.out.println("Toggle bit to false : FAIL");
	}

	public static void testSet() {
		// Set bit from false to true
		Bit test1 = new Bit(false);
		test1.set();
		if (test1.getValue() == true)
			System.out.println("Set bit : PASS");
		else
			System.out.println("Set bit : FAIL");
	}

	public static void testClear() {
		// Clear bit from true to false
		Bit test1 = new Bit(true);
		test1.clear();
		if (test1.getValue() == false)
			System.out.println("Clear bit : PASS");
		else
			System.out.println("Clear bit : FAIL");
	}

	public static void testAnd() {
		// false AND false should yield false
		Bit test1 = new Bit(false);
		Bit test2 = new Bit(false);
		if (test1.and(test2).getValue() == false)
			System.out.println("false AND false is false : PASS");
		else
			System.out.println("false AND false is false : FAIL");

		// false AND true should yield false
		Bit test3 = new Bit(false);
		Bit test4 = new Bit(true);
		if (test3.and(test4).getValue() == false)
			System.out.println("false AND true is false : PASS");
		else
			System.out.println("false AND true is false : FAIL");

		// true AND false should yield false
		Bit test5 = new Bit(true);
		Bit test6 = new Bit(false);
		if (test5.and(test6).getValue() == false)
			System.out.println("true AND false is false : PASS");
		else
			System.out.println("true AND false is false : FAIL");

		// true AND true should yield true
		Bit test7 = new Bit(true);
		Bit test8 = new Bit(true);
		if (test7.and(test8).getValue() == true)
			System.out.println("true AND true is true : PASS");
		else
			System.out.println("true AND true is true : FAIL");
	}

	public static void testOr() {
		// false OR false should yield false
		Bit test1 = new Bit(false);
		Bit test2 = new Bit(false);
		if (test1.or(test2).getValue() == false)
			System.out.println("false OR false is false : PASS");
		else
			System.out.println("false OR false is false : FAIL");

		// false OR true should yield true
		Bit test3 = new Bit(false);
		Bit test4 = new Bit(true);
		if (test3.or(test4).getValue() == true)
			System.out.println("false OR true is true : PASS");
		else
			System.out.println("false OR true is true : FAIL");

		// true OR false should yield true
		Bit test5 = new Bit(true);
		Bit test6 = new Bit(false);
		if (test5.or(test6).getValue() == true)
			System.out.println("true OR false is true : PASS");
		else
			System.out.println("true OR false is true : FAIL");

		// true OR true should yield true
		Bit test7 = new Bit(true);
		Bit test8 = new Bit(true);
		if (test7.or(test8).getValue() == true)
			System.out.println("true OR true is true : PASS");
		else
			System.out.println("true OR true is true : FAIL");
	}

	public static void testXOr() {
		// false XOR false should yield false
		Bit test1 = new Bit(false);
		Bit test2 = new Bit(false);
		if (test1.xor(test2).getValue() == false)
			System.out.println("false XOR false is false : PASS");
		else
			System.out.println("false XOR false is false : FAIL");

		// false XOR true should yield true
		Bit test3 = new Bit(false);
		Bit test4 = new Bit(true);
		if (test3.xor(test4).getValue() == true)
			System.out.println("false XOR true is true : PASS");
		else
			System.out.println("false XOR true is true : FAIL");

		// true XOR false should yield true
		Bit test5 = new Bit(true);
		Bit test6 = new Bit(false);
		if (test5.xor(test6).getValue() == true)
			System.out.println("true XOR false is true : PASS");
		else
			System.out.println("true XOR false is true : FAIL");

		// true XOR true should yield false
		Bit test7 = new Bit(true);
		Bit test8 = new Bit(true);
		if (test7.xor(test8).getValue() == false)
			System.out.println("true XOR true is false : PASS");
		else
			System.out.println("true XOR true is false : FAIL");
	}

	public static void testNot() {
		// NOT false should yield true
		Bit test1 = new Bit(false);
		if (test1.not().getValue() == true)
			System.out.println("NOT false is true : PASS");
		else
			System.out.println("NOT false is true : FAIL");

		// NOT true should yield false
		Bit test2 = new Bit(true);
		if (test2.not().getValue() == false)
			System.out.println("NOT true is false : PASS");
		else
			System.out.println("NOT true is false : FAIL");
	}

	public static void testToString() {
		// Print "t"
		Bit test1 = new Bit(true);
		System.out.println(test1);

		// Print "f"
		Bit test2 = new Bit(false);
		System.out.println(test2);
	}
}
