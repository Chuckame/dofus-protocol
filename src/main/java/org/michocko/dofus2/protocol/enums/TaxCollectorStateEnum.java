package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaxCollectorStateEnum {
	STATE_COLLECTING(0),
	STATE_WAITING_FOR_HELP(1),
	STATE_FIGHTING(2);
	
	@Getter
	private final int value;
	
	public static TaxCollectorStateEnum valueOf(int value) {
		for (TaxCollectorStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}