//	C�digo do Cliente
//	Nome do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fornecedor implements Parcelable,Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String codigo;
	private String nome;
	public Fornecedor(Long id, String codigo, String nome){
		this.id=id;
		this.codigo=codigo;
		this.nome=nome;
	}
	public Fornecedor(Long id){
		this.id=id;
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
		return serialVersionUID;
	}
	public Object getRowKey(Fornecedor object) {
		return this.getId();
	}
	public Fornecedor getRowData(String rowKey) {
		return this;
	}
	//http://stackoverflow.com/questions/28449427/reading-arraylist-of-custom-objects-from-getparcelablearraylistextra-returns-nul
	protected Fornecedor(Parcel in) {
		this.id = in.readLong();
		this.codigo = in.readString();
		this.nome = in.readString();
	}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeString(codigo);
		dest.writeString(nome);
	}

	public static final Creator<Fornecedor> CREATOR = new Creator<Fornecedor>() {
		@Override
		public Fornecedor createFromParcel(Parcel in) {
			return new Fornecedor(in);
		}

		@Override
		public Fornecedor[] newArray(int size) {
			return new Fornecedor[size];
		}
	};
}
