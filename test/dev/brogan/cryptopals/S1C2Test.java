package dev.brogan.cryptopals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class S1C2Test {
	String INPUT_HEX_1 = "1c0111001f010100061a024b53535009181c";
	String INPUT_HEX_2 = "686974207468652062756c6c277320657965";
	String OUTPUT_HEX = "746865206b696420646f6e277420706c6179";

	@Test
	void xorsHex() {
		assertEquals(OUTPUT_HEX, S1C2.xor(INPUT_HEX_1, INPUT_HEX_2));
	}

	@Test
	void xorsBytes() {
		byte[] in1 = {0, 1, 3, 4, 7};
		byte[] in2 = {-1, -1, 2, -4, 12};
		byte[] out = {-1, -2, 1, -8, 11};
		assertArrayEquals(out, S1C2.xor(in1, in2));
	}

	@Test
	void convertsBytesToHex() {
		byte[] bytes = {0x00, 0x47, 0x3f, 0x1a};
		String hex = "00473f1a";
		assertEquals(hex, S1C2.convertBytesToHex(bytes));
	}
}