package dev.brogan.cryptopals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S1C1Test {
	private static final String BASE64 = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
	private static final String HEX = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
	private static String HEX_CHARS = "0123456789abcdef";

	@Test
	void convertsHexToBase64() {
		assertEquals(BASE64, S1C1.convertHexToBase64(HEX));
	}

	@Test
	void convertsHexToBytes() {
		byte[] bytes = {1, 35, 69, 103, -119, -85, -51, -17};
		assertArrayEquals(bytes, S1C1.convertHexToBytes(HEX_CHARS));
		assertArrayEquals(bytes, S1C1.convertHexToBytes(HEX_CHARS.toUpperCase()));
	}

	@Test
	void convertsHexCharToByte() {
		char[] chars = HEX_CHARS.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			assertEquals(i, S1C1.hexCharToByte(chars[i]));
		}

		chars = HEX_CHARS.toUpperCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			assertEquals(i, S1C1.hexCharToByte(chars[i]));
		}
	}

	@Test
	void convertsBytesToBase64() {
		assert false;
	}
}
