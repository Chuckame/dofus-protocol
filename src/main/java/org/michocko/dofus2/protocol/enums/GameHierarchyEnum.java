package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GameHierarchyEnum {
	UNAVAILABLE(-1),
	PLAYER(0),
	MODERATOR(10),
	GAMEMASTER_PADAWAN(20),
	GAMEMASTER(30),
	ADMIN(40);
	
	@Getter
	private final int value;
	
	public static GameHierarchyEnum valueOf(int value) {
		for (GameHierarchyEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}