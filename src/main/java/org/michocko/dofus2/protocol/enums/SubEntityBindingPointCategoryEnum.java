package org.michocko.dofus2.protocol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SubEntityBindingPointCategoryEnum {
	HOOK_POINT_CATEGORY_UNUSED(0),
	HOOK_POINT_CATEGORY_PET(1),
	HOOK_POINT_CATEGORY_MOUNT_DRIVER(2),
	HOOK_POINT_CATEGORY_LIFTED_ENTITY(3),
	HOOK_POINT_CATEGORY_BASE_BACKGROUND(4),
	HOOK_POINT_CATEGORY_MERCHANT_BAG(5),
	HOOK_POINT_CATEGORY_BASE_FOREGROUND(6);
	
	@Getter
	private final int value;
	
	public static SubEntityBindingPointCategoryEnum valueOf(int value) {
		for (SubEntityBindingPointCategoryEnum a : values()) {
			if (a.value == value)
				return a;
		}
		throw new UnsupportedOperationException();
	}
}