package com.tlvprocessor.util;

import com.tlvprocessor.TLV;
import org.apache.commons.lang3.StringUtils;

public class Utils {

	private Utils() {
	}

	/**
	 * The method splits the input line and returns the the first TLV string
	 *
	 * @param str string read from input
	 * @return the TLV string, null otherwise
	 */
	public static String splitString(String str) {
		if (!StringUtils.isEmpty(str)) {
			String[] input = str.split(TLV.delimiter);
			String valueLength = input[1];
			int length = Integer.parseInt(valueLength);
			int lengthOfTLV = TLV.typeLength + TLV.lengthStringLength + TLV.delimiterCount + length;
			return str.substring(0, lengthOfTLV);
		}
		return StringUtils.EMPTY;
	}

	/**
	 * The method returns processed string
	 *
	 * @param str TLV string
	 * @return string containing type + processed value
	 */
	public static String processTLV(final String str) {
		if (!StringUtils.isEmpty(str)) {
			String[] input = str.split(TLV.delimiter);
			String type = input[0];
			int length = Integer.parseInt(input[1]);
			String value = input[2];
			TLV tlvLine = new TLV(type, length, value);
			return tlvLine.processValue();
		}
		return StringUtils.EMPTY;
	}

}
