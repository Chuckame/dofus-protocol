package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TextInformationTypeEnum {
	TEXT_INFORMATION_MESSAGE(0),
	TEXT_INFORMATION_ERROR(1),
	TEXT_INFORMATION_PVP(2),
	TEXT_INFORMATION_FIGHT_LOG(3),
	TEXT_INFORMATION_POPUP(4),
	TEXT_LIVING_OBJECT(5),
	TEXT_ENTITY_TALK(6),
	TEXT_INFORMATION_FIGHT(7);
	
	@Getter
	private final int value;
	
	public static TextInformationTypeEnum valueOf(int value) {
		for (TextInformationTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}