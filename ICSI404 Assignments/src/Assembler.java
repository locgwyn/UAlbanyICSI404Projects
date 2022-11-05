
public class Assembler {
	public static String[] assemble(String[] instructionList) {
		String[] bitPatterns = new String[instructionList.length];
		for (int x = 0; x < instructionList.length; x++) {
			String convertedInstruction = "";
			String[] tokens = instructionList[x].split("\\s+");

			// Switch statement for commands
			switch (tokens[0]) {

			case "and":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "or":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "xor":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "not":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;

			case "lshift":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;
				
			case "rshift":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;
				
			case "add":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;
				
			case "sub":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;
				
			case "mult":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertRegister(tokens[2]));
				convertedInstruction.concat(convertRegister(tokens[3]));
				break;
				
			case "halt":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat("ffffffffffff"); // any bit after halt command is ignored, so just set to false
				break;
				
			case "move":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertRegister(tokens[1]));
				convertedInstruction.concat(convertNumber(tokens[2]));
				break;
				
			case "interr":
				convertedInstruction.concat(convertKeyword(tokens[0]));
				convertedInstruction.concat(convertNumber(tokens[1]));
				break;
			}

			// Adds the converted instruction to the array of bit instructions
			bitPatterns[x] = convertedInstruction;
		}
		return bitPatterns;
	}

	public static String convertRegister(String text) {
		String register = new String();
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

		switch(text) {
		case "and":
			keyword = "tfff";
		case "or":
			keyword = "tfft";
		case "xor":
			keyword = "tftf";
		case "not":
			keyword = "tftt";
		case "lshift":
			keyword = "ttff";
		case "rshift":
			keyword = "ttft";
		case "add":
			keyword = "tttf";
		case "sub":
			keyword = "tttt";
		case "mult":
			keyword = "fttt";
		case "halt":
			keyword = "ffff";
		case "move":
			keyword = "ffft";
		case "interr":
			keyword = "fftf";
		}
		return keyword;
	}

	public static String convertNumber(String text) {
		String number = new String();
		Longword num = new Longword();
		num.set(Integer.parseInt(text));
		number = num.toString().substring(24); // Just gets the 8 bits needed for a number
		return number;
	}
}
