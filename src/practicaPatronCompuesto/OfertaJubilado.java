package practicaPatronCompuesto;

public class OfertaJubilado implements IOferta {

	private double descuento;

	public OfertaJubilado(double descuento) {

		this.descuento = descuento;
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub

		if (venta.getCliente().getEdad() >= 60) {
			return venta.getImporte() - (venta.getImporte() * (descuento / 100));
		} else {
			return venta.getImporte();
		}
	}

}
