package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GameActionFightInvisibilityStateEnum {
	INVISIBLE(1),
	DETECTED(2),
	VISIBLE(3);
	
	@Getter
	private final int value;
	
	public static GameActionFightInvisibilityStateEnum valueOf(int value) {
		for (GameActionFightInvisibilityStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}