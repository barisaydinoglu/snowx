package com.servicenow.snowx.utils;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.servicenow.snowx.exception.AppException;

public class FileUtilsTest {

	private static final String FILE_PATH_404 = new File("src/test/resources/filePath404.snw").getAbsolutePath();
	private static final String FILE_PATH_HP_SHIP = new File("src/main/resources/HPShip.snw").getAbsolutePath();
	private static final String FILE_PATH_HP_TORPEDO = new File("src/main/resources/HPTorpedo.snw").getAbsolutePath();
	private static final String FILE_PATH_TEST_DATA = new File("src/test/resources/TestData.snw").getAbsolutePath();

	@Test(expected = AppException.class)
	public void testPackFileError() throws AppException {
		FileUtils.readDataFromFile(FileUtilsTest.FILE_PATH_404);
	}

	@Test
	public void testReadHPShip() throws AppException {
		final char[][] data = FileUtils.readDataFromFile(FileUtilsTest.FILE_PATH_HP_SHIP);

		Assert.assertNotNull(data);
		Assert.assertEquals(11, data.length);
		Assert.assertEquals(14, data[0].length);
		Assert.assertEquals(' ', data[0][5]);
		Assert.assertEquals('+', data[1][4]);
		Assert.assertEquals(' ', data[2][0]);
		Assert.assertEquals('+', data[2][1]);
		Assert.assertEquals('+', data[2][2]);
		Assert.assertEquals(' ', data[2][3]);

		Assert.assertEquals("              ", String.valueOf(data[0]));
		Assert.assertEquals("  ++++++++++  ", String.valueOf(data[1]));
		Assert.assertEquals(" ++        ++ ", String.valueOf(data[2]));
		Assert.assertEquals("  ++++++++++  ", String.valueOf(data[3]));
		Assert.assertEquals("      ++      ", String.valueOf(data[4]));
		Assert.assertEquals("      ++      ", String.valueOf(data[5]));
		Assert.assertEquals("      ++      ", String.valueOf(data[6]));
		Assert.assertEquals("  ++++++++++  ", String.valueOf(data[7]));
		Assert.assertEquals(" ++        ++ ", String.valueOf(data[8]));
		Assert.assertEquals("  ++++++++++  ", String.valueOf(data[9]));
		Assert.assertEquals("              ", String.valueOf(data[10]));
	}

	@Test
	public void testReadHPTorpedo() throws AppException {
		final char[][] data = FileUtils.readDataFromFile(FileUtilsTest.FILE_PATH_HP_TORPEDO);

		Assert.assertNotNull(data);
		Assert.assertEquals(13, data.length);
		Assert.assertEquals(11, data[0].length);
		Assert.assertEquals(' ', data[0][5]);
		Assert.assertEquals('+', data[1][5]);
		Assert.assertEquals(' ', data[2][0]);
		Assert.assertEquals('+', data[4][2]);

		Assert.assertEquals("           ", String.valueOf(data[0]));
		Assert.assertEquals("     +     ", String.valueOf(data[1]));
		Assert.assertEquals("     +     ", String.valueOf(data[2]));
		Assert.assertEquals("    +++    ", String.valueOf(data[3]));
		Assert.assertEquals("  +++++++  ", String.valueOf(data[4]));
		Assert.assertEquals("  ++   ++  ", String.valueOf(data[5]));
		Assert.assertEquals(" ++  +  ++ ", String.valueOf(data[6]));
		Assert.assertEquals(" ++ +++ ++ ", String.valueOf(data[7]));
		Assert.assertEquals(" ++  +  ++ ", String.valueOf(data[8]));
		Assert.assertEquals("  ++   ++  ", String.valueOf(data[9]));
		Assert.assertEquals("  +++++++  ", String.valueOf(data[10]));
		Assert.assertEquals("    +++    ", String.valueOf(data[11]));
		Assert.assertEquals("           ", String.valueOf(data[12]));
	}

	@Test
	public void testReadTestData() throws AppException {
		final char[][] data = FileUtils.readDataFromFile(FileUtilsTest.FILE_PATH_TEST_DATA);

		Assert.assertNotNull(data);
		Assert.assertEquals(100, data.length);
		Assert.assertEquals(100, data[0].length);

		Assert.assertEquals(' ', data[0][5]);
		Assert.assertEquals('+', data[1][4]);
		Assert.assertEquals(' ', data[2][0]);
		Assert.assertEquals(' ', data[2][1]);
		Assert.assertEquals(' ', data[2][2]);
		Assert.assertEquals('+', data[2][5]);

		Assert.assertEquals(
				"              + +    +              ++           +       +++    +     +               +    +    +   ",
				String.valueOf(data[0]));
		Assert.assertEquals(
				" +  ++     +   + ++++    + +       +         +          +  +   +++     +++ +           + + +      + ",
				String.valueOf(data[1]));
		Assert.assertEquals(
				" +   +       + +         ++    + ++  ++      +  +++     ++ +  + +  +      +                 +   +   ",
				String.valueOf(data[22]));
		Assert.assertEquals(
				"   +    +               ++  + +     +    +++   + +  ++     +    + + ++     +          +     +    ++ ",
				String.valueOf(data[50]));
		Assert.assertEquals(
				"    ++++      +   +  +   +        ++       +              +  + + ++      + +  ++   +  +     +     ++",
				String.valueOf(data[53]));
		Assert.assertEquals(
				"        ++  +   +      +  +    +++  +  ++                  ++ + +   +                + +     +  +  +",
				String.valueOf(data[99]));
	}
}
