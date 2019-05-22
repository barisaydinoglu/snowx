package com.servicenow.snowx.model;

import org.junit.Assert;
import org.junit.Test;

import com.servicenow.snowx.exception.AppException;

public class HPShipTest {

	@Test
	public void testInitialization() throws AppException {
		final char[][] data1 = new char[3][4];
		data1[0][0] = ' ';
		data1[0][1] = '+';
		data1[0][2] = ' ';
		data1[0][3] = '+';
		data1[1][0] = ' ';
		data1[1][1] = '+';
		data1[1][2] = ' ';
		data1[1][3] = '+';
		data1[2][0] = '+';
		data1[2][1] = ' ';
		data1[2][2] = '+';
		data1[2][3] = ' ';
		final HPShip ship = new HPShip(data1);

		Assert.assertEquals(3, ship.getRowCount());
		Assert.assertEquals(4, ship.getColumnCount());
		Assert.assertEquals(TargetType.HP_SHIP, ship.getType());
		Assert.assertEquals("+ + ", String.valueOf(ship.getData()[2]));
	}
}
