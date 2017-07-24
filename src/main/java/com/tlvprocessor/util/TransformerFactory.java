package com.tlvprocessor.util;

import com.tlvprocessor.TypeEnum;
import com.tlvprocessor.processor.Replace;
import com.tlvprocessor.processor.TypeProcessor;
import com.tlvprocessor.processor.Uppercase;
import java.util.Optional;

public class TransformerFactory {

	public static Optional<? extends TypeProcessor> getProcessor(TypeEnum type) {
		switch (type) {
			case UPPRCS:
				return Optional.of(new Uppercase());
			case REPLCE:
				return Optional.of(new Replace());
			default:
				return Optional.empty();
		}
	}
}
