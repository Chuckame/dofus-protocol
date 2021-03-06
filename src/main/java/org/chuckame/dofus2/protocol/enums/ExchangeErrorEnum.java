package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExchangeErrorEnum {
	REQUEST_IMPOSSIBLE(1),
	REQUEST_CHARACTER_OCCUPIED(2),
	REQUEST_CHARACTER_JOB_NOT_EQUIPED(3),
	REQUEST_CHARACTER_TOOL_TOO_FAR(4),
	REQUEST_CHARACTER_OVERLOADED(5),
	REQUEST_CHARACTER_NOT_SUSCRIBER(6),
	REQUEST_CHARACTER_RESTRICTED(7),
	BUY_ERROR(8),
	SELL_ERROR(9),
	MOUNT_PADDOCK_ERROR(10),
	BID_SEARCH_ERROR(11);
	
	@Getter
	private final int value;
	
	public static ExchangeErrorEnum valueOf(int value) {
		for (ExchangeErrorEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}