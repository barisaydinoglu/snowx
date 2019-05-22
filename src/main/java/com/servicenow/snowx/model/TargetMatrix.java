package com.servicenow.snowx.model;

public abstract class TargetMatrix extends Matrix {

	private final TargetType type;

	public TargetMatrix(final char[][] data) {
		super(data);
		this.type = this.resolveTargetType();
	}

	public TargetType getType() {
		return this.type;
	}

	protected abstract TargetType resolveTargetType();
}
