package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerStatusEnum {
	PLAYER_STATUS_OFFLINE(0),
	PLAYER_STATUS_UNKNOWN(1),
	PLAYER_STATUS_AVAILABLE(10),
	PLAYER_STATUS_IDLE(20),
	PLAYER_STATUS_AFK(21),
	PLAYER_STATUS_PRIVATE(30),
	PLAYER_STATUS_SOLO(40);
	
	@Getter
	private final int value;
	
	public static PlayerStatusEnum valueOf(int value) {
		for (PlayerStatusEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}