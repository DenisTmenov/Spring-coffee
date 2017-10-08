package com.denis.coffeebackend.dao.mysql;

import java.util.List;

import com.denis.coffeebackend.dao.CoffeeTypeDAOInterface;
import com.denis.coffeebackend.entity.CoffeeTypeEntity;
import com.denis.coffeebackend.exception.EntityException;

public class CoffeeTypeDAO implements CoffeeTypeDAOInterface {

	@Override
	public void save(CoffeeTypeEntity bean) throws EntityException {
	}

	@Override
	public void update(CoffeeTypeEntity bean) throws EntityException {
	}

	@Override
	public void remove(Integer idUser) throws EntityException {
	}

	@Override
	public List<CoffeeTypeEntity> loadAllCoffeeType() throws EntityException {
		// Connection connection = null;
		// PreparedStatement statement = null;
		// ResultSet set = null;
		//
		// List<CoffeeTypeEntity> result = new ArrayList<CoffeeTypeEntity>();
		//
		// try {
		// connection = ConnectionPool.getInstance().getConnection();
		// statement = connection.prepareStatement("SELECT * FROM coffee_type");
		// set = statement.executeQuery();
		//
		// while (set.next()) {
		// CoffeeTypeEntity entity = CreatorEntity.createCoffeeTypeEntity(set);
		// result.add(entity);
		// }
		// } catch (SQLException e) {
		// throw new EntityException("Exception in loadAllCoffeeType().", e);
		// } finally {
		// ConnectionPool.closeDbResources(connection, statement, set);
		// }
		//
		// return result;

		return null;

	}

}
