package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FightOutcomeEnum {
	RESULT_LOST(0),
	RESULT_DRAW(1),
	RESULT_VICTORY(2),
	RESULT_TAX(5),
	RESULT_DEFENDER_GROUP(6);
	
	@Getter
	private final int value;
	
	public static FightOutcomeEnum valueOf(int value) {
		for (FightOutcomeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}