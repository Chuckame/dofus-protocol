package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PrismSetSabotagedRefusedReasonEnum {
	SABOTAGE_REFUSED(-1),
	SABOTAGE_INSUFFICIENT_RIGHTS(0),
	SABOTAGE_MEMBER_ACCOUNT_NEEDED(1),
	SABOTAGE_RESTRICTED_ACCOUNT(2),
	SABOTAGE_WRONG_ALLIANCE(3),
	SABOTAGE_NO_PRISM(4),
	SABOTAGE_WRONG_STATE(5);
	
	@Getter
	private final int value;
	
	public static PrismSetSabotagedRefusedReasonEnum valueOf(int value) {
		for (PrismSetSabotagedRefusedReasonEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}