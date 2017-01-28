//	C�digo do Cliente
//	Nome do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Cliente implements Parcelable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String codigo;
	private String nome;
	public Cliente(Long id){
		this.id=id;
	}
	public Cliente(Long id,String codigo,String nome){
		this.id=id;
		this.codigo=codigo;
		this.nome=nome;
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
	public Object getRowKey(Cliente object) {
		return this.getId();
	}
	public Cliente getRowData(String rowKey) {
		return this;
	}
	//http://stackoverflow.com/questions/28449427/reading-arraylist-of-custom-objects-from-getparcelablearraylistextra-returns-nul
	protected Cliente(Parcel in) {
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

	public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
		@Override
		public Cliente createFromParcel(Parcel in) {
			return new Cliente(in);
		}

		@Override
		public Cliente[] newArray(int size) {
			return new Cliente[size];
		}
	};
}
