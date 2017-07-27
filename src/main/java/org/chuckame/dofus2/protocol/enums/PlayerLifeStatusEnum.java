package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerLifeStatusEnum {
	STATUS_ALIVE_AND_KICKING(0),
	STATUS_TOMBSTONE(1),
	STATUS_PHANTOM(2);
	
	@Getter
	private final int value;
	
	public static PlayerLifeStatusEnum valueOf(int value) {
		for (PlayerLifeStatusEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}