package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AllianceRightsBitEnum {
	ALLIANCE_RIGHT_NONE(0),
	ALLIANCE_RIGHT_BOSS(1),
	ALLIANCE_RIGHT_MANAGE_PRISMS(2),
	ALLIANCE_RIGHT_TALK_IN_CHAN(4),
	ALLIANCE_RIGHT_RECRUIT_GUILDS(8),
	ALLIANCE_RIGHT_KICK_GUILDS(16),
	ALLIANCE_RIGHT_MANAGE_RIGHTS(32);
	
	@Getter
	private final int value;
	
	public static AllianceRightsBitEnum valueOf(int value) {
		for (AllianceRightsBitEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}