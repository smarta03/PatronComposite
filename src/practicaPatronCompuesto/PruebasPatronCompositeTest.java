package practicaPatronCompuesto;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebasPatronCompositeTest {

	Cliente cliAna;
	Cliente cliJuan;
	Cliente cliPedro;

	@Before
	public void prepara() {
		cliAna = new Cliente("Ana", 15);
		cliJuan = new Cliente("Juan", 50);
		cliPedro = new Cliente("Pedro", 70);
	}

	@Test
	public void testOfertaEdadMenorSiAplica() {
		// test con una sola oferta: 15% a menores de 18 años (Se aplica la oferta)
		System.out.println("Caso de prueba SIMPLE: aplica descuento por ser menor de edad");

		Venta venta = new Venta(cliAna, 100);
		IOferta oferSimple = new OfertaEdadMenor(15); // crea una oferta para menores de 18 años del 15%
		// asigna la oferta a la venta
		venta.setOfertaAplicar(oferSimple);
		// comprueba que el importe de la venta es 85, es decir, aplica el descuento
		// porque Ana tiene 15 años
		Assert.assertEquals(venta.calculaImporteFinal(), 85.0, 0.0);
	}

	@Test
	public void testOfertaEdadMenorNoAplica() {
		// test con una sola oferta: 15% a menores de 18 años (Se aplica la oferta)
		System.out.println("Caso de prueba SIMPLE: NO aplica descuento por ser menor de edad");
		Venta venta = new Venta(cliPedro, 100);
		IOferta oferSimple = new OfertaEdadMenor(15); // crea una oferta para menores de 18 años del 15%
		venta.setOfertaAplicar(oferSimple);

		// comprueba que el importe de la venta es 100, es decir, no aplica el descuento
		// porque Pedro tiene 70 años
		Assert.assertEquals(venta.calculaImporteFinal(), 100.0, 0.0);
	}

	@Test
	public void testOfertaJubiladoAplica() {
		// test con una sola oferta: 50% a jubilados (Se aplica la oferta)
		System.out.println("Caso de prueba SIMPLE: Aplica descuento por ser jubilado ");

		// TODO
		Venta venta = new Venta(cliPedro, 100);
		IOferta oferSimple = new OfertaJubilado(15);
		venta.setOfertaAplicar(oferSimple);

		Assert.assertEquals(venta.calculaImporteFinal(), 85.0, 0.0);

	}

	@Test
	public void testOfertaJubiladoNoAplica() {
		// test con una sola oferta: 50% a jubilados (No se aplica la oferta)
		System.out.println("Caso de prueba SIMPLE: NO aplica descuento por ser jubilado ");

		// TODO
		Venta venta = new Venta(cliJuan, 100);
		IOferta oferSimple = new OfertaJubilado(15);
		venta.setOfertaAplicar(oferSimple);

		Assert.assertEquals(venta.calculaImporteFinal(), 100.0, 0.0);

	}

	@Test
	public void testOfertaUmbralAplica() { // test con una sola oferta:
		// descuento de 25 € si el importe es mayor de 150€
		System.out.println("Caso de prueba SIMPLE: Aplica descuento por umbral ");

		// TODO
		Venta venta = new Venta(cliAna, 150);

		IOferta ofertaSimple = new OfertaImporteMayorUmbral(100.0, 25.0);
		venta.setOfertaAplicar(ofertaSimple);

		Assert.assertEquals(venta.calculaImporteFinal(), 125.0, 0.0);

	}

	@Test
	public void testOfertaUmbralNoAplica() { // test con una sola oferta:
		// descuento de 25 € si el importe es mayor de 150€
		System.out.println("Caso de prueba SIMPLE: NO aplica descuento por umbral ");

		// TODO
		Venta venta = new Venta(cliAna, 100);

		IOferta ofertaSimple = new OfertaImporteMayorUmbral(100.0, 25.0);
		venta.setOfertaAplicar(ofertaSimple);

		Assert.assertEquals(venta.calculaImporteFinal(), 100.0, 0.0);

	}
	@Test
	public void testOfertaCompuesta_MejorCliente_Jubilado_Umbral_aplicaAmbas() {
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA EL CLIENTE ((se queda con el importe total mÃ¡s bajo)
		//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150â‚¬ descuenta 25â‚¬) 
		System.out.println("Caso de prueba COMPUESTO lo mejor para el cliente: aplica descuento por jubilado y por umbral:");
		Venta venta=new Venta(cliPedro,200);
		
		// Crea la oferta compuesta
		OferCompuestaLoMejorCliente oferC_LoMejorCliente= new OferCompuestaLoMejorCliente();
		
		// Crea las ofertas simples para luego aÃ±adirlas a la compuesta
		IOferta oferUmbral=new OfertaImporteMayorUmbral(150,25); // crea una oferta para descontar 25â‚¬ si importe >=150
		IOferta oferJubilado=new OfertaJubilado(50); // crea una oferta para jubilados del 50%
		
		//aÃ±ade las ofertas simples a la compuesta
		oferC_LoMejorCliente.addOferta(oferJubilado);
		oferC_LoMejorCliente.addOferta(oferUmbral);
		
		// Asigna la oferta compuesta a la venta
		venta.setOfertaAplicar(oferC_LoMejorCliente);
		
		//Comprueba que el importe final de la venta aplicando la oferta compuesta es 100 (aplica la oferta por jubilado porque es la que favorece mÃ¡s al cliente)
		Assert.assertEquals(venta.calculaImporteFinal(),100.0,0.0);
	}
		
	@Test
	public void testOfertaCompuesta_MejorCliente_Jubilado_Umbral_aplicaAmbas2() {
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA EL CLIENTE ((se queda con el importe total mÃ¡s bajo)
				//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150â‚¬ descuenta 125â‚¬) 

		// TODO otro test similar al anterior para comprobar que aplica la oferta por umbral,
		// porque es la que favorece mÃ¡s al cliente)
		
		
		 // TODO
		Venta venta=new Venta(cliPedro,200);
		
		// Crea la oferta compuesta
		OferCompuestaLoMejorCliente oferC_LoMejorCliente= new OferCompuestaLoMejorCliente();
		
		IOferta oferUmbral=new OfertaImporteMayorUmbral(150,125); 
		IOferta oferJubilado=new OfertaJubilado(50);
		

		oferC_LoMejorCliente.addOferta(oferJubilado);
		oferC_LoMejorCliente.addOferta(oferUmbral);

		venta.setOfertaAplicar(oferC_LoMejorCliente);
		
		Assert.assertEquals(venta.calculaImporteFinal(),75.0,0.0);

	}
	
	@Test
	public void testOfertaCompuesta_MejorTienda_Jubilado_Umbral_aplicaAmbas2() {
		// test con oferta COMPUESTA con dos ofertas aplicando LO MEJOR PARA LA TIENDA ((se queda con el importe total mÃ¡s ALTO)
		//    aplica descuento del 50% por jubilado y por umbral (si el importe es mayor o igual del 150â‚¬ descuenta 50â‚¬) 
	
		System.out.println("Caso de prueba COMPUESTO lo mejor para la tienda: aplica descuento por jubilado y por umbral:");
		Venta venta=new Venta(cliPedro,200);
		
		// Crea la oferta compuesta
		OferCompuestaLoMejorTienda oferC_LoMejorTienda= new OferCompuestaLoMejorTienda();
		
		// Crea las ofertas simples para luego aÃ±adirlas a la compuesta
		IOferta oferUmbral=new OfertaImporteMayorUmbral(150,50); // crea una oferta para descontar 50â‚¬ si importe >=150
		IOferta oferJubilado=new OfertaJubilado(50); // crea una oferta para jubilados del 50%
		
		//aÃ±ade las ofertas simples a la compuesta
		oferC_LoMejorTienda.addOferta(oferJubilado);
		oferC_LoMejorTienda.addOferta(oferUmbral);
		
		// Asigna la oferta compuesta a la venta
		venta.setOfertaAplicar(oferC_LoMejorTienda);
		
		//Comprueba que el importe final de la venta aplicando la oferta compuesta es 150 (aplica la oferta por UMBRAL porque es lo favorece mÃ¡s a LA TIENDA)
		Assert.assertEquals(venta.calculaImporteFinal(),150.0,0.0);
	}
		
	@Test
	public void testOfertaCompuesta_MejorTienda_Jubilado_Umbral_aplicaAmbas() {
		// TODO otro test similar al anterior para comprobar que aplica la oferta por JUBILADO 
	
		System.out.println("Caso de prueba COMPUESTO lo mejor para la tienda: aplica descuento por jubilado y por umbral:");
		Venta venta=new Venta(cliPedro,200);
		
		OferCompuestaLoMejorTienda oferC_LoMejorTienda= new OferCompuestaLoMejorTienda();
		
		IOferta oferUmbral=new OfertaImporteMayorUmbral(150,150);
		IOferta oferJubilado=new OfertaJubilado(50);
		
		oferC_LoMejorTienda.addOferta(oferJubilado);
		oferC_LoMejorTienda.addOferta(oferUmbral);

		venta.setOfertaAplicar(oferC_LoMejorTienda);
		
		Assert.assertEquals(venta.calculaImporteFinal(),100.0,0.0);

	
	}
	/*
	@Test
	public void testOfertaCompuesta_DeOtraOfertaCompuesta() {
	 // caso de test, donde hay una oferta compuesta que a su vez tiene otra oferta compuesta.
	 // Ejemplo:
     //	    la oferta asociada a la venta es una oferta compuesta "lo mejor para la tienda" de dos ofertas:
	 //        -  oferta simple umbral con descuento de 20 â‚¬ de rebaja si alcanza 100â‚¬
     //        -  oferta compuesta "lo mejor para el cliente" formada por :
	 //            -  oferta simple umbral de 30 â‚¬ de rebaja si alcanza 150â‚¬
	 //	           -  oferta simple por jubilado del 25%
	
		// TODO
		fail();
	}*/
}

