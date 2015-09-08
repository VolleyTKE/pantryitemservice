package com.cvg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvg.model.Item;

public class DAOImpl implements DAO {
    static{
        //public static void main(java.lang.String[] args) {
        // open    connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load Driver Class");
        }
    }

    //private Item item;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory",
                "root", "C135036c");
    }

    private void closeConnection(Connection connection) {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
    
    /* (non-Javadoc)
	 * @see com.cvg.dao.DAO#getAllItems()
	 */
    
	/* (non-Javadoc)
	 * @see com.cvg.dao.DAO#getAllItems()
	 */
	@Override
	public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();

        String sql = "select * from items";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            	Item item = new Item();            	            	
            	item.setItemId(rs.getInt("item_id"));
            	item.setUpc(rs.getInt("upc"));
            	item.setItemName(rs.getString("item_name"));
            	item.setCompany(rs.getString("company"));
            	item.setDateEntered(rs.getInt("date_entered"));
            	item.setExpirationDate(rs.getInt("expiration_date"));
            	item.setQuantity(rs.getInt("quantity"));
            	items.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return items;
    }
    
	
    /* (non-Javadoc)
	 * @see com.cvg.dao.DAO#getItemByID(int)
	 */
    @Override
	public Item getItemByID(int itemId) {
        Item item = new Item();

        String sql = "select * from items WHERE item_id = ?";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()) {
    			item.setItemId(rs.getInt("item_id"));
    			item.setUpc(rs.getInt("upc"));
    			item.setItemName(rs.getString("item_name"));
    			item.setCompany(rs.getString("company"));
    			item.setDateEntered(rs.getInt("date_entered"));
    			System.out.println(item.toString());
    	    	item.setExpirationDate(rs.getInt("expiration_date"));
    	    	item.setQuantity(rs.getInt("quantity"));
    		}
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return item;
    }
    
    public void addItem(Item item) {
        Connection connection = null;
        try {
        	connection = getConnection();
        	PreparedStatement statement = connection
                    .prepareStatement("insert into `ITEMS`"
                    		+ "( `upc`, `item_name`, `company`, `date_entered`, `expiration_date`, `quantity`) "
                    		+ "values (?, ?, ?, ?, ?, ?)");

        	statement.setInt(1, item.getUpc());
            statement.setString(2, item.getItemName());
            statement.setString(3, item.getCompany());
            statement.setInt(4, item.getDateEntered());
            statement.setInt(5, item.getExpirationDate());
            statement.setInt(6, item.getQuantity());
            System.out.println(item.toString());
            System.out.println(statement.toString());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                item.setItemId(generatedKeys.getInt(1));//get col by int value
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }
    
}
