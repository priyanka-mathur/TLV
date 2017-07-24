package com.tlvprocessor.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

	@Test
	public void splitStringWithMultipleTLV() {
		String input = "UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z";
		String expectedOutput = "UPPRCS-0008-Abcdefgh";
		Assert.assertEquals(Utils.splitString(input), expectedOutput);
	}

	@Test
	public void splitStringTestWithSingleTLV() {
		String input = "REPLCE-0001-Z";
		String expectedOutput = "REPLCE-0001-Z";
		Assert.assertEquals(Utils.splitString(input), expectedOutput);
	}

	@Test
	public void processTLVTestWithReplace() {
		String input = "REPLCE-0001-Z";
		String expectedOutput = "REPLCE-THIS STRING";
		Assert.assertEquals(Utils.processTLV(input), expectedOutput);
	}

	@Test
	public void processTLVTestWithUppercase() {
		String input = "UPPRCS-0005-abcde";
		String expectedOutput = "UPPRCS-ABCDE";
		Assert.assertEquals(Utils.processTLV(input), expectedOutput);
	}

	@Test
	public void processTLVTestWithInvalidType() {
		String input = "TAG001-0012-abcdefgh1234";
		String expectedOutput = "Type Not Valid";
		Assert.assertEquals(Utils.processTLV(input), expectedOutput);
	}

}
