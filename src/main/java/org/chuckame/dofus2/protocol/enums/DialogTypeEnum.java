package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DialogTypeEnum {
	DIALOG_BOOK(0),
	DIALOG_DIALOG(1),
	DIALOG_LOCKABLE(2),
	DIALOG_PURCHASABLE(3),
	DIALOG_GUILD_INVITATION(4),
	DIALOG_GUILD_CREATE(5),
	DIALOG_GUILD_RENAME(6),
	DIALOG_MARRIAGE(7),
	DIALOG_DUNGEON_MEETING(8),
	DIALOG_SPELL_FORGET(9),
	DIALOG_TELEPORTER(10),
	DIALOG_EXCHANGE(11),
	DIALOG_ALLIANCE_INVITATION(12),
	DIALOG_ALLIANCE_CREATE(13),
	DIALOG_ALLIANCE_RENAME(14);
	
	@Getter
	private final int value;
	
	public static DialogTypeEnum valueOf(int value) {
		for (DialogTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}