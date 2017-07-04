package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UpdatableMountBoostEnum {
	STAMINA(3),
	MATURITY(5),
	ENERGY(1),
	SERENITY(2),
	LOVE(4),
	TIREDNESS(6);
	
	@Getter
	private final int value;
	
	public static UpdatableMountBoostEnum valueOf(int value) {
		for (UpdatableMountBoostEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}