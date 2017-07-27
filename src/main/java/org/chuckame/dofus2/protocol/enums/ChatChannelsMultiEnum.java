package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChatChannelsMultiEnum {
	CHANNEL_GLOBAL(0),
	CHANNEL_TEAM(1),
	CHANNEL_GUILD(2),
	CHANNEL_ALLIANCE(3),
	CHANNEL_PARTY(4),
	CHANNEL_SALES(5),
	CHANNEL_SEEK(6),
	CHANNEL_NOOB(7),
	CHANNEL_ADMIN(8),
	CHANNEL_ADS(12),
	CHANNEL_ARENA(13);
	
	@Getter
	private final int value;
	
	public static ChatChannelsMultiEnum valueOf(int value) {
		for (ChatChannelsMultiEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}