package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PartyTypeEnum {
	PARTY_TYPE_UNDEFINED(0),
	PARTY_TYPE_CLASSICAL(1),
	PARTY_TYPE_DUNGEON(2),
	PARTY_TYPE_ARENA(3);
	
	@Getter
	private final int value;
	
	public static PartyTypeEnum valueOf(int value) {
		for (PartyTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}