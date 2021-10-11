package dev.brogan.cryptopals;

import javax.naming.LimitExceededException;
import java.util.Locale;

public class S1C3 {
	// Letter frequencies of English text A-Z from <https://en.wikipedia.org/wiki/Letter_frequency>.
	private static double[] LETTER_FREQUENCIES = {
		0.082,
		0.015,
		0.028,
		0.043,
		0.13,
		0.022,
		0.02,
		0.061,
		0.07,
		0.0015,
		0.0077,
		0.04,
		0.024,
		0.067,
		0.075,
		0.019,
		0.00095,
		0.06,
		0.063,
		0.091,
		0.028,
		0.0098,
		0.024,
		0.0015,
		0.02,
		0.00074
	};

	public static String decrypt(String hex) {
		return "";
	}

	public static byte[] singleByteXor(byte[] bytes, byte key) {
		byte[] mask = new byte[bytes.length];
		for (int i = 0; i < mask.length; i++)
			mask[i] = key;
		return S1C2.xor(bytes, mask);
	}

	public static double rank(String text) {
		char[] chars = text.toLowerCase().toCharArray();
		int[] frequencies = new int[LETTER_FREQUENCIES.length];
		int totalLetters = 0;
		for (char c : chars)
			if (c >= 'a' && c <= 'z') {
				frequencies[c - 'a']++;
				totalLetters++;
			}
		double totalError = 0;
		for (int i = 0; i < frequencies.length; i++) {
			double error = (double) frequencies[i] / totalLetters - LETTER_FREQUENCIES[i];
			totalError += error * error;
		}
		return -totalError;
	}

	public static String decrypt(byte[] ciphertext, byte key) {
		return S1C2.convertBytesToHex(S1C3.singleByteXor(ciphertext, key));
	}

	public static byte[] convertTextToBytes(String text) {
		char[] chars = text.toCharArray();
		byte[] bytes = new byte[chars.length];
		for (int i = 0; i < chars.length; i++)
			bytes[i] = (byte) chars[i];
		return bytes;
	}

	public static byte findKey(byte[] ciphertext) {
		double bestRank = 1;
		byte bestKey = 0;
		for (int candidateKey = 0; candidateKey <= 256; candidateKey++) {
			String plaintext = decrypt(ciphertext, (byte) candidateKey);
			//wrong type??? byte[] byte[] byte[]
			double rank = rank(plaintext);
			if (bestRank == 1 || rank > bestRank) {
				bestRank = rank;
				bestKey = (byte) candidateKey;
			}
				// decrypot with key. convert to text. rank. save max rank key.
		}
		return bestKey;
	}
}
