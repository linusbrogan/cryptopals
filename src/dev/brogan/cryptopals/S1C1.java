package dev.brogan.cryptopals;

public class S1C1 {
	private static final char[] BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

	public static String convertHexToBase64(String hex) {
		return convertBytesToBase64(convertHexToBytes(hex));
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
		StringBuilder chunks = new StringBuilder();
		final int LOW_6_BITS = 0x3f;

		int i;
		for (i = 0; i < bytes.length; i++) {
			byte a = bytes[i];
			i++;
			boolean hasTwoExtraBytes = i < bytes.length;
			byte b = hasTwoExtraBytes ? bytes[i] : 0;
			i++;
			boolean hasThreeExtraBytes = i < bytes.length;
			byte c = hasThreeExtraBytes ? bytes[i] : 0;

			int w = a >>> 2;
			int x = (a << 4) | (b >>> 4);
			int y = (b << 2) | (c >>> 6);
			int z = c;

			chunks.append(BASE64_CHARS[w & LOW_6_BITS]);
			chunks.append(BASE64_CHARS[x & LOW_6_BITS]);
			if (hasTwoExtraBytes)
				chunks.append(BASE64_CHARS[y & LOW_6_BITS]);
			if (hasThreeExtraBytes)
				chunks.append(BASE64_CHARS[z & LOW_6_BITS]);
		}

		for (int pad = (3 - bytes.length % 3 ) % 3; pad > 0; pad--)
			chunks.append('=');

		return chunks.toString();
	}
}
