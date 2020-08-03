package com.dkolesnik.exampful.model.jpa.entity;

import java.util.Date;

public interface IEntityWithDates {
	Date getCreatedAt();
	Date getUpdatedAt();
}
