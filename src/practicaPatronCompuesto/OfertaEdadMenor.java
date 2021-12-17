package practicaPatronCompuesto;

public class OfertaEdadMenor implements IOferta {
	// CLASE PARA OFERTAS APLICADAS A MENORES DE EDAD (<18 AÑOS)

	private double descuento;

	public OfertaEdadMenor(double descuento) {

		this.descuento = descuento;
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub
		
		if(venta.getCliente().getEdad()>=18) {
			return venta.getImporte();
		} else {
		
			return venta.getImporte()-(venta.getImporte()*(descuento/100));
			
		}
	}

}
