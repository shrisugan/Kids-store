package com.niit.dao;

	import java.util.List;
	
import com.niit.model.Category;


	public interface CategoryDAO
	{

	 List<Category> getAllCategoryDetails();

		Category getCategoryDetail(int id);
		
		void updateCategoryDetail(Category obj);
		
		void addCategory(Category obj);
		
		void deleteProduct(Category entity);

	

}
