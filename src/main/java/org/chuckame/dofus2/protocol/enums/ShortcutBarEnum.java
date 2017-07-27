package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ShortcutBarEnum {
	GENERAL_SHORTCUT_BAR(0),
	SPELL_SHORTCUT_BAR(1);
	
	@Getter
	private final int value;
	
	public static ShortcutBarEnum valueOf(int value) {
		for (ShortcutBarEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}