package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExchangeReplayStopReasonEnum {
	STOPPED_REASON_OK(1),
	STOPPED_REASON_USER(2),
	STOPPED_REASON_MISSING_RESSOURCE(3),
	STOPPED_REASON_IMPOSSIBLE_CRAFT(4);
	
	@Getter
	private final int value;
	
	public static ExchangeReplayStopReasonEnum valueOf(int value) {
		for (ExchangeReplayStopReasonEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}