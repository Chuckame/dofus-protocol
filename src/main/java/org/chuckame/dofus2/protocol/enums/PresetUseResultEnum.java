package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PresetUseResultEnum {
	PRESET_USE_OK(1),
	PRESET_USE_OK_PARTIAL(2),
	PRESET_USE_ERR_UNKNOWN(3),
	PRESET_USE_ERR_CRITERION(4),
	PRESET_USE_ERR_BAD_PRESET_ID(5);
	
	@Getter
	private final int value;
	
	public static PresetUseResultEnum valueOf(int value) {
		for (PresetUseResultEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}