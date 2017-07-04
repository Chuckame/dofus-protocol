package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PresetSaveResultEnum {
	PRESET_SAVE_OK(1),
	PRESET_SAVE_ERR_UNKNOWN(2),
	PRESET_SAVE_ERR_TOO_MANY(3);
	
	@Getter
	private final int value;
	
	public static PresetSaveResultEnum valueOf(int value) {
		for (PresetSaveResultEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}