package com.nf.flower.entity.commodity;

import java.math.BigDecimal;
import java.util.List;


public class Cart {
	private  Integer cartMasterId;
	private Integer userId;
	private BigDecimal totalPrice;

	private List<CartItem> list;

	public Integer getCartMasterId() {
		return cartMasterId;
	}

	public void setCartMasterId(Integer cartMasterId) {
		this.cartMasterId = cartMasterId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getList() {
		return list;
	}

	public void setList(List<CartItem> list) {
		this.list = list;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"cartMasterId=" + cartMasterId +
				", userId=" + userId +
				", totalPrice=" + totalPrice +
				", list=" + list +
				'}';
	}


	/**
	 * 重构getPrice方法
	 * 
	 * @return
	 */
//	public float getFlowerPrice() {
//
//		// 购物车总价格
//		float totalprice = 0;
//		// 迭代购物车中所有购物项, 相加获取购物车总价
//		for (Map.Entry<String, CartItem> me : map.entrySet()) {
//			CartItem item = me.getValue();
//			totalprice += item.getFlowerPrice();
//		}
//		return totalprice;
//	}


}
