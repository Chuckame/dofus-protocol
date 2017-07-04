package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TeamTypeEnum {
	TEAM_TYPE_PLAYER(0),
	TEAM_TYPE_MONSTER(1),
	TEAM_TYPE_MUTANT(2),
	TEAM_TYPE_TAXCOLLECTOR(3),
	TEAM_TYPE_BAD_PLAYER(4),
	TEAM_TYPE_PRISM(5);
	
	@Getter
	private final int value;
	
	public static TeamTypeEnum valueOf(int value) {
		for (TeamTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}