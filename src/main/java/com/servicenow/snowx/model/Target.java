package com.servicenow.snowx.model;

import com.servicenow.snowx.exception.AppException;
import com.servicenow.snowx.exception.TargetException;

public class Target {

	private final int x;
	private final int y;
	private final double confidence;
	private final TargetType type;

	public Target(final int x, final int y, final double confidence, final TargetType type) throws AppException {
		if (x < 0) {
			throw new TargetException("'x' coordinate cannot be less than 0");
		}
		if (y < 0) {
			throw new TargetException("'y' coordinate cannot be less than 0");
		}
		if (confidence < 0) {
			throw new TargetException("Confidence cannot be less than 0");
		}
		if (type == null) {
			throw new TargetException("Type cannot be null");
		}
		this.x = x;
		this.y = y;
		this.confidence = confidence;
		this.type = type;
	}

	public double getConfidence() {
		return this.confidence;
	}

	public TargetType getType() {
		return this.type;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "Target [x=" + this.x + ", y=" + this.y + ", confidence=" + this.confidence + ", type=" + this.type
				+ "]";
	}
}
