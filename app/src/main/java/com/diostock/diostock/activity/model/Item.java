//	C�digo do Cliente
//	Nome do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Parcelable,Serializable {
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String codigo;
	private String nome;
	private String descricao;
	private Unidade unidade;
	private BigDecimal saldo;
	private Estoque estoque;

	public Item(Long id, String codigo, String nome,String descricao,Unidade unidade,BigDecimal saldo,Estoque estoque ){
		this.setId(id);
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setUnidade(unidade);
		this.setSaldo(saldo);
		this.setEstoque(estoque);
	}
	public Item(Long id){
		this.setId(id);
	}
				/**
                 *
                 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static Creator<Item> getCREATOR() {
		return CREATOR;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return getSerialVersionUID();
	}
	public Object getRowKey(Item object) {
		return this.getId();
	}
	public Item getRowData(String rowKey) {
		return this;
	}
	//http://stackoverflow.com/questions/28449427/reading-arraylist-of-custom-objects-from-getparcelablearraylistextra-returns-nul
	protected Item(Parcel in) {
		this.setId(in.readLong());
		this.setCodigo(in.readString());
		this.setNome(in.readString());
		this.setDescricao(in.readString());
		this.setUnidade((Unidade) in.readParcelable(Unidade.class.getClassLoader()));
		String value = in.readString();
		this.setSaldo(new BigDecimal(value==null?"0":value));
		this.setEstoque((Estoque) in.readParcelable(Estoque.class.getClassLoader()));
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(getId());
		dest.writeString(getCodigo());
		dest.writeString(getNome());
		dest.writeString(getDescricao());
		dest.writeParcelable(getUnidade(),flags);
		dest.writeString(getSaldo() ==null?"0": getSaldo().toString());
		dest.writeParcelable(getEstoque(),flags);
	}

	private static final Creator<Item> CREATOR = new Creator<Item>() {
		@Override
		public Item createFromParcel(Parcel in) {
			return new Item(in);
		}

		@Override
		public Item[] newArray(int size) {
			return new Item[size];
		}
	};

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
