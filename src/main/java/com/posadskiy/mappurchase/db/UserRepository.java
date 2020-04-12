package com.posadskiy.mappurchase.db;

import com.posadskiy.mappurchase.db.model.DbUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DbUser, Integer> {
}
