package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TreasureHuntTypeEnum {
	TREASURE_HUNT_CLASSIC(0),
	TREASURE_HUNT_PORTAL(1);
	
	@Getter
	private final int value;
	
	public static TreasureHuntTypeEnum valueOf(int value) {
		for (TreasureHuntTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}