package com.niit.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

	@Entity
	@Table(name="Supplier")
	
	public class Supplier implements Serializable
	{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	  @Id
	  @GeneratedValue
	  @Column(name="supplierId")
	  private int supplierId;
	  @Column(name="supplierName")
	  private String supplierName;
	  @Column(name="supplier_products")
	  @OneToMany(targetEntity=Product.class, fetch = FetchType.EAGER, mappedBy = "prodSupplier", cascade=CascadeType.ALL)
	  private Set<Product> supplierproducts=new HashSet<Product>(0);
	  
	
	  public Supplier()
		{
			super();
		}


	public Supplier(int supplierId, String supplierName, Set<Product> supplierproducts) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierproducts = supplierproducts;
	}
	
	
	
	public Supplier(int supplierId, String supplierName) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}


	//Getter and Setter methods for Product Quantity
	  public void setSupplierId(int supplierId)
		{
			this.supplierId=supplierId;
		}
	  @Column(name = "supplier_Id", unique = true, nullable = false)
	  public int getSupplierId()
	  {
	  	return supplierId;
	  }
	  
	  //Getter and Setter methods for Product Category
	  public void setSupplierName(String supplierName)
		{
			this.supplierName=supplierName;
		}
	  public String getSupplierName()
	  {
	  	return supplierName;
	  }
	  
	  //Getter and Setter methods for Product Supplier
	 
	  public void setSupplierProducts(Set<Product> supplierproducts)
		{
			this.supplierproducts=supplierproducts;
		}
	  
	  
	  public Set<Product> getSupplierProducts()
	  {
	  	return supplierproducts;
	  }

}
