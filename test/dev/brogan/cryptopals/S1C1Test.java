package dev.brogan.cryptopals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S1C1Test {
	private static final String BASE64 = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
	private static final String HEX = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";

	@Test
	void convertsHexToBase64() {
		assertEquals(BASE64, S1C1.convertHexToBase64(HEX));
	}
}
