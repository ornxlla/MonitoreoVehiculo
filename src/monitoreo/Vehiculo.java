package monitoreo;

import java.util.Objects;

public class Vehiculo{

	protected String patente;
	protected Integer cantidadMaxPasajeros;
	protected Integer velocidadMaxima;
	protected Double latitud;
	protected Double longitud;

	public Vehiculo(String patente, Integer cantidadMaxPasajeros, Integer velocidadMaxima, Double latitud, Double longitud) {
		this.patente = patente;
		this.cantidadMaxPasajeros = cantidadMaxPasajeros;
		this.velocidadMaxima = velocidadMaxima;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getPatente() {
		return patente;
	}

	public Integer getCantidadMaxPasajeros() {
		return cantidadMaxPasajeros;
	}

	public Integer getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public Double getLatitud() {
		return latitud;
	}

	public Double getLongitud() {
		return longitud;
	}
	
	
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public void actualizarCordenadas(Double latitud, Double longitud) {
		this.setLatitud(latitud);
		this.setLongitud(longitud);
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
	}

	
}
