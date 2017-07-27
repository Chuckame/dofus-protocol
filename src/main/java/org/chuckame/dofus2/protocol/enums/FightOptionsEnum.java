package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FightOptionsEnum {
	FIGHT_OPTION_SET_SECRET(0),
	FIGHT_OPTION_SET_TO_PARTY_ONLY(1),
	FIGHT_OPTION_SET_CLOSED(2),
	FIGHT_OPTION_ASK_FOR_HELP(3);
	
	@Getter
	private final int value;
	
	public static FightOptionsEnum valueOf(int value) {
		for (FightOptionsEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}