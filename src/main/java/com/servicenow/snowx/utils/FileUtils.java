package com.servicenow.snowx.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.servicenow.snowx.exception.AppException;

public final class FileUtils {

	public static char[][] readDataFromFile(final String filePath) throws AppException {
		final List<char[]> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line.toCharArray());
			}
		} catch (final Exception e) {
			throw new AppException(e.getMessage());
		}
		final int rowCount = lines.size();
		int columnCount = 0;
		if (rowCount > 0) {
			columnCount = lines.get(0).length;
		}
		final char[][] data = new char[rowCount][columnCount];
		for (int i = 0; i < rowCount; ++i) {
			data[i] = lines.get(i);
		}
		return data;
	}

	private FileUtils() {
	}
}
