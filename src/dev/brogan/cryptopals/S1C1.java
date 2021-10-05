package dev.brogan.cryptopals;

public class S1C1 {
	public static String convertHexToBase64(String hex) {
		return null;
	}

	public static byte[] convertHexToBytes(String hex) {
		int length = hex.length();
		assert length % 1 != 1;
		byte[] bytes = new byte[length / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			char high = hex.charAt(i);
			char low = hex.charAt(i + 1);
			bytes[i / 2] = (byte) ((hexCharToByte(high) << 4) + hexCharToByte(low));
		}
		return bytes;
	}

	public static byte hexCharToByte(char c) {
		if (c >= '0' && c <= '9') return (byte) (c - '0');
		if (c >= 'a' && c <= 'f') return (byte) (c - 'a' + 10);
		if (c >= 'A' && c <= 'F') return (byte) (c - 'A' + 10);

		assert false;
		return 0;
	}

	public static String convertBytesToBase64(byte[] bytes) {
		return null;
	}
}
