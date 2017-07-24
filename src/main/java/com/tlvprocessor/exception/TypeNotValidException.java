package com.tlvprocessor.exception;

public class TypeNotValidException extends Exception {

  private final String cause = "Type Not Valid";

  public String toString() {
    return cause;
  }

}
