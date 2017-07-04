package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PresetDeleteResultEnum {
	PRESET_DEL_OK(1),
	PRESET_DEL_ERR_UNKNOWN(2),
	PRESET_DEL_ERR_BAD_PRESET_ID(3);
	
	@Getter
	private final int value;
	
	public static PresetDeleteResultEnum valueOf(int value) {
		for (PresetDeleteResultEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}