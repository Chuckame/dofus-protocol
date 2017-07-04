package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GameActionMarkCellsTypeEnum {
	CELLS_CIRCLE(0),
	CELLS_CROSS(1),
	CELLS_SQUARE(2);
	
	@Getter
	private final int value;
	
	public static GameActionMarkCellsTypeEnum valueOf(int value) {
		for (GameActionMarkCellsTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}