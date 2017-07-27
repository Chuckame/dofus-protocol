package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TeamEnum {
	TEAM_CHALLENGER(0),
	TEAM_DEFENDER(1),
	TEAM_SPECTATOR(2);
	
	@Getter
	private final int value;
	
	public static TeamEnum valueOf(int value) {
		for (TeamEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}