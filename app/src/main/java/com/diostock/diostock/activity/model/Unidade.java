//	C�digo do Cliente
//	descricao do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Unidade implements Parcelable,Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String unidade;
	private String descricao;
	public Unidade(Long id, String unidade, String descricao){
		this.id=id;
		this.unidade=unidade;
		this.descricao=descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Object getRowKey(Unidade object) {
		return this.getId();
	}
	public Unidade getRowData(String rowKey) {
		return this;
	}
	//http://stackoverflow.com/questions/28449427/reading-arraylist-of-custom-objects-from-getparcelablearraylistextra-returns-nul
	protected Unidade(Parcel in) {
		this.id = in.readLong();
		this.unidade = in.readString();
		this.descricao = in.readString();
	}
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeString(unidade);
		dest.writeString(descricao);
	}

	public static final Creator<Unidade> CREATOR = new Creator<Unidade>() {
		@Override
		public Unidade createFromParcel(Parcel in) {
			return new Unidade(in);
		}

		@Override
		public Unidade[] newArray(int size) {
			return new Unidade[size];
		}
	};
}
