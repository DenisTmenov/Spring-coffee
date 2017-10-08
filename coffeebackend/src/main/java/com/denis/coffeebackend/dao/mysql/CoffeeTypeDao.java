package com.denis.coffeebackend.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import com.denis.coffeebackend.dao.CoffeeTypeDaoInterface;
import com.denis.coffeebackend.entity.CoffeeTypeEntity;
import com.denis.coffeebackend.exception.EntityException;

public class CoffeeTypeDao implements CoffeeTypeDaoInterface {

	private static List<CoffeeTypeEntity> coffeeTypes = new ArrayList<>();

	static {
		CoffeeTypeEntity coffeeType = new CoffeeTypeEntity();

		coffeeType.setId(1);
		coffeeType.setTypeName("My coffee");
		coffeeType.setPrice(12.0);
		coffeeType.setDisabled('N');

		coffeeTypes.add(coffeeType);

		coffeeType = new CoffeeTypeEntity();

		coffeeType.setId(2);
		coffeeType.setTypeName("My coffee BLACK");
		coffeeType.setPrice(20.0);
		coffeeType.setDisabled('N');

		coffeeTypes.add(coffeeType);
	}

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

		return coffeeTypes;

	}

}
