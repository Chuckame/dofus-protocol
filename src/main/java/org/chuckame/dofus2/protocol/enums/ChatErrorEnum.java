package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChatErrorEnum {
	CHAT_ERROR_UNKNOWN(0),
	CHAT_ERROR_RECEIVER_NOT_FOUND(1),
	CHAT_ERROR_INTERIOR_MONOLOGUE(2),
	CHAT_ERROR_NO_GUILD(3),
	CHAT_ERROR_NO_PARTY(4),
	CHAT_ERROR_ALLIANCE(5),
	CHAT_ERROR_INVALID_MAP(6),
	CHAT_ERROR_NO_PARTY_ARENA(7),
	CHAT_ERROR_NO_TEAM(8);
	
	@Getter
	private final int value;
	
	public static ChatErrorEnum valueOf(int value) {
		for (ChatErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}