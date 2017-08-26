package com.niit.model;

	import java.io.Serializable;
	import java.util.Set;

	import javax.persistence.*;

	@Entity
	@Table(name="Category")
	
	public class Category implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		@Column(name="c_id")
		private int categoryId;
		@Column(name="c_name")
		private String categoryName;

		@OneToMany(targetEntity=Product.class, fetch = FetchType.EAGER, mappedBy = "prodCategory", cascade=CascadeType.ALL)
		@Column(name="category_Products")
		private Set<Product> categoryProducts;/*=new HashSet<Product>(0);*/

		public Category()
		{
			super();
		}

		public Category(int categoryId, String categoryName, Set<Product> categoryProducts) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.categoryProducts = categoryProducts;
		}

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public Set<Product> getCategoryProducts() {
			return categoryProducts;
		}

		public void setCategoryProducts(Set<Product> categoryProducts) {
			this.categoryProducts = categoryProducts;
		}
		
		

}
