package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AggressableStatusEnum {
	NON_AGGRESSABLE(0),
	PVP_ENABLED_AGGRESSABLE(10),
	PVP_ENABLED_NON_AGGRESSABLE(11),
	AVA_ENABLED_AGGRESSABLE(20),
	AVA_ENABLED_NON_AGGRESSABLE(21),
	AVA_DISQUALIFIED(22),
	AVA_PREQUALIFIED_AGGRESSABLE(23);
	
	@Getter
	private final int value;
	
	public static AggressableStatusEnum valueOf(int value) {
		for (AggressableStatusEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}