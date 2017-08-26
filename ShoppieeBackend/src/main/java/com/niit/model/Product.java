package com.niit.model;

	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="Product")
	public class Product implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		@Column(name="prod_Id")
		private int prodId;
		@Column(name="prod_Name")
		private String prodName;
		@Column(name="prod_Description")
		private String prodDescription;
		@Column(name="prod_Price")
		private int prodPrice;
		/*@Column(name="prod_Quantity")
		private String prodQuantity;*/
		@ManyToOne
		@JoinColumn(name="categoryId")
		private Category prodCategory;
		@ManyToOne
		@JoinColumn(name="supplierId")
		private Supplier prodSupplier;
		@Column(name="image") private String image;
		
		public Product()
		{
			super();
		}

		public Product(int prodId, String prodName, String prodDescription, int prodPrice, Category prodCategory, Supplier prodSupplier) {
			super();
			this.prodId = prodId;
			this.prodName = prodName;
			this.prodDescription = prodDescription;
			this.prodPrice = prodPrice;
			/*this.prodQuantity = prodQuantity;*/
			this.prodCategory = prodCategory;
			this.prodSupplier = prodSupplier;
			this.image = image;
		}

		public int getProdId() {
			return prodId;
		}

		public void setProdId(int prodId) {
			this.prodId = prodId;
		}


		public String getProdName() {
			return prodName;
		}

		public void setProdName(String prodName) {
			this.prodName = prodName;
		}

		public String getProdDescription() {
			return prodDescription;
		}

		public void setProdDescription(String prodDescription) {
			this.prodDescription = prodDescription;
		}

		public int getProdPrice() {
			return prodPrice;
		}

		public void setProdPrice(int prodPrice) {
			this.prodPrice = prodPrice;
		}

		/*public String getProdQuantity() {
			return prodQuantity;
		}

		public void setProdQuantity(String prodQuantity) {
			this.prodQuantity = prodQuantity;
		}*/

		public Category getProdCategory() {
			return prodCategory;
		}

		public void setProdCategory(Category prodCategory) {
			this.prodCategory = prodCategory;
		}

		public Supplier getProdSupplier() {
			return prodSupplier;
		}

		public void setProdSupplier(Supplier prodSupplier) {
			this.prodSupplier = prodSupplier;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
		
		
		

}
