package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FightSpellCastCriticalEnum {
	NORMAL(1),
	CRITICAL_HIT(2),
	CRITICAL_FAIL(3);
	
	@Getter
	private final int value;
	
	public static FightSpellCastCriticalEnum valueOf(int value) {
		for (FightSpellCastCriticalEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}