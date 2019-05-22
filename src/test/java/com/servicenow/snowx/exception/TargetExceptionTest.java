package com.servicenow.snowx.exception;

import org.junit.Assert;
import org.junit.Test;

public class TargetExceptionTest {

	@Test
	public void testInitialization() {
		final TargetException givenException = new TargetException("test");

		Assert.assertEquals("Application Exception: Target Exception: test", givenException.getMessage());
	}
}
