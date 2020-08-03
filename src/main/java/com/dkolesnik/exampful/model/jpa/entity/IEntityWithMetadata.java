package com.dkolesnik.exampful.model.jpa.entity;

public interface IEntityWithMetadata extends IEntityWithDates {
	Users getCreatedBy();
	Users getUpdatedBy();
}
