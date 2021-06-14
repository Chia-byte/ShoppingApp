package com.shop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType {

	@Id
	@Column(name = "id_type")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;

	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy = "type")
	private List<Product> set;

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getList() {
		return set;
	}

	public void setList(List<Product> set) {
		this.set = set;
	}

}
