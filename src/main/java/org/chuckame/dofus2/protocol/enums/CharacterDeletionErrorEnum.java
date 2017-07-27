package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CharacterDeletionErrorEnum {
	DEL_ERR_NO_REASON(1),
	DEL_ERR_TOO_MANY_CHAR_DELETION(2),
	DEL_ERR_BAD_SECRET_ANSWER(3),
	DEL_ERR_RESTRICED_ZONE(4);
	
	@Getter
	private final int value;
	
	public static CharacterDeletionErrorEnum valueOf(int value) {
		for (CharacterDeletionErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}