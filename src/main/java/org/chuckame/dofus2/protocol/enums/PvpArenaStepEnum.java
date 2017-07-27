package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PvpArenaStepEnum {
	ARENA_STEP_REGISTRED(0),
	ARENA_STEP_WAITING_FIGHT(1),
	ARENA_STEP_STARTING_FIGHT(2),
	ARENA_STEP_UNREGISTER(3);
	
	@Getter
	private final int value;
	
	public static PvpArenaStepEnum valueOf(int value) {
		for (PvpArenaStepEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}