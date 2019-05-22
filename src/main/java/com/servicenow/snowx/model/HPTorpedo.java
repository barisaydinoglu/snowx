package com.servicenow.snowx.model;

public class HPTorpedo extends TargetMatrix {

	public HPTorpedo(final char[][] data) {
		super(data);
	}

	@Override
	protected TargetType resolveTargetType() {
		return TargetType.HP_TORPEDO;
	}
}
