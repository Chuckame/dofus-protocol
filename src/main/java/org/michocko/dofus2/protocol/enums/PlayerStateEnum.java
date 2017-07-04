package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayerStateEnum {
	NOT_CONNECTED(0),
	GAME_TYPE_ROLEPLAY(1),
	GAME_TYPE_FIGHT(2),
	UNKNOWN_STATE(99);
	
	@Getter
	private final int value;
	
	public static PlayerStateEnum valueOf(int value) {
		for (PlayerStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}