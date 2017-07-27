package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PrismStateEnum {
	PRISM_STATE_INVULNERABLE(0),
	PRISM_STATE_NORMAL(1),
	PRISM_STATE_ATTACKED(2),
	PRISM_STATE_FIGHTING(3),
	PRISM_STATE_WEAKENED(4),
	PRISM_STATE_VULNERABLE(5),
	PRISM_STATE_DEFEATED(6),
	PRISM_STATE_SABOTAGED(7);
	
	@Getter
	private final int value;
	
	public static PrismStateEnum valueOf(int value) {
		for (PrismStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}