package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DelayedActionTypeEnum {
	DELAYED_ACTION_DISCONNECT(0),
	DELAYED_ACTION_OBJECT_USE(1),
	DELAYED_ACTION_JOIN_CHARACTER(2),
	DELAYED_ACTION_AGGRESSION_IMMUNE(3);
	
	@Getter
	private final int value;
	
	public static DelayedActionTypeEnum valueOf(int value) {
		for (DelayedActionTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}