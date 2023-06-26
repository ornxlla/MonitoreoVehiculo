package monitoreo;

import java.util.HashSet;

public class Mapa {	
	private HashSet<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	private String ciudad;
	
	public Mapa(String ciudad) {
		this.ciudad = ciudad;
	}

	public HashSet<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Integer obtenerLaCantidadDeVehiculosEnElMapa() {
		return this.vehiculos.size();
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}

	public Boolean NohayCoalisión() throws SeGeneroColision {
		for(Vehiculo v:vehiculos) {
			for(Vehiculo v2:vehiculos) {
				if((v.getLatitud().compareTo(v2.getLatitud()) > 0 && v.getLongitud().compareTo(v2.getLongitud()) > 0) ||
						(v.getLatitud().compareTo(v2.getLatitud()) < 0 && v.getLongitud().compareTo(v2.getLongitud()) < 0)	) {
					return true;
				}
			}
		}
		throw new SeGeneroColision("Hay colisión entre vehículos");
	}
	
	
	
}
