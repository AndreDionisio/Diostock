//	C�digo do Cliente
//	Nome do Cliente
package com.diostock.diostock.activity.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Estoque implements Parcelable,Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -2540515546630918880L;
	private Long id;

	private String local;

	private String corredor;

	private String prateleira;

	private String andar;

	private String box;


	private Unidade unidade;

	private BigDecimal saldo;
	private String nome;
	public Estoque(Long id, String local,String corredor,String prateleira,String andar,String box, Unidade unidade,BigDecimal saldo, String nome){
		this.setId(id);
		this.setLocal(local);
		this.setCorredor(corredor);
		this.setPrateleira(prateleira);
		this.setAndar(andar);
		this.setBox(box);
		this.setUnidade(unidade);
		this.setSaldo(saldo);
		this.setNome(nome);
	}

    public static Creator<Estoque> getCREATOR() {
        return CREATOR;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Object getRowKey(Estoque object) {
		return this.getId();
	}
	public Estoque getRowData(String rowKey) {
		return this;
	}
	protected Estoque(Parcel in) {
		this.setId(in.readLong());
		this.setLocal(in.readString());
        this.setCorredor(in.readString());
        this.setPrateleira(in.readString());
        this.setAndar(in.readString());
        this.setBox(in.readString());
        this.setUnidade((Unidade) in.readParcelable(Unidade.class.getClassLoader()));
        String value = in.readString();
        this.setSaldo(new BigDecimal(value==null?"0":value));
		this.setNome(in.readString());
	}
	@Override
	public int describeContents() {
		return 0;
	}
    /*
    public void writeToParcel(final Parcel dest, final int flags) {
        ... ...
        dest.writeParcelable(bar, flags);
        ... ...
    }*/
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(getId());
        dest.writeString(getLocal());
        dest.writeString(getCorredor());
        dest.writeString(getPrateleira());
        dest.writeString(getAndar());
        dest.writeString(getBox());
        dest.writeParcelable(getUnidade(),flags);
        dest.writeString(getSaldo()==null?"0":getSaldo().toString());
		dest.writeString(getNome());
	}

	private static final Creator<Estoque> CREATOR = new Creator<Estoque>() {
		@Override
		public Estoque createFromParcel(Parcel in) {
			return new Estoque(in);
		}

		@Override
		public Estoque[] newArray(int size) {
			return new Estoque[size];
		}
	};

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
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
}
