public class Bit implements BitInterface {

	// Note: Purpose of methods stated in BitInterface.java

	private boolean bitRep; // boolean representation of the bit

	public Bit(boolean value) {
		bitRep = value;
	}

	public void setBit(boolean value) {
		bitRep = value;
	}

	public void toggle() {
		if (bitRep == true)
			bitRep = false;
		else if (bitRep == false)
			bitRep = true;
	}

	public void set() {
		bitRep = true;

	}

	public void clear() {
		bitRep = false;

	}

	public boolean getValue() {
		return bitRep;
	}

	public Bit and(Bit otherBit) {
		// new bit to be returned is initialized to false
		Bit newBit = new Bit(false);

		// If both bits are true, set new bit to true. Otherwise no change.
		if (bitRep == true) {
			if (otherBit.getValue() == true) {
				newBit.set();
			}
		}
		return newBit;
	}

	public Bit or(Bit otherBit) {
		// new bit to be returned is initialized to false
		Bit newBit = new Bit(false);

		// If either bit is true, set new bit to true. Otherwise no change.
		if (bitRep == true) {
			newBit.set();
		} else if (otherBit.getValue() == true) {
			newBit.set();
		}
		return newBit;
	}

	public Bit xor(Bit otherBit) {
		// new bit to be returned is initialized to false
		Bit newBit = new Bit(false);

		// If only one bit is true, set new bit to true. Otherwise no change.
		if (bitRep == true) {
			if (otherBit.getValue() == false) {
				newBit.set();
			}
		} else if (bitRep == false) {
			if (otherBit.getValue() == true) {
				newBit.set();
			}
		}
		return newBit;
	}

	public Bit not() {
		// new bit to be returned is initialized to false
		Bit newBit = new Bit(false);

		// If bit is false, set new bit to true. Otherwise no change.
		if (bitRep == false) {
			newBit.set();
		}
		return newBit;
	}

	@Override
	public String toString() {
		if (bitRep == true)
			return "t";
		else
			return "f";
	}
}
