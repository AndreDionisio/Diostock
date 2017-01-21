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

public class Entrada implements Parcelable,Serializable {
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;
	private String codigo;
	private String nome;
	private Date data;
	private Fornecedor fornecedor;
	private Item item;
	private Estoque estoque;
	private Long nota;
	private BigDecimal quantidade;
	private BigDecimal unitario;
	public Entrada(Long id, String codigo, String nome,Date data,Fornecedor fornecedor,Item item,Estoque estoque,Long nota,BigDecimal quantidade,BigDecimal unitario){
		this.setId(id);
		this.setCodigo(codigo);
		this.setNome(nome);
        this.setData(data);
        this.setFornecedor(fornecedor);
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

    public static Creator<Entrada> getCREATOR() {
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
	public Object getRowKey(Entrada object) {
		return this.getId();
	}
	public Entrada getRowData(String rowKey) {
		return this;
	}
	protected Entrada(Parcel in) {
		this.setId(in.readLong());
		this.setCodigo(in.readString());
		this.setNome(in.readString());
        try {
            String dat = in.readString();
            this.setData(dat==null?null:new SimpleDateFormat("dd/MM/yyyy").parse(dat));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setFornecedor((Fornecedor) in.readParcelable(Fornecedor.class.getClassLoader()));
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
        dest.writeParcelable(getFornecedor(),flags);
        dest.writeParcelable(getItem(),flags);
        dest.writeParcelable(getEstoque(),flags);
        dest.writeLong(getNota());
        dest.writeString(getQuantidade() ==null?"0": getQuantidade().toString());
        dest.writeString(getUnitario() ==null?"0": getUnitario().toString());
	}

	private static final Creator<Entrada> CREATOR = new Creator<Entrada>() {
		@Override
		public Entrada createFromParcel(Parcel in) {
			return new Entrada(in);
		}

		@Override
		public Entrada[] newArray(int size) {
			return new Entrada[size];
		}
	};

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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
