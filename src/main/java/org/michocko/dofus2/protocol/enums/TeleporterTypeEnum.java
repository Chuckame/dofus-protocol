package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TeleporterTypeEnum {
	TELEPORTER_ZAAP(0),
	TELEPORTER_SUBWAY(1),
	TELEPORTER_PRISM(2);
	
	@Getter
	private final int value;
	
	public static TeleporterTypeEnum valueOf(int value) {
		for (TeleporterTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}