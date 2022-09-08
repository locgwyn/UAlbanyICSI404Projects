public class RippleAdder {

	public static Longword add(Longword a, Longword b) {
		Longword result = new Longword();
		boolean carry = false;
		for (int x = 31; x >= 0; x--) {
			if (carry == true) {
				if (a.getBit(x).and(b.getBit(x)).getValue() == true) {
					result.setBit(x, new Bit(true));
					carry = true;
				} else if (a.getBit(x).or(b.getBit(x)).getValue() == true) {
					result.setBit(x, new Bit(false));
					carry = true;
				} else {
					result.setBit(x, new Bit(true));
					carry = false;
				}
			} else {
				if (a.getBit(x).and(b.getBit(x)).getValue() == true) {
					result.setBit(x, new Bit(false));
					carry = true;
				} else if (a.getBit(x).or(b.getBit(x)).getValue() == true) {
					result.setBit(x, new Bit(true));
					carry = false;
				} else {
					result.setBit(x, new Bit(false));
					carry = false;
				}
			}
		}
		return result;
	}

	public static Longword subtract(Longword a, Longword b) {
		Longword result = new Longword();

		return result;
	}
}
