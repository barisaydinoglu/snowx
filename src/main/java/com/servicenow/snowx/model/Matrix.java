package com.servicenow.snowx.model;

public abstract class Matrix {

	private final int rowCount;

	private final int columnCount;

	private final char[][] data;

	public Matrix(final char[][] data) {
		this.rowCount = data.length;
		this.columnCount = data[0].length;
		this.data = new char[this.getRowCount()][this.getColumnCount()];
		for (int xi = 0; xi < this.getRowCount(); ++xi) {
			for (int yi = 0; yi < this.getColumnCount(); ++yi) {
				this.data[xi][yi] = data[xi][yi];
			}
		}
	}

	public int getColumnCount() {
		return this.columnCount;
	}

	public char[][] getData() {
		return this.data;
	}

	public int getRowCount() {
		return this.rowCount;
	}
}
