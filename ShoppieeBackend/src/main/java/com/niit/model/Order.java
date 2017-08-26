package com.niit.model;

	import java.io.Serializable;
	import javax.persistence.*;

	@Entity
	@Table(name="OrderDetails",uniqueConstraints = {
			@UniqueConstraint(columnNames = "order_Id")})
	public class Order implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@Column(name="order_Id")
		private Integer orderId;
		@Column(name="order_User_Id")
		private String orderUserId;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="userId")
		private User orderUserDetails;
		@Column(name="order_Payment")
		private String orderPayment;
		@Column(name="order_Total")
		private double orderTotal;
		
		public Order()
		{
			
		}

		public Order(Integer orderId, String orderUserId, User orderUserDetails, String orderPayment,
				double orderTotal) {
			super();
			this.orderId = orderId;
			this.orderUserId = orderUserId;
			this.orderUserDetails = orderUserDetails;
			this.orderPayment = orderPayment;
			this.orderTotal = orderTotal;
		}

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public String getOrderUserId() {
			return orderUserId;
		}

		public void setOrderUserId(String orderUserId) {
			this.orderUserId = orderUserId;
		}

		public User getOrderUserDetails() {
			return orderUserDetails;
		}

		public void setOrderUserDetails(User orderUserDetails) {
			this.orderUserDetails = orderUserDetails;
		}

		public String getOrderPayment() {
			return orderPayment;
		}

		public void setOrderPayment(String orderPayment) {
			this.orderPayment = orderPayment;
		}

		public double getOrderTotal() {
			return orderTotal;
		}

		public void setOrderTotal(double orderTotal) {
			this.orderTotal = orderTotal;
		}
		
}
