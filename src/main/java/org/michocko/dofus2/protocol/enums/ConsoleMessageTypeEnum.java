package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ConsoleMessageTypeEnum {
	CONSOLE_TEXT_MESSAGE(0),
	CONSOLE_INFO_MESSAGE(1),
	CONSOLE_ERR_MESSAGE(2);
	
	@Getter
	private final int value;
	
	public static ConsoleMessageTypeEnum valueOf(int value) {
		for (ConsoleMessageTypeEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}