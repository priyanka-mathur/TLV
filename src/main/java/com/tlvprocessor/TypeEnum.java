package com.tlvprocessor;

public enum TypeEnum {
	UPPRCS("UPPRCS"),
	REPLCE("REPLCE");

	private final String type;

	TypeEnum(final String type) {
		this.type = type;
	}

	/**
	 * method to check if type is valid
	 *
	 * @return true if type is present in Enum, false otherwise
	 */
	public static boolean isValidType(String type) {
		for (TypeEnum e : TypeEnum.values()) {
			if (type.equals(e.toString())) {
				return true;
			}
		}
		return false;
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
}
