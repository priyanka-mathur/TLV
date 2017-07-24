package com.tlvprocessor.processor;

import com.tlvprocessor.TLV;
import com.tlvprocessor.TypeEnum;

public class Uppercase implements TypeProcessor {

	private final static TypeEnum type = TypeEnum.UPPRCS;

	public String transform(final String str) {
		return type.toString() + TLV.delimiter + str.toUpperCase();
	}

}
