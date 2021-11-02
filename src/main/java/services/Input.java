package services;

public class Input {

	public static void parseCliInput(String[] args) throws IllegalArgumentException {
		if (args.length == 0) {
			throw new IllegalArgumentException("No arguments given");
		}
		if (!args[0].endsWith(".csv")) {
			throw new IllegalArgumentException("Input file must be CSV");
		}

	}
}
