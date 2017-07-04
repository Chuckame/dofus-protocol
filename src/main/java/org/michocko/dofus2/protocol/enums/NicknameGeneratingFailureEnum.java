package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NicknameGeneratingFailureEnum {
	NICKNAME_GENERATOR_RETRY_TOO_SHORT(1),
	NICKNAME_GENERATOR_UNAVAILABLE(2);
	
	@Getter
	private final int value;
	
	public static NicknameGeneratingFailureEnum valueOf(int value) {
		for (NicknameGeneratingFailureEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}