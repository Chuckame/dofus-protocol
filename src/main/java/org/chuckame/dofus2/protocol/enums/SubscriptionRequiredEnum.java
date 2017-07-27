package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SubscriptionRequiredEnum {
	LIMITED_TO_SUBSCRIBER(0),
	LIMIT_ON_JOB_XP(1),
	LIMIT_ON_JOB_USE(2),
	LIMIT_ON_MAP(3),
	LIMIT_ON_ITEM(4),
	LIMIT_ON_VENDOR(5);
	
	@Getter
	private final int value;
	
	public static SubscriptionRequiredEnum valueOf(int value) {
		for (SubscriptionRequiredEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}