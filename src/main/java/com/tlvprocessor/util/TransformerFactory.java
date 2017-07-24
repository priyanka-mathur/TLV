package com.tlvprocessor.util;

import com.tlvprocessor.TypeEnum;
import com.tlvprocessor.exception.TypeNotValidException;
import com.tlvprocessor.processor.Replace;
import com.tlvprocessor.processor.TypeProcessor;
import com.tlvprocessor.processor.Uppercase;

public class TransformerFactory {

  public static TypeProcessor getProcessor(TypeEnum type) throws TypeNotValidException {
    switch (type) {
      case UPPRCS:
        return new Uppercase();
      case REPLCE:
        return new Replace();
      default:
        throw new TypeNotValidException();
    }
  }
}
