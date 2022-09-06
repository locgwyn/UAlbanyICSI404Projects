public class Longword {

	Bit[] lword; // Array of bits representing the longword

	public Longword() {
		lword = new Bit[32];

		// Fill the array with bits set to false
		for (int x = 0; x < lword.length; x++) {
			lword[x] = new Bit(false);
		}
	}

	public Bit getBit(int i) {
		if (i >= lword.length || i < 0)
			throw new IndexOutOfBoundsException("Index is not valid!");
		else
			return lword[i];
	}

	public void setBit(int i, Bit value) {
		if (i >= lword.length || i < 0)
			throw new IndexOutOfBoundsException("Index is not valid!");
		else
			lword[i] = value;

	}

	public Longword and(Longword other) {
		Longword newLWord = new Longword();
		Bit newBit;
		// Read the longword from right to left
		for (int x = 31; x >= 0; x--) {
			// Get the value of the result of and
			if (lword[x].and(other.getBit(x)).getValue() == true) {
				newBit = new Bit(true);
				newLWord.setBit(x, newBit);
			} else {
				newBit = new Bit(false);
				newLWord.setBit(x, newBit);
			}
		}
		return newLWord;
	}

	public Longword or(Longword other) {
		Longword newLWord = new Longword();
		Bit newBit;
		// Read the longword from right to left
		for (int x = 31; x >= 0; x--) {
			// Get the value of the result of or
			if (lword[x].or(other.getBit(x)).getValue() == true) {
				newBit = new Bit(true);
				newLWord.setBit(x, newBit);
			} else {
				newBit = new Bit(false);
				newLWord.setBit(x, newBit);
			}
		}
		return newLWord;
	}

	public Longword xor(Longword other) {
		Longword newLWord = new Longword();
		Bit newBit;
		// Read the longwords from right to left
		for (int x = 31; x >= 0; x--) {
			// Get the value of the result of xor
			if (lword[x].xor(other.getBit(x)).getValue() == true) {
				newBit = new Bit(true);
				newLWord.setBit(x, newBit);
			} else {
				newBit = new Bit(false);
				newLWord.setBit(x, newBit);
			}
		}
		return newLWord;
	}

	public Longword not() {
		Longword newLWord = new Longword();
		// Read the longword from right to left
		for (int x = 31; x >= 0; x--) {
			newLWord.setBit(x, lword[x].not());
		}
		return newLWord;
	}

	public Longword rightShift(int amount) {
		if (amount > 32) {
			throw new IndexOutOfBoundsException("Amount is not valid!");
		}
		Longword newLWord = new Longword();
		// Copy bit from this lword at index x - amount to newLWord at index x, simulates a "rightshift"
		for (int x = 31; x >= amount; x--) {
			newLWord.setBit(x, lword[x - amount]);
		}
		// Clear the bits from index y to amount, represents "empty" bits after shifting
		for (int y = 0; y < amount; y++) {
			Bit tempBit = new Bit(false);
			newLWord.setBit(y, tempBit);
		}
		return newLWord;
	}

	public Longword leftShift(int amount) {
		if (amount > 32) {
			throw new IndexOutOfBoundsException("Amount is not valid!");
		}
		Longword newLWord = new Longword();
		// Copy bit from this lword at index x + amount to newLWord at index x, simulates a "leftshift" 
		for (int x = 0; x < lword.length - amount; x++) {
			newLWord.setBit(x, lword[x + amount]);
		}
		// Clear the bits from index y to the length of lword - amount, represents "empty" bits after shifting
		for (int y = 31; y >= lword.length - amount; y--) {
			Bit tempBit = new Bit(false);
			newLWord.setBit(y, tempBit);
		}
		return newLWord;
	}

	public long getUnsigned() {
		long newLong = 0;
		int pow = 0; // the amount of times we multiply
		int base = 2; // base to multiply
		int result = 1;

		// Read from right to left
		for (int x = 31; x >= 0; x--) {
			result = 1;
			if (lword[x].getValue() == true) {
				if (pow == 0) { // adds 1 to the long if pow at 0
					newLong += result;
					pow++;
				} else {
					for (int y = 1; y <= pow; y++) { // multiply the result by the base pow times
						result *= base;
					}
					newLong += result; // adds result of base multiplication to newLong
					pow++;
				}
			} else { // bit is not true, just increase the pow
				pow++;
			}
		}
		return newLong;
	}

	public int getSigned() {
		int newInt = 0;
		int pow = 0; // the amount of times we multiply
		int base = 2; // base to multiply
		int result = 1;
		Longword tempLWord = new Longword();

		// If signed bit is negative (1/t), do reverse 2's complement
		if (lword[0].getValue() == true) {
			for (int x = 31; x >= 0; x--) {
				tempLWord.setBit(x, lword[x]);
			}
			// Subtract 1 from longword, carrying over if necessary
			for (int y = 31; y >= 0; y--) {
				if (tempLWord.getBit(y).getValue() == true) { // No carryover, break from loop
					tempLWord.setBit(y, tempLWord.getBit(y).not());
					break;
				} else { // Carryover
					tempLWord.setBit(y, tempLWord.getBit(y).not());
				}
			}
			// Inverse the longword
			for (int i = 31; i >= 0; i--) {
				tempLWord.setBit(i, tempLWord.getBit(i).not());
			}

			// After getting the reverse 2's complement, multiply by base 2
			for (int j = 31; j >= 0; j--) {
				result = 1;
				if (tempLWord.getBit(j).getValue() == true) {
					if (pow == 0) {
						newInt += result;
						pow++;
						continue;
					} else {
						for (int k = 1; k <= pow; k++) {
							result *= base;
						}
						newInt += result;
						pow++;
						continue;
					}
				}
				pow++;
			}
			newInt *= -1;

			// If signed bit is positive (0/f), just multiply by base 2
		} else {
			for (int z = 31; z >= 0; z--) {
				result = 1;
				if (lword[z].getValue() == true) {
					if (pow == 0) {
						newInt += result;
						pow++;
					} else {
						for (int i = 1; i <= pow; i++) {
							result *= base;
						}
						newInt += result;
						pow++;
					}
				} else {
					pow++;
				}
			}
		}
		return newInt;
	}

	public void copy(Longword other) { // copy from other into this
		for (int x = 31; x >= 0; x--) {
			lword[x] = other.getBit(x);
		}
	}

	public void set(int value) {
		// CAN be signed and unsigned
		// Assume that the value is signed
		int tempVal;

		if (value < 0) {
			tempVal = value * (-1);
		} else {
			tempVal = value;
		}

		// Clear this longword
		for (int x = 31; x >= 0; x--) {
			lword[x].clear();
		}

		int index = 31;
		// Only set the bit when there is a remainder
		while (tempVal > 0) {
			if (tempVal % 2 == 1) {
				lword[index].set();
			}
			index--;
			tempVal /= 2;
		}

		// If value was negative, do 2's complement to get negative binary
		if (value < 0) {
			for (int y = 31; y >= 0; y--) {
				lword[y] = lword[y].not();
			}
			// Add 1 to longword
			for (int z = 31; z >= -1; z--) {
				if (z == -1) { // Case where longword is all 1's/t's, add extra 1/t to beginning
					lword[31].set();
					break;
				} else if (lword[z].getValue() == false) { // No carry over, break from loop
					lword[z] = lword[z].not();
					break;
				} else { // Carry over
					lword[z] = lword[z].not();
				}
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < lword.length; x++) {
			s += lword[x].toString();
		}
		return s;
	}
}
