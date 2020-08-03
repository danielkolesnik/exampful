package com.dkolesnik.exampful.model.jpa.domain;

/**
 * Basic Permission Types
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
public enum PermissionType {

	USER_UPDATE("user_update");

	private final String _permission;

	private PermissionType(String permission) {
		this._permission = permission;
	}

	@Override
	public String toString() {
		return this.getPermission();
	}

	/**
	 * Get Permission Code Definition
	 *
	 * @return
	 */
	public String getPermission() {
		return _permission;
	}

}
