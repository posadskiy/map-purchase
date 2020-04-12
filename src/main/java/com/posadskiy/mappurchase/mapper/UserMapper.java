package com.posadskiy.mappurchase.mapper;

import com.posadskiy.mappurchase.db.model.DbUser;
import com.posadskiy.mappurchase.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
public interface UserMapper {

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "email", target = "email"),
	})
	User mapToDto(DbUser dbUser);

	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "email", target = "email", qualifiedByName = "emailQualifier"),
	})
	DbUser mapFromDto(User user);

	@Named("emailQualifier")
	default String emailQualifier(String email) {
		return email.toLowerCase();
	}

}
