//	C�digo do Cliente
//	Nome do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Saida implements Parcelable,Serializable {
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String codigo;
	private String nome;
	private Date data;
	private Cliente cliente;
	private Item item;
	private Estoque estoque;
	private Long nota;
	private BigDecimal quantidade;
	private BigDecimal unitario;
	public Saida(Long id, String codigo, String nome,Date data,Cliente cliente,Item item,Estoque estoque,Long nota,BigDecimal quantidade,BigDecimal unitario){
		this.setId(id);
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setData(data);
		this.setCliente(cliente);
		this.setItem(item);
		this.setEstoque(estoque);
		this.setNota(nota);
		this.setQuantidade(quantidade);
		this.setUnitario(unitario);
	}

	/**
	 *
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static Creator<Saida> getCREATOR() {
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
	public Object getRowKey(Saida object) {
		return this.getId();
	}
	public Saida getRowData(String rowKey) {
		return this;
	}
	//http://stackoverflow.com/questions/28449427/reading-arraylist-of-custom-objects-from-getparcelablearraylistextra-returns-nul
	protected Saida(Parcel in) {
		this.setId(in.readLong());
		this.setCodigo(in.readString());
		this.setNome(in.readString());
		try {
			String dat = in.readString();
			this.setData(dat==null?null:new SimpleDateFormat("dd/MM/yyyy").parse(dat));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setCliente((Cliente) in.readParcelable(Cliente.class.getClassLoader()));
		this.setItem((Item) in.readParcelable(Item.class.getClassLoader()));
		this.setEstoque((Estoque) in.readParcelable(Estoque.class.getClassLoader()));
		this.setNota(in.readLong());
		String quant = in.readString();
		this.setQuantidade(new BigDecimal(quant==null?"0":quant));
		String unit = in.readString();
		this.setUnitario(new BigDecimal(unit==null?"0":unit));
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
		dest.writeString(getData() ==null?null:new SimpleDateFormat("dd/MM/yyyy").format(getData()));
		dest.writeParcelable(getCliente(),flags);
		dest.writeParcelable(getItem(),flags);
		dest.writeParcelable(getEstoque(),flags);
		dest.writeLong(getNota());
		dest.writeString(getQuantidade() ==null?"0": getQuantidade().toString());
		dest.writeString(getUnitario() ==null?"0": getUnitario().toString());
	}

	private static final Creator<Saida> CREATOR = new Creator<Saida>() {
		@Override
		public Saida createFromParcel(Parcel in) {
			return new Saida(in);
		}

		@Override
		public Saida[] newArray(int size) {
			return new Saida[size];
		}
	};

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getUnitario() {
		return unitario;
	}

	public void setUnitario(BigDecimal unitario) {
		this.unitario = unitario;
	}
}
