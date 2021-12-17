package practicaPatronCompuesto;

public class OfertaImporteMayorUmbral implements IOferta{
	
	private double descuento;
	private double umbral;

	public OfertaImporteMayorUmbral(double d, double u) {

		this.descuento = d;
		this.umbral = u;
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub

		return 0;
	}


}
