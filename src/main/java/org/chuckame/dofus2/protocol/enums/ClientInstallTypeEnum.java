package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ClientInstallTypeEnum {
	CLIENT_INSTALL_UNKNOWN(0),
	CLIENT_BUNDLE(1),
	CLIENT_STREAMING(2);
	
	@Getter
	private final int value;
	
	public static ClientInstallTypeEnum valueOf(int value) {
		for (ClientInstallTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}