package com.servicenow.snowx.model;

import org.junit.Assert;
import org.junit.Test;

import com.servicenow.snowx.exception.AppException;

public class HPTorpedoTest {

	@Test
	public void testInitialization() throws AppException {
		final char[][] data1 = new char[3][2];
		data1[0][0] = ' ';
		data1[0][1] = '+';
		data1[1][0] = ' ';
		data1[1][1] = '+';
		data1[2][0] = '+';
		data1[2][1] = ' ';
		final HPTorpedo torpedo = new HPTorpedo(data1);

		Assert.assertEquals(3, torpedo.getRowCount());
		Assert.assertEquals(2, torpedo.getColumnCount());
		Assert.assertEquals(TargetType.HP_TORPEDO, torpedo.getType());
		Assert.assertEquals("+ ", String.valueOf(torpedo.getData()[2]));
	}
}
