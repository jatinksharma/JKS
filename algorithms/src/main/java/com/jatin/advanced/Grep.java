package com.jatin.advanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Grep {

	// Charset and decoder for ISO-8859-15
	private static Charset charset = Charset.forName("ISO-8859-15");
	private static CharsetDecoder decoder = charset.newDecoder();

	// Pattern used to parse lines
	private static Pattern linePattern = Pattern.compile(".*\r?\n");

	// The input pattern that we're looking for
	private static Pattern pattern;
	
	public static void main(String[] args) {
		args = new String[2];
		args[0] = "static";
		args[1]	= "C:/Workspaces/Jackpot/jps_1_0_0/Threadss/src/com/java/concurrency/iterRecur/bigdata/RawHashmap.txt";
			
		if (args.length < 2) {
			System.err.println("Usage: java Grep pattern file...");
			return;
		}
		compile(args[0]);
		for (int i = 1; i < args.length; i++) {
			File f = new File(args[i]);
			try {
				grep(f);
			} catch (IOException x) {
				System.err.println(f + ": " + x);
			}
		}
	}

	// Compile the pattern from the command line
	private static void compile(String pat) {
		try {
			pattern = Pattern.compile(pat);
		} catch (PatternSyntaxException x) {
			System.err.println(x.getMessage());
			System.exit(1);
		}
	}

	// Use the linePattern to break the given CharBuffer into lines, applying
	// the input pattern to each line to see if we have a match
	private static void grep(File f, CharBuffer cb) {
		Matcher lineMatcher = linePattern.matcher(cb); // Line matcher
		Matcher patternMatcher = null; // Pattern matcher
		int lines = 0;
		while (lineMatcher.find()) {
			lines++;
			CharSequence cs = lineMatcher.group(); // The current line
			if (patternMatcher == null)
				patternMatcher = pattern.matcher(cs);
			else
				patternMatcher.reset(cs);
			if (patternMatcher.find())
				System.out.print(f + ":" + lines + ":" + cs);
			if (lineMatcher.end() == cb.limit())
				break;
		}
	}

	// Search for occurrences of the input pattern in the given file
	//
	private static void grep(File f) throws IOException {

		// Open the file and then get a channel from the stream
		FileInputStream fis = new FileInputStream(f);
		FileChannel fc = fis.getChannel();

		// Get the file's size and then map it into memory
		int sz = (int) fc.size();
		MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, sz);

		// Decode the file into a char buffer
		CharBuffer cb = decoder.decode(bb);
		
		System.out.println(cb.toString());

		// Perform the search
		grep(f, cb);

		// Close the channel and the stream
		fc.close();
	}

	

}