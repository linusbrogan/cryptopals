package dev.brogan.cryptopals;

public class S1C2 {
	private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

	public static byte[] xor(byte[] a, byte[] b) {
		assert a.length == b.length;
		byte[] c = new byte[a.length];
		for (int i = 0; i < a.length; i++)
			c[i] = (byte) (a[i] ^ b[i]);
		return c;
	}

	public static String xor(String a, String b) {
		byte[] x = S1C1.convertHexToBytes(a);
		byte[] y = S1C1.convertHexToBytes(b);
		return S1C2.convertBytesToHex(xor(x, y));
	}

	public static String convertBytesToHex(byte[] bytes) {
		StringBuilder nybbles = new StringBuilder();
		for (byte b : bytes) {
			int high = b >>> 4;
			int low = b & 0xf;

			nybbles.append(HEX_CHARS[high]);
			nybbles.append(HEX_CHARS[low]);
		}
		return nybbles.toString();
	}
}
