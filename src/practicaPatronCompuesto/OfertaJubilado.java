package practicaPatronCompuesto;

public class OfertaJubilado implements IOferta {

	private double descuento;

	public OfertaJubilado(double descuento) {

		this.descuento = descuento;
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub

		return 0;
	}

}
