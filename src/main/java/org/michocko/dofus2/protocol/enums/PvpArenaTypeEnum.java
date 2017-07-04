package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PvpArenaTypeEnum {
	ARENA_TYPE_3VS3(3),
	ARENA_TYPE_5VS5(5);
	
	@Getter
	private final int value;
	
	public static PvpArenaTypeEnum valueOf(int value) {
		for (PvpArenaTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}