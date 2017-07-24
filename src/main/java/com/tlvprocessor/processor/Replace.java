package com.tlvprocessor.processor;

import com.tlvprocessor.TLV;
import com.tlvprocessor.TypeEnum;

public class Replace implements TypeProcessor {

  private final static TypeEnum type = TypeEnum.REPLCE;
  private final String CONSTANT = "THIS STRING";

  public String transform(final String str) {
    return type.toString() + TLV.delimiter + CONSTANT;
  }

}