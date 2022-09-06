public interface BitInterface {

	public void setBit(boolean value); // Sets the value of the bit

	public void toggle(); // Changes value from true to false and vice versa

	public void set(); // Sets bit to true

	public void clear(); // Sets bit to false

	public boolean getValue(); // Returns current value of the bit

	public Bit and(Bit otherBit); // Performs AND on two bits and returns a new bit set to the result

	public Bit or(Bit otherBit); // Performs OR on two bits and returns a new bit set to the result

	public Bit xor(Bit otherBit); // Performs XOR on two bits and returns a new bit set to the result

	public Bit not(); // Performs NOT on the existing bit and returns the result as a new bit

	@Override
	public String toString(); // Returns string representation of bit ("t" or "f")
}
