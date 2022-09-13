
public class Multiplier {
	public static Longword multiply(Longword a, Longword b) {
		Longword result = new Longword();
		int shiftAmt = 0;

		// Iterate through Longword b, if Bit at index is true, 
		// left shift a by 31 - index and then add result
		for (int x = 31; x >= 0; x--) {
			if (b.getBit(x).getValue() == true) {
				shiftAmt = 31 - x;
				result.copy(RippleAdder.add(result, a.leftShift(shiftAmt)));
			}
		}
		return result;
	}
}
