package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PresetSaveUpdateErrorEnum {
	PRESET_UPDATE_ERR_UNKNOWN(1),
	PRESET_UPDATE_ERR_BAD_PRESET_ID(2),
	PRESET_UPDATE_ERR_BAD_POSITION(3),
	PRESET_UPDATE_ERR_BAD_OBJECT_ID(4);
	
	@Getter
	private final int value;
	
	public static PresetSaveUpdateErrorEnum valueOf(int value) {
		for (PresetSaveUpdateErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}