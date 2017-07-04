package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NicknameErrorEnum {
	ALREADY_USED(1),
	SAME_AS_LOGIN(2),
	TOO_SIMILAR_TO_LOGIN(3),
	INVALID_NICK(4),
	UNKNOWN_NICK_ERROR(99);
	
	@Getter
	private final int value;
	
	public static NicknameErrorEnum valueOf(int value) {
		for (NicknameErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}