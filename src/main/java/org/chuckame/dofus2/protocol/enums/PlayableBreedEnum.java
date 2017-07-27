package org.chuckame.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PlayableBreedEnum {
	UNDEFINED(0),
	FECA(1),
	OSAMODAS(2),
	ENUTROF(3),
	SRAM(4),
	XELOR(5),
	ECAFLIP(6),
	ENIRIPSA(7),
	IOP(8),
	CRA(9),
	SADIDA(10),
	SACRIEUR(11),
	PANDAWA(12),
	ROUBLARD(13),
	ZOBAL(14),
	STEAMER(15);
	
	@Getter
	private final int value;
	
	public static PlayableBreedEnum valueOf(int value) {
		for (PlayableBreedEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}