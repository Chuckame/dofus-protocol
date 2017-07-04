package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TreasureHuntRequestEnum {
	TREASURE_HUNT_ERROR_UNDEFINED(0),
	TREASURE_HUNT_ERROR_NO_QUEST_FOUND(2),
	TREASURE_HUNT_ERROR_ALREADY_HAVE_QUEST(3),
	TREASURE_HUNT_OK(1);
	
	@Getter
	private final int value;
	
	public static TreasureHuntRequestEnum valueOf(int value) {
		for (TreasureHuntRequestEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}