package com.servicenow.snowx.model;

import org.junit.Assert;
import org.junit.Test;

import com.servicenow.snowx.exception.AppException;

public class TargetTest {

	@Test
	public void testInitialization() throws AppException {
		final Target target = new Target(5, 3, 5.1, TargetType.HP_SHIP);

		Assert.assertEquals(5, target.getX());
		Assert.assertEquals(3, target.getY());
		Assert.assertEquals(TargetType.HP_SHIP, target.getType());
		Assert.assertEquals(5.1, target.getConfidence(), 0d);
	}

	@Test(expected = AppException.class)
	public void testNegativePossibility() throws AppException {
		new Target(5, 3, -5.1, TargetType.HP_SHIP);
	}

	@Test(expected = AppException.class)
	public void testNegativeX() throws AppException {
		new Target(-5, 3, 5.1, TargetType.HP_SHIP);
	}

	@Test(expected = AppException.class)
	public void testNegativeY() throws AppException {
		new Target(5, -3, 5.1, TargetType.HP_SHIP);
	}

	@Test(expected = AppException.class)
	public void testNullType() throws AppException {
		new Target(5, 3, 5.1, null);
	}
}
