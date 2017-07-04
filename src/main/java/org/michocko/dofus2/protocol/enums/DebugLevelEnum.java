package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DebugLevelEnum {
	LEVEL_TRACE(0),
	LEVEL_DEBUG(1),
	LEVEL_INFO(2),
	LEVEL_WARN(3),
	LEVEL_ERROR(4),
	LEVEL_FATAL(5);
	
	@Getter
	private final int value;
	
	public static DebugLevelEnum valueOf(int value) {
		for (DebugLevelEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}