package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GameActionMarkTypeEnum {
	GLYPH(1),
	TRAP(2),
	WALL(3);
	
	@Getter
	private final int value;
	
	public static GameActionMarkTypeEnum valueOf(int value) {
		for (GameActionMarkTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}