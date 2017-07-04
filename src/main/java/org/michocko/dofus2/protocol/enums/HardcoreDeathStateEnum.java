package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HardcoreDeathStateEnum {
	DEATH_STATE_ALIVE(0),
	DEATH_STATE_DEAD(1),
	DEATH_STATE_WAITING_CONFIRMATION(2);
	
	@Getter
	private final int value;
	
	public static HardcoreDeathStateEnum valueOf(int value) {
		for (HardcoreDeathStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}