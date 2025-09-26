package com.abdul.java.SpringJDBC.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.abdul.java.SpringJDBC.Dao.ProductDao;
import com.abdul.java.SpringJDBC.Entity.Product;

public class ProductDaoImpl implements ProductDao {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//to retrieve the single data from the table
	/*@Override
	public Product getProductQuery(int pId) {
		RowMapper<Product> rowMapper = new RowMapper<Product>() {
			
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setpId(rs.getLong(1));
				product.setpName(rs.getString(2));
				product.setpPrice(rs.getDouble(3));
				return product;
			}
		};
		String query = "select * from product where pId= ?";
		return jdbcTemplate.queryForObject(query, rowMapper, pId);
	}*/

	@Override
	public List<Product> getProductTable() {
		RowMapper<Product> rowMapper = new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setpId(rs.getLong(1));
				product.setpName(rs.getString(2));
				product.setpPrice(rs.getDouble(3));
				return product;
			}
		};
		String allTheData = "select * from product";
		return jdbcTemplate.query(allTheData, rowMapper);
	}

	
	
	//create a table 
	/*@Override
	public Product createProduct(Product product) {
		String query = "create table product(pId int primary key, pName varchar(20) not null, pPrice decimal(5,2) not null)";
		int update = jdbcTemplate.update(query);
		System.out.println("Table has been created");
		return product;
		
	}*/
	//insert data in the table
	/*@Override
	public Product insertProductValues(Product product) {
		String insert = "insert into product values(?, ?, ?)";
		int update = jdbcTemplate.update(insert, product.getpId(), product.getpName(), product.getpPrice());	
		System.out.println("Values are inserted successfully");
		return product;
	}*/
}
