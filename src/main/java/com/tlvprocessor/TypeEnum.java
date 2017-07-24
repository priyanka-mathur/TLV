package com.tlvprocessor;

import com.tlvprocessor.exception.TypeNotValidException;

public enum TypeEnum {
  UPPRCS("UPPRCS"),
  REPLCE("REPLCE");

  private final String type;

  TypeEnum(final String type) {
    this.type = type;
  }

  /**
   * toString method.
   *
   * @return Value of this Enum as String.
   */
  @Override
  public String toString() {
    return type;
  }

  /**
   * custom implementation of valueOf
   * @return TypeEnum of type, throws TypeNotValidException
   */
  public static TypeEnum getValue(String type) throws TypeNotValidException {
    for (TypeEnum e : TypeEnum.values()) {
      if (type.equals(e.toString())) {
        return e;
      }
    }
    throw new TypeNotValidException();
  }

}
