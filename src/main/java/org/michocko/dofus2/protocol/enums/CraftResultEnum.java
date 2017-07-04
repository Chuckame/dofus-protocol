package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CraftResultEnum {
	CRAFT_IMPOSSIBLE(0),
	CRAFT_FAILED(1),
	CRAFT_SUCCESS(2),
	CRAFT_NEUTRAL(3);
	
	@Getter
	private final int value;
	
	public static CraftResultEnum valueOf(int value) {
		for (CraftResultEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}