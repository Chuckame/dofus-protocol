package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ClientTechnologyEnum {
	CLIENT_TECHNOLOGY_UNKNOWN(0),
	CLIENT_AIR(1),
	CLIENT_FLASH(2);
	
	@Getter
	private final int value;
	
	public static ClientTechnologyEnum valueOf(int value) {
		for (ClientTechnologyEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}