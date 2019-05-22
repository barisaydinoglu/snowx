package com.servicenow.snowx.exception;

import org.junit.Assert;
import org.junit.Test;

public class AppExceptionTest {

	@Test
	public void testInitialization() {
		final AppException givenException = new AppException("test");

		Assert.assertEquals("Application Exception: test", givenException.getMessage());
	}
}
