package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MapObstacleStateEnum {
	OBSTACLE_OPENED(1),
	OBSTACLE_CLOSED(2);
	
	@Getter
	private final int value;
	
	public static MapObstacleStateEnum valueOf(int value) {
		for (MapObstacleStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}