
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
		if(result1.getSigned() == 25) {
			System.out.println("Multiply binary 5 by 5, Expected 25 : PASS");
		}
		else {
			System.out.println("Multiply binary 5 by 5, Expected 25 : FAIL");
		}
	}
}
