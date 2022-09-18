
public class ALU {
	public static Longword doOp(Bit[] operation, Longword a, Longword b) {
		Longword result = new Longword();

		// AND
		if (operation[0].getValue() == true && operation[1].getValue() == false && operation[2].getValue() == false
				&& operation[3].getValue() == false) {
			result.copy(a.and(b));
		}

		// OR
		if (operation[0].getValue() == true && operation[1].getValue() == false && operation[2].getValue() == false
				&& operation[3].getValue() == true) {
			result.copy(a.or(b));
		}

		// XOR
		if (operation[0].getValue() == true && operation[1].getValue() == false && operation[2].getValue() == true
				&& operation[3].getValue() == false) {
			result.copy(a.xor(b));
		}

		// NOT (a)
		if (operation[0].getValue() == true && operation[1].getValue() == false && operation[2].getValue() == true
				&& operation[3].getValue() == true) {
			result.copy(a.not());
		}

		// LEFT SHIFT
		if (operation[0].getValue() == true && operation[1].getValue() == true && operation[2].getValue() == false
				&& operation[3].getValue() == false) {
			Longword temp = new Longword();
			// ignores all but the first 5 bits on longword b
			for (int x = 31; x > 26; x--) {
				temp.setBit(x, b.getBit(x));
			}
			result.copy(a.leftShift(temp.getSigned()));

		}

		// RIGHT SHIFT
		if (operation[0].getValue() == true && operation[1].getValue() == true && operation[2].getValue() == false
				&& operation[3].getValue() == true) {
			Longword temp = new Longword();
			// ignores all but the first 5 bits on longword b
			for (int x = 31; x > 26; x--) {
				temp.setBit(x, b.getBit(x));
			}
			result.copy(a.rightShift(temp.getSigned()));
		}

		// ADD
		if (operation[0].getValue() == true && operation[1].getValue() == true && operation[2].getValue() == true
				&& operation[3].getValue() == false) {
			result.copy(RippleAdder.add(a, b));
		}

		// SUBTRACT
		if (operation[0].getValue() == true && operation[1].getValue() == true && operation[2].getValue() == true
				&& operation[3].getValue() == true) {
			result.copy(RippleAdder.subtract(a, b));
		}

		// MULTIPLY
		if (operation[0].getValue() == false && operation[1].getValue() == true && operation[2].getValue() == true
				&& operation[3].getValue() == true) {
			result.copy(Multiplier.multiply(a, b));
		}

		return result;
	}
}
