package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MountEquipedErrorEnum {
	UNSET(0),
	SET(1),
	RIDING(2);
	
	@Getter
	private final int value;
	
	public static MountEquipedErrorEnum valueOf(int value) {
		for (MountEquipedErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}