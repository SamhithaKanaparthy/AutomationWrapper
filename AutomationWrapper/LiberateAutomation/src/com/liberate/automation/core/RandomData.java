package com.liberate.automation.core;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/***
 * Class to create Random Data for Test.
 * 
 * 
 *
 */
public class RandomData {
	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String digits = "0123456789";
	public static final String lower = upper.toLowerCase(Locale.ROOT);
	public static final String alphanum = upper + lower + digits;
	private final Random random;
	private final char[] symbols;
	private final char[] buf;

	/**
	 * Generate a random string.
	 */
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

	private RandomData(int length, Random random, String symbols) {
		if (length < 1)
			throw new IllegalArgumentException();
		if (symbols.length() < 2)
			throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
	}

	/**
	 * Create an alphanumeric string generator.
	 */
	private RandomData(int length, Random random) {
		this(length, random, alphanum);
	}

	/**
	 * Create an alphanumeric strings from a secure generator.
	 */
	private RandomData(int length) {
		this(length, new SecureRandom());
	}

	/**
	 * Create session identifiers.
	 */
	public RandomData() {
		this(21);
	}

}