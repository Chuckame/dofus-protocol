package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CrafterDirectoryParamBitEnum {
	CRAFT_OPTION_NONE(0),
	CRAFT_OPTION_NOT_FREE(1),
	CRAFT_OPTION_NOT_FREE_EXCEPT_ON_FAIL(2),
	CRAFT_OPTION_RESOURCES_REQUIRED(4);
	
	@Getter
	private final int value;
	
	public static CrafterDirectoryParamBitEnum valueOf(int value) {
		for (CrafterDirectoryParamBitEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}