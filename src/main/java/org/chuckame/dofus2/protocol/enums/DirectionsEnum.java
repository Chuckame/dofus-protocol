package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DirectionsEnum {
	DIRECTION_EAST(0),
	DIRECTION_SOUTH_EAST(1),
	DIRECTION_SOUTH(2),
	DIRECTION_SOUTH_WEST(3),
	DIRECTION_WEST(4),
	DIRECTION_NORTH_WEST(5),
	DIRECTION_NORTH(6),
	DIRECTION_NORTH_EAST(7);
	
	@Getter
	private final int value;
	
	public static DirectionsEnum valueOf(int value) {
		for (DirectionsEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}