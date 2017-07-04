package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GameContextEnum {
	ROLE_PLAY(1),
	FIGHT(2);
	
	@Getter
	private final int value;
	
	public static GameContextEnum valueOf(int value) {
		for (GameContextEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}