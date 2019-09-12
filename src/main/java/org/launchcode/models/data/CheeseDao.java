package org.launchcode.models.data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 * DAO- data access object
 */
@Repository
@Transactional
//can't use primitive type must use Integer
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}
