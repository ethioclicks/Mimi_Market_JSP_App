package com.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Modify {

	public List<ItemInfo> displayDetail() {
		
        ItemInfo itemInfo = new ItemInfo();
		List<ItemInfo> itemsInfo = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/itemdb", "root", "3465");
			String sql = "SELECT * FROM itemdb.itemtb WHERE Id = '" + itemInfo.getId() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			itemInfo = null;

			while (resultset.next()) {
				itemInfo = new ItemInfo();
				itemInfo.setId(resultset.getInt(1));
				itemInfo.setModelName(resultset.getString(2));
				itemInfo.setBrand(resultset.getString(3));
				itemInfo.setCondition(resultset.getString(4));
				itemInfo.setPrice(resultset.getDouble(5));
				itemInfo.setQuantity(resultset.getInt(6));
				itemInfo.setPostDate(resultset.getString(7));
				itemInfo.setDescription(resultset.getString(8));
				itemInfo.setImage(resultset.getString(9));
				itemsInfo.add(itemInfo);
			}

			return itemsInfo;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}