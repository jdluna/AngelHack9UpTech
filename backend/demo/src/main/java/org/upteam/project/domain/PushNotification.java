package org.upteam.project.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PushNotifications")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PushNotification implements Serializable {
	
	private static final long serialVersionUID = -4339821015467396328L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "identificador")
	private String identificador;
	@Column
	private double indicadorMetano;
	@Column
	private double indicadorAmoniaco;
	@Column
	private double indicadorTemperatura;
	@Column
	private double indicadorHumedad;
	@Column
	private double indicadorCrecimiento;
	@Column
	private double indicadorCo2;
	@Column
	private double indicadorLuz;
	@Column
	private BigDecimal longitud;
	@Column
	private BigDecimal latitud;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp fechaRegistro;
	
	public PushNotification(){
		
	}
	
	public PushNotification(long id, String identificador, Float indicadorMetano, Float indicadorAmoniaco,
			Float indicadorTemperatura, Float indicadorHumedad, Float indicadorCrecimiento, Float indicadorCo2,
			Float indicadorLuz, BigDecimal longitud, BigDecimal latitud, Timestamp fechaRegistro) {
		this.id = id;
		this.identificador = identificador;
		this.indicadorMetano = indicadorMetano;
		this.indicadorAmoniaco = indicadorAmoniaco;
		this.indicadorTemperatura = indicadorTemperatura;
		this.indicadorHumedad = indicadorHumedad;
		this.indicadorCrecimiento = indicadorCrecimiento;
		this.indicadorCo2 = indicadorCo2;
		this.indicadorLuz = indicadorLuz;
		this.longitud = longitud;
		this.latitud = latitud;
		this.fechaRegistro = fechaRegistro;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public double getIndicadorMetano() {
		return indicadorMetano;
	}

	public void setIndicadorMetano(double indicadorMetano) {
		this.indicadorMetano = indicadorMetano;
	}

	public double getIndicadorAmoniaco() {
		return indicadorAmoniaco;
	}

	public void setIndicadorAmoniaco(double indicadorAmoniaco) {
		this.indicadorAmoniaco = indicadorAmoniaco;
	}

	public double getIndicadorTemperatura() {
		return indicadorTemperatura;
	}

	public void setIndicadorTemperatura(double indicadorTemperatura) {
		this.indicadorTemperatura = indicadorTemperatura;
	}

	public double getIndicadorHumedad() {
		return indicadorHumedad;
	}

	public void setIndicadorHumedad(double indicadorHumedad) {
		this.indicadorHumedad = indicadorHumedad;
	}

	public double getIndicadorCrecimiento() {
		return indicadorCrecimiento;
	}

	public void setIndicadorCrecimiento(double indicadorCrecimiento) {
		this.indicadorCrecimiento = indicadorCrecimiento;
	}

	public double getIndicadorCo2() {
		return indicadorCo2;
	}

	public void setIndicadorCo2(double indicadorCo2) {
		this.indicadorCo2 = indicadorCo2;
	}

	public double getIndicadorLuz() {
		return indicadorLuz;
	}

	public void setIndicadorLuz(double indicadorLuz) {
		this.indicadorLuz = indicadorLuz;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
    public String toString() {
        return "PushNotification{" +
                "id=" + id +
                ", identificador='" + identificador + '\'' +
                ", indicadorMetano=" + indicadorMetano +
                ", indicadorAmoniaco=" + indicadorAmoniaco +
                ", indicadorTemperatura=" + indicadorTemperatura +
                ", indicadorHumedad=" + indicadorHumedad +
                ", indicadorCrecimiento=" + indicadorCrecimiento +
                ", indicadorCo2=" + indicadorCo2 +
                ", indicadorLuz=" + indicadorLuz +
                ", fechaRegistro=" + fechaRegistro.toString() +
                '}';
    }

}
