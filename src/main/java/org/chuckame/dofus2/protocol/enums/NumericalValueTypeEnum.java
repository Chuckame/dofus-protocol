package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NumericalValueTypeEnum {
	NUMERICAL_VALUE_DEFAULT(0),
	NUMERICAL_VALUE_COLLECT(1),
	NUMERICAL_VALUE_CRAFT(2),
	NUMERICAL_VALUE_PADDOCK(3),
	NUMERICAL_VALUE_RED(64),
	NUMERICAL_VALUE_BLUE(65),
	NUMERICAL_VALUE_GREEN(66);
	
	@Getter
	private final int value;
	
	public static NumericalValueTypeEnum valueOf(int value) {
		for (NumericalValueTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}