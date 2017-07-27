package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum FightTypeEnum {
	FIGHT_TYPE_CHALLENGE(0),
	FIGHT_TYPE_AGRESSION(1),
	FIGHT_TYPE_PVMA(2),
	FIGHT_TYPE_MXVM(3),
	FIGHT_TYPE_PVM(4),
	FIGHT_TYPE_PVT(5),
	FIGHT_TYPE_PVMU(6),
	FIGHT_TYPE_PVP_ARENA(7),
	FIGHT_TYPE_KOH(8),
	FIGHT_TYPE_PVPR(9);
	
	@Getter
	private final int value;
	
	public static FightTypeEnum valueOf(int value) {
		for (FightTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}