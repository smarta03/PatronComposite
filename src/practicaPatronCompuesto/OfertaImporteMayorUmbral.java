package practicaPatronCompuesto;

public class OfertaImporteMayorUmbral implements IOferta {

	private double descuento;
	private double umbral;

	public OfertaImporteMayorUmbral(double d, double u) {

		this.descuento = d;
		this.umbral = u;
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub

		if (venta.getImporte() > umbral) {
			return venta.getImporte() - this.descuento;
		} else {
			return venta.getImporte();
		}
	}

}
