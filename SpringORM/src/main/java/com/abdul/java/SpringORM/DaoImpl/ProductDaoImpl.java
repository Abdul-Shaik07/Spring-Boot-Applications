package com.abdul.java.SpringORM.DaoImpl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.abdul.java.SpringORM.Dao.ProductDao;
import com.abdul.java.SpringORM.Entity.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private  HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	@Override
	public Product insertProduct(Product product) {
		return (Product) hibernateTemplate.save(product);
	}
	
}
