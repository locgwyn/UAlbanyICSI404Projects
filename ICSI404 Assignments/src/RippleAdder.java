public class RippleAdder {

	/*
	 * USE XOR FOR THE RIPPLE ADDER (tt = f, ff = f, tf = t, ft = t) Should only
	 * really use 1 if statement
	 */
	public static Longword add(Longword a, Longword b) {
		Longword result = new Longword();
		for (int x = 31; x >= 0; x--) {
			Bit carry = new Bit(false);
			Bit sum = new Bit(false);
			sum = a.getBit(x).xor(b.getBit(x)).xor(carry);
			carry = a.getBit(x).and(b.getBit(x)).or((a.getBit(x).xor(b.getBit(x))).and(carry));
			result.setBit(x, sum);
		}
		return result;
	}

	public static Longword subtract(Longword a, Longword b) {
		Longword result = new Longword();
		// Get two's complement of b, since subtracting is just adding the negation of a number
		Longword bComplement = b.getTwosComplement();
		for (int x = 31; x >= 0; x--) {
			Bit carry = new Bit(false);
			Bit sum = new Bit(false);
			sum = a.getBit(x).xor(bComplement.getBit(x)).xor(carry);
			carry = a.getBit(x).and(bComplement.getBit(x)).or((a.getBit(x).xor(bComplement.getBit(x))).and(carry));
			result.setBit(x, sum);
		}
		return result;
	}
}
