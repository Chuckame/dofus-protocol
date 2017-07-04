package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PaymentTypeEnum {
	PAYMENT_ON_SUCCESS_ONLY(0),
	PAYMENT_IN_ANY_CASE(1);
	
	@Getter
	private final int value;
	
	public static PaymentTypeEnum valueOf(int value) {
		for (PaymentTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}