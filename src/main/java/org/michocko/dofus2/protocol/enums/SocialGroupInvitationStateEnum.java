package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SocialGroupInvitationStateEnum {
	SOCIAL_GROUP_INVITATION_FAILED(0),
	SOCIAL_GROUP_INVITATION_SENT(1),
	SOCIAL_GROUP_INVITATION_CANCELED(2),
	SOCIAL_GROUP_INVITATION_OK(3);
	
	@Getter
	private final int value;
	
	public static SocialGroupInvitationStateEnum valueOf(int value) {
		for (SocialGroupInvitationStateEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}