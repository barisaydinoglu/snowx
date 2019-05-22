package com.servicenow.snowx.utils;

import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import com.servicenow.snowx.exception.AppException;
import com.servicenow.snowx.model.HPShip;
import com.servicenow.snowx.model.HPTorpedo;
import com.servicenow.snowx.model.SnowX;
import com.servicenow.snowx.model.Target;

public class UtilsTest {
	@Test
	public void testAnalysis() throws AppException {

		final char[][] data1 = new char[3][3];
		data1[0][0] = '+';
		data1[0][1] = '+';
		data1[0][2] = '+';
		data1[1][0] = '+';
		data1[1][1] = '+';
		data1[1][2] = '+';
		data1[2][0] = '+';
		data1[2][1] = '+';
		data1[2][2] = '+';
		final SnowX snowX = new SnowX(data1);

		final char[][] data2 = new char[2][2];
		data2[0][0] = '+';
		data2[0][1] = '+';
		data2[1][0] = '+';
		data2[1][1] = ' ';
		final HPTorpedo torpedo = new HPTorpedo(data2);

		final char[][] data3 = new char[1][3];
		data3[0][0] = '+';
		data3[0][1] = '+';
		data3[0][2] = '+';
		final HPShip ship = new HPShip(data3);

		final List<Target> targets = Utils.analysis(snowX, ship, torpedo);

		Assert.assertNotNull(targets);
		Assert.assertEquals(7, targets.size());
	}

	@Test
	public void testConvolution() throws AppException {
		final char[][] data1 = new char[3][3];
		data1[0][0] = '+';
		data1[0][1] = '+';
		data1[0][2] = '+';
		data1[1][0] = '+';
		data1[1][1] = '+';
		data1[1][2] = ' ';
		data1[2][0] = '+';
		data1[2][1] = '+';
		data1[2][2] = '+';

		final char[][] data2 = new char[2][2];
		data2[0][0] = '+';
		data2[0][1] = ' ';
		data2[1][0] = '+';
		data2[1][1] = ' ';

		final int convolution = Utils.applyConvolution(data1, 1, 1, data2, 2, 2);
		Assert.assertEquals(3, convolution);
	}

	@Test
	public void testEmptyResultQueue() {
		final PriorityQueue<Target> pq = Utils.getEmptyResultQueue();

		Assert.assertNotNull(pq);
		Assert.assertEquals(0, pq.size());
	}

	@Test
	public void testInitialization() throws AppException {
		final char[][] data1 = new char[3][3];
		data1[0][0] = '+';
		data1[0][1] = '+';
		data1[0][2] = '+';
		data1[1][0] = '+';
		data1[1][1] = '+';
		data1[1][2] = '+';
		data1[2][0] = '+';
		data1[2][1] = '+';
		data1[2][2] = '+';
		final SnowX snowX = new SnowX(data1);

		final char[][] data2 = new char[1][1];
		data2[0][0] = '+';
		final HPShip ship = new HPShip(data2);

		final List<Target> targets = Utils.searchPattern(snowX, ship, 0.5);

		Assert.assertNotNull(targets);
		Assert.assertEquals(9, targets.size());
	}

	@Test
	public void testSearchSelf() throws AppException {
		final char[][] data1 = new char[3][3];
		data1[0][0] = '+';
		data1[0][1] = '+';
		data1[0][2] = '+';
		data1[1][0] = '+';
		data1[1][1] = '+';
		data1[1][2] = '+';
		data1[2][0] = '+';
		data1[2][1] = '+';
		data1[2][2] = '+';
		final SnowX snowX = new SnowX(data1);

		final HPTorpedo torpedo = new HPTorpedo(data1);

		final List<Target> targets = Utils.searchPattern(snowX, torpedo, 0.5);

		Assert.assertNotNull(targets);
		Assert.assertEquals(1, targets.size());
	}

	@Test
	public void testSearchTorpedo() throws AppException {
		final char[][] data1 = new char[3][3];
		data1[0][0] = '+';
		data1[0][1] = '+';
		data1[0][2] = '+';
		data1[1][0] = '+';
		data1[1][1] = '+';
		data1[1][2] = '+';
		data1[2][0] = '+';
		data1[2][1] = '+';
		data1[2][2] = '+';
		final SnowX snowX = new SnowX(data1);

		final char[][] data2 = new char[2][2];
		data2[0][0] = '+';
		data2[0][1] = '+';
		data2[1][0] = '+';
		data2[1][1] = ' ';
		final HPTorpedo torpedo = new HPTorpedo(data2);

		final List<Target> targets = Utils.searchPattern(snowX, torpedo, 0.5);

		Assert.assertNotNull(targets);
		Assert.assertEquals(4, targets.size());
	}
}
