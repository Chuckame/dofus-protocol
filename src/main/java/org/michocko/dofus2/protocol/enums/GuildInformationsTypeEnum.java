package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GuildInformationsTypeEnum {
	INFO_GENERAL(1),
	INFO_MEMBERS(2),
	INFO_BOOSTS(3),
	INFO_PADDOCKS(4),
	INFO_HOUSES(5),
	INFO_TAX_COLLECTOR_GUILD_ONLY(6),
	INFO_TAX_COLLECTOR_ALLIANCE(7),
	INFO_TAX_COLLECTOR_LEAVE(8);
	
	@Getter
	private final int value;
	
	public static GuildInformationsTypeEnum valueOf(int value) {
		for (GuildInformationsTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}