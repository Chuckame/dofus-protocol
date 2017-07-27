package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ListAddFailureEnum {
	LIST_ADD_FAILURE_UNKNOWN(0),
	LIST_ADD_FAILURE_OVER_QUOTA(1),
	LIST_ADD_FAILURE_NOT_FOUND(2),
	LIST_ADD_FAILURE_EGOCENTRIC(3),
	LIST_ADD_FAILURE_IS_DOUBLE(4);
	
	@Getter
	private final int value;
	
	public static ListAddFailureEnum valueOf(int value) {
		for (ListAddFailureEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}