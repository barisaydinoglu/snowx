package com.servicenow.snowx.model;

public class HPShip extends TargetMatrix {

	public HPShip(final char[][] data) {
		super(data);
	}

	@Override
	protected TargetType resolveTargetType() {
		return TargetType.HP_SHIP;
	}
}
