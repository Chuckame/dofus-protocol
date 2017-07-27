package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FightDispellableEnum {
	DISPELLABLE(1),
	DISPELLABLE_BY_DEATH(2),
	DISPELLABLE_BY_STRONG_DISPEL(3),
	REALLY_NOT_DISPELLABLE(4);
	
	@Getter
	private final int value;
	
	public static FightDispellableEnum valueOf(int value) {
		for (FightDispellableEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}