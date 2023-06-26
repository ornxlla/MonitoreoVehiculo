package monitoreo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonitoreoTest {

	@Test
	public void queSePuedaCrearUnAuto() {
		Vehiculo auto = new Auto("JJZ526", 5, 240, 41.40338, 2.17403);
		assertEquals("JJZ526", auto.getPatente());
		assertEquals((Integer)5, auto.getCantidadMaxPasajeros());
		assertEquals((Integer)240, auto.getVelocidadMaxima());
		assertEquals((Double)41.40338, auto.getLatitud());
		assertEquals((Double)2.17403, auto.getLongitud());
	}

	@Test
	public void queSePuedaCrearUnaMoto() {
		Vehiculo moto = new Moto("094AB5", 2, 200, 41.40338, 2.17403);
		assertEquals("094AB5", moto.getPatente());
		assertEquals((Integer)2, moto.getCantidadMaxPasajeros());
		assertEquals((Integer)200, moto.getVelocidadMaxima());
		assertEquals((Double)41.40338, moto.getLatitud());
		assertEquals((Double)2.17403, moto.getLongitud());
	}
	
	@Test
	public void queSePuedaCrearUnaBicicleta() {
		Vehiculo bici = new Bicicleta(null, 1, null, 41.40338, 2.17403);
		assertEquals((Integer)1, bici.getCantidadMaxPasajeros());
		assertEquals((Double)41.40338, bici.getLatitud());
		assertEquals((Double)2.17403, bici.getLongitud());
	}
	
	@Test
	public void queSePuedanIncorporarDistintosVehiculos() throws SeGeneroColision {
		Mapa actual = new Mapa("Buenos Aires");
		Vehiculo auto = new Auto("JJZ526", 5, 240, 45.40338, 5.17403);
		Vehiculo moto = new Moto("094AB5", 2, 200, 44.40338, 1.17403);
		Vehiculo bici = new Bicicleta(null, 1, null, 41.40338, 4.17403);
		
		actual.agregarVehiculo(auto);
		actual.agregarVehiculo(bici);
		actual.agregarVehiculo(moto);
		assertEquals((Integer)3, actual.obtenerLaCantidadDeVehiculosEnElMapa());
		assertTrue(actual.NohayCoalisión());
	}
	
	
	@Test (expected = SeGeneroColision.class)
	public void queChoquenDosVehiculos() throws SeGeneroColision {
		Mapa actual = new Mapa("Buenos Aires");
		Vehiculo auto = new Auto("JJZ526", 5, 240, 43.40338, 1.17403);
		Vehiculo moto = new Moto("094AB5", 2, 200, 45.40338, 5.17403);
		Vehiculo bici = new Bicicleta(null, 1, null, 41.40338, 4.17403);
		
		actual.agregarVehiculo(bici);
		actual.agregarVehiculo(moto);
		actual.agregarVehiculo(auto);
		
		moto.actualizarCordenadas(43.40338, 1.17403);
		assertFalse(actual.NohayCoalisión());
		
	}
}
