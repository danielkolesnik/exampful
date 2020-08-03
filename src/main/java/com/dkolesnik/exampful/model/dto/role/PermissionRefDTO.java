package com.dkolesnik.exampful.model.dto.role;

import com.dkolesnik.exampful.model.dto.DTOBase;
import com.dkolesnik.exampful.model.jpa.entity.Permissions;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Permission Entity Definition
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Setter
@Getter
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of = {"id", "name"}, callSuper = false)
public class PermissionRefDTO extends DTOBase<Permissions> {

	@ApiModelProperty(position = 0)
	private Long id;

	@ApiModelProperty(position = 2)
	private String name;

	/**
	 * Default constructor
	 */
	public PermissionRefDTO() {
		super();
	}

	/**
	 * Entity based constructor
	 *
	 * @param entity
	 */
	public PermissionRefDTO(Permissions entity) {
		super(entity);
	}

	@Override
	public void fromEntity(Permissions entity) {
		// super.fromEntity(entity);

		id = entity.getId();
		name = entity.getName();
	}

}
