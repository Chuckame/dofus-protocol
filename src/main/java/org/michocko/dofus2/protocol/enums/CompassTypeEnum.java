package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CompassTypeEnum {
	COMPASS_TYPE_SIMPLE(0),
	COMPASS_TYPE_SPOUSE(1),
	COMPASS_TYPE_PARTY(2),
	COMPASS_TYPE_PVP_SEEK(3),
	COMPASS_TYPE_QUEST(4);
	
	@Getter
	private final int value;
	
	public static CompassTypeEnum valueOf(int value) {
		for (CompassTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}