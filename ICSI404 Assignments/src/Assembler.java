
public class Assembler {
	public static String[] assemble(String[] instructionList) {
		String[] bitPatterns = new String[instructionList.length];
		for (int x = 0; x < instructionList.length; x++) {
			String convertedInstruction = ""; // Holds the current instruction represented in bits
			String[] tokens = instructionList[x].split("\\s+"); // Splits the current instruction into tokens

			// Switch statement for commands
			switch (tokens[0]) {

			// All basic operations take 4 tokens - keyword, register, register, register
			case "and":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "or":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "xor":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "not":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "lshift":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "rshift":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "add":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "sub":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "mult":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "halt":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat("ffffffffffff"); // any bit after halt command is
																					// ignored, so just set to false
				break;

				// Only takes 3 tokens - keyword, register, number
			case "move":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertNumber(tokens[2]));
				break;

				// Only takes 2 tokens - keyword, number (either 0 or 1)
			case "interr":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// pad the instruction with false bits
				convertedInstruction = convertedInstruction.concat("ffff");
				// determines either interrupt 0 or 1
				convertedInstruction = convertedInstruction.concat(convertNumber(tokens[1]));
				break;
			
				// Only takes 2 tokens - keyword, number (0 - 1023)
			case "jump":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// pad the instruction with false bits
				convertedInstruction = convertedInstruction.concat("ff");
				// converts the number into 10 bits
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
				// Only takes 3 tokens - keyword, register, register
			case "compare":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// pad the instruction with false bits
				convertedInstruction = convertedInstruction.concat("ffff");
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[2]));
				break;
				
				// All branch conditions take 2 tokens and have two bit cond codes - keyword, number (0 - 511)
				
			case "branchifequal":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// equal cond code - ft
				convertedInstruction = convertedInstruction.concat("ft");
				// converts the number into 10 bits
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
			case "branchifnotequal":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// not equal cond code - ff
				convertedInstruction = convertedInstruction.concat("ff");
				// converts the number into 10 bits
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
			case "branchifgreater":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// greater cond code - tf
				convertedInstruction = convertedInstruction.concat("tf");
				// converts the number into 10 bits
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
			case "branchifgreaterorequal":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// greaterorequal cond code - tt
				convertedInstruction = convertedInstruction.concat("tt");
				// converts the number into 10 bits
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
			case "push":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// pad instruction with false bits
				convertedInstruction = convertedInstruction.concat("ffffffff");
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				break;
				
			case "pop":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// has additional "opcode", then pad with false bits
				convertedInstruction = convertedInstruction.concat("ftffffff");
				convertedInstruction = convertedInstruction.concat(convertRegister(tokens[1]));
				break;
				
			case "call":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// has additional "opcode"
				convertedInstruction = convertedInstruction.concat("tf");
				// 10 Bit number representing an absolute address in memory
				convertedInstruction = convertedInstruction.concat(convert10BitNum(tokens[1]));
				break;
				
			case "return":
				convertedInstruction = convertedInstruction.concat(convertKeyword(tokens[0]));
				// has additional "opcode" with no variable bits, pad with false bits
				convertedInstruction = convertedInstruction.concat("ttffffffffff");
				break;
				
				// case where keyword is unrecognized, print an error and add a halt
			default:
				System.out.println("ERROR - UNKNOWN COMMAND ENCOUNTERED IN INSTRUCTION " + x + ", DEFAULT TO HALT");
				convertedInstruction = "ffffffffffffffff";
				break;
			}

			// Adds the converted instruction to the array of bit instructions
			bitPatterns[x] = convertedInstruction;
		}
		return bitPatterns;
	}

	// HELPER METHODS
	
	public static String convertRegister(String text) {
		String register = new String();
		
		// Converts the given register into its appropriate bits
		switch (text) {
		case "R0":
			register = "ffff";
			break;
		case "R1":
			register = "ffft";
			break;
		case "R2":
			register = "fftf";
			break;
		case "R3":
			register = "fftt";
			break;
		case "R4":
			register = "ftff";
			break;
		case "R5":
			register = "ftft";
			break;
		case "R6":
			register = "fttf";
			break;
		case "R7":
			register = "fttt";
			break;
		case "R8":
			register = "tfff";
			break;
		case "R9":
			register = "tfft";
			break;
		case "R10":
			register = "tftf";
			break;
		case "R11":
			register = "tftt";
			break;
		case "R12":
			register = "ttff";
			break;
		case "R13":
			register = "ttft";
			break;
		case "R14":
			register = "tttf";
			break;
		case "R15":
			register = "tttt";
			break;
		}
		return register;
	}

	public static String convertKeyword(String text) {
		String keyword = new String();
		
		// Converts the given keyword to the appropriate opcode
		switch (text) {
		case "and":
			keyword = "tfff";
			break;
		case "or":
			keyword = "tfft";
			break;
		case "xor":
			keyword = "tftf";
			break;
		case "not":
			keyword = "tftt";
			break;
		case "lshift":
			keyword = "ttff";
			break;
		case "rshift":
			keyword = "ttft";
			break;
		case "add":
			keyword = "tttf";
			break;
		case "sub":
			keyword = "tttt";
			break;
		case "mult":
			keyword = "fttt";
			break;
		case "halt":
			keyword = "ffff";
			break;
		case "move":
			keyword = "ffft";
			break;
		case "interr":
			keyword = "fftf";
			break;
		case "jump":
			keyword = "fftt";
			break;
		case "compare":
			keyword = "ftff";
			break;
		case "branchifequal":
			keyword = "ftft";
			break;
		case "branchifnotequal":
			keyword = "ftft";
			break;
		case "branchifgreater":
			keyword = "ftft";
			break;
		case "branchifgreaterorequal":
			keyword = "ftft";
			break;
		case "push":
			keyword = "fttf";
			break;
		case "pop":
			keyword = "fttf";
			break;
		case "call":
			keyword = "fttf";
			break;
		case "return":
			keyword = "fttf";
			break;
		}
		return keyword;
	}

	public static String convertNumber(String text) {
		String number = new String();
		Longword num = new Longword();
		
		// Converts given number as a string into bits
		num.set(Integer.parseInt(text));
		number = num.toString().substring(24); // Just gets the 8 bits needed for a number
		return number;
	}
	
	public static String convert10BitNum(String text) {
		String number = new String();
		Longword num = new Longword();
		
		// Converts given number as a string into bits
		num.set(Integer.parseInt(text));
		number = num.toString().substring(22); //  gets the 10 bits needed for the number
		return number;
	}
	
}
