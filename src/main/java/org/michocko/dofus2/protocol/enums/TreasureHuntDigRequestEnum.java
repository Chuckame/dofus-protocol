package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TreasureHuntDigRequestEnum {
	TREASURE_HUNT_DIG_ERROR_UNDEFINED(0),
	TREASURE_HUNT_DIG_NEW_HINT(1),
	TREASURE_HUNT_DIG_FINISHED(2),
	TREASURE_HUNT_DIG_WRONG(3),
	TREASURE_HUNT_DIG_LOST(4),
	TREASURE_HUNT_DIG_ERROR_IMPOSSIBLE(5);
	
	@Getter
	private final int value;
	
	public static TreasureHuntDigRequestEnum valueOf(int value) {
		for (TreasureHuntDigRequestEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}