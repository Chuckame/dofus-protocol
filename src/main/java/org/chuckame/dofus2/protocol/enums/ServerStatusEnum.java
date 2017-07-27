package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ServerStatusEnum {
	STATUS_UNKNOWN(0),
	OFFLINE(1),
	STARTING(2),
	ONLINE(3),
	NOJOIN(4),
	SAVING(5),
	STOPING(6),
	FULL(7);
	
	@Getter
	private final int value;
	
	public static ServerStatusEnum valueOf(int value) {
		for (ServerStatusEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}