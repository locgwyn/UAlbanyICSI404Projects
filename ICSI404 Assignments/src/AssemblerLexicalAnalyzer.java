
public class AssemblerLexicalAnalyzer {

	// Character Classes
	final static int LETTER = 0;
	final static int NUMBER = 1;

	// Token Codes
	final static int NUMBER_LITERAL = 10;
	final static int REGISTER = 11;
	final static int KEYWORD = 12;
	final static int EOF = -1;

	// Global Variables
	static int charClass;
	static char lexeme[] = new char[100];
	static char nextChar;
	static int lexLen;
	static int token;
	static int nextToken;

	// Variables to keep track of current text being processed
	static String currentText;
	static int textIndex;
	static int textLength;

	public static int lexAnalyzer(String text) {
		textIndex = 0;
		textLength = text.length();
		currentText = text;
		getChar();
		lex();
		System.out.println("TEST for Lexeme: " + new String(lexeme));
		return nextToken;
	}

	public static int lex() {
		lexLen = 0;
		getNonBlank();
		switch (charClass) {

		// Parse keywords and registers

		case LETTER:
			addChar();
			getChar();
			if (charClass == LETTER) {
				addChar();
				getChar();
				while (charClass == LETTER) {
					addChar();
					getChar();
				}
				nextToken = KEYWORD;
				break;
			} else if (charClass == NUMBER) {
				addChar();
				getChar();
				while (charClass == NUMBER) {
					addChar();
					getChar();
				}
				nextToken = REGISTER;
				break;
			}

			// Parse numbers
		case NUMBER:
			addChar();
			getChar();
			while (charClass == NUMBER) {
				addChar();
				getChar();
			}
			nextToken = NUMBER;
			break;
		}
		return nextToken;
	}

	public static void addChar() {
		if (lexLen <= 98) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = 0;
		} else
			System.out.println("Error = Lexeme is too long");
	}

	public static void getChar() {

		// Gets the next character in the text until there are no more characters, then
		// return EOF
		if (textIndex < textLength) {
			nextChar = currentText.charAt(textIndex);
			if (Character.isAlphabetic(nextChar) == true) {
				charClass = LETTER;
			} else if (Character.isDigit(nextChar) == true) {
				charClass = NUMBER;
			}
			textIndex++;
		} else {
			charClass = EOF;
		}
	}

	public static void getNonBlank() {
		if (nextChar == ' ') {
			getChar();
		}
	}
}
