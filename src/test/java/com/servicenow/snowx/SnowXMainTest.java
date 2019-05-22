package com.servicenow.snowx;

import java.io.File;

import org.junit.Test;

import com.servicenow.snowx.exception.AppException;

public class SnowXMainTest {

	private static String filePathTestData = new File("src/test/resources/TestData2.snw").getAbsolutePath();

	@Test
	public void testSnowX() throws AppException {
		SnowXMain.main(new String[] { "-x", SnowXMainTest.filePathTestData });
	}
}
