public class RippleAdder {
	public static Longword add(Longword a, Longword b) {
		Longword result = new Longword();
		Bit carry = new Bit(false);
		// Follows logic from Refreshers slide 65 on Blackboard ( Sum = A xor B xor
		// CarryIn, CarryOut = A and B or ((A xor B) and CarryIn) )
		for (int x = 31; x >= 0; x--) {
			Bit sum = a.getBit(x).xor(b.getBit(x)).xor(carry);
			carry = a.getBit(x).and(b.getBit(x)).or((a.getBit(x).xor(b.getBit(x))).and(carry));
			result.setBit(x, sum);
		}
		return result;
	}

	public static Longword subtract(Longword a, Longword b) {
		Longword result = new Longword();
		Bit carry = new Bit(false);
		// Get two's complement of b, since subtracting is just adding the negation of a
		// number
		Longword bComplement = b.getTwosComplement();
		// Follows the same logic from add above
		for (int x = 31; x >= 0; x--) {
			Bit sum = a.getBit(x).xor(bComplement.getBit(x)).xor(carry);
			carry = a.getBit(x).and(bComplement.getBit(x)).or((a.getBit(x).xor(bComplement.getBit(x))).and(carry));
			result.setBit(x, sum);
		}
		return result;
	}
}
