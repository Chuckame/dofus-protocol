package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PrismListenEnum {
	PRISM_LISTEN_NONE(0),
	PRISM_LISTEN_MINE(1),
	PRISM_LISTEN_ALL(2);
	
	@Getter
	private final int value;
	
	public static PrismListenEnum valueOf(int value) {
		for (PrismListenEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}