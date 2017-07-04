package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SocialContactCategoryEnum {
	SOCIAL_CONTACT_FRIEND(0),
	SOCIAL_CONTACT_SPOUSE(1),
	SOCIAL_CONTACT_PARTY(2),
	SOCIAL_CONTACT_GUILD(3),
	SOCIAL_CONTACT_ALLIANCE(4),
	SOCIAL_CONTACT_CRAFTER(5),
	SOCIAL_CONTACT_INTERLOCUTOR(6);
	
	@Getter
	private final int value;
	
	public static SocialContactCategoryEnum valueOf(int value) {
		for (SocialContactCategoryEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}