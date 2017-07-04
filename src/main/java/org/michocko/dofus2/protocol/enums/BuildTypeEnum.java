package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BuildTypeEnum {
	RELEASE(0),
	BETA(1),
	ALPHA(2),
	TESTING(3),
	INTERNAL(4),
	DEBUG(5),
	EXPERIMENTAL(6);
	
	@Getter
	private final int value;
	
	public static BuildTypeEnum valueOf(int value) {
		for (BuildTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}