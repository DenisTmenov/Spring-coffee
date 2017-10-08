package com.denis.coffeebackend.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.denis.coffeebackend.dao.CoffeeOrderItemDAOInterface;
import com.denis.coffeebackend.entity.CoffeeOrderItemEntity;
import com.denis.coffeebackend.exception.EntityException;

public class CoffeeOrderItemDAO implements CoffeeOrderItemDAOInterface {

	@Override
	public void save(CoffeeOrderItemEntity bean) throws EntityException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// connection = ConnectionPool.getInstance().getConnection();
			statement = connection.prepareStatement(" INSERT INTO coffee_order_item (type_id, order_id, quantity)" + " values (?, ?, ?)");

			statement.setInt(1, bean.getTypeId());
			statement.setInt(2, bean.getOrderId());
			statement.setInt(3, bean.getQuantity());

			statement.execute();

		} catch (SQLException e) {
			throw new EntityException("Exception with save CoffeeOrderItem to DB!!!", e);
		} finally {
			// ConnectionPool.closeDbResources(connection, statement);
		}
	}

}
