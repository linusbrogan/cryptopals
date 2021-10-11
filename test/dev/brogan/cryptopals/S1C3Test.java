package dev.brogan.cryptopals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S1C3Test {
	private static final String CIPHERTEXT = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
	private static final String ENGLISH = "The quick brown fox";
	private static final String NOT_ENGLISH = "Abcd efqqq zzzz";

	@Test
	void decrypts() {
		String plaintext = S1C3.decrypt(CIPHERTEXT);
		for (int b = 0; b <= 256; b++) {
			byte[] candidate = S1C3.decrypt(S1C1.convertHexToBytes(CIPHERTEXT), (byte) b);
			assertTrue(S1C3.rank(plaintext) >= S1C3.rank(candidate));
		}
	}

	@Test
	void xorsWithSingleByte () {
		byte key = 42;
		byte[] plaintext = {4, 9, 27, -42};
		byte[] ciphertext = {46, 35, 49, -4};
		assertArrayEquals(ciphertext, S1C3.singleByteXor(plaintext, key));
	}

	@Test
	void findsKey() {
		byte key = 42;
		byte[] ciphertext = S1C3.singleByteXor(S1C3.convertTextToBytes(ENGLISH), key);
		assertEquals(key, S1C3.findKey(ciphertext));
	}

	@Test
	void convertsTextToBytes() {
		byte[] bytes = {'A', 'b', 'c', 'd', ' ', 'e', 'f', 'q', 'q', 'q', ' ', 'z', 'z', 'z', 'z'};
		assertArrayEquals(bytes, S1C3.convertTextToBytes(NOT_ENGLISH));
	}

	@Test
	void ranks() {
		assertTrue(S1C3.rank(ENGLISH) > S1C3.rank(NOT_ENGLISH));
	}
}