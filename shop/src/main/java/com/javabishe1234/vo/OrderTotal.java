package com.javabishe1234.vo;

import lombok.Data;

@Data

public class OrderTotal {
	
	private Long total;
	
	private Long isNotSendtotal;
	
	private Long isNotReviceOrdertotal;
	
	private Long isNotPayOrdertotal;
	
	private Long isNotCommentOrdertotal;

	public OrderTotal(Long total,  Long isNotSendtotal, Long isNotReviceOrdertotal,
			Long isNotPayOrdertotal, Long isNotCommentOrdertotal) {
		super();
		this.total = total;
		this.isNotSendtotal = isNotSendtotal;
		this.isNotReviceOrdertotal = isNotReviceOrdertotal;
		this.isNotPayOrdertotal = isNotPayOrdertotal;
		this.isNotCommentOrdertotal = isNotCommentOrdertotal;
	}

	public OrderTotal() {
		super();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getIsNotSendtotal() {
		return isNotSendtotal;
	}

	public void setIsNotSendtotal(Long isNotSendtotal) {
		this.isNotSendtotal = isNotSendtotal;
	}

	public Long getIsNotReviceOrdertotal() {
		return isNotReviceOrdertotal;
	}

	public void setIsNotReviceOrdertotal(Long isNotReviceOrdertotal) {
		this.isNotReviceOrdertotal = isNotReviceOrdertotal;
	}

	public Long getIsNotPayOrdertotal() {
		return isNotPayOrdertotal;
	}

	public void setIsNotPayOrdertotal(Long isNotPayOrdertotal) {
		this.isNotPayOrdertotal = isNotPayOrdertotal;
	}

	public Long getIsNotCommentOrdertotal() {
		return isNotCommentOrdertotal;
	}

	public void setIsNotCommentOrdertotal(Long isNotCommentOrdertotal) {
		this.isNotCommentOrdertotal = isNotCommentOrdertotal;
	}
	
	
}
