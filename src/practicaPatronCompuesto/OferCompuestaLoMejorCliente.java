package practicaPatronCompuesto;

public class OferCompuestaLoMejorCliente extends OfertaCompuesta {

	public OferCompuestaLoMejorCliente() {
		super();
	}

	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub

		double impAplica = 0d;
		double imp = Double.MAX_VALUE;

		for (IOferta item : this.items) {
			impAplica = item.calculaImporteTotal(venta);
			if (impAplica < imp) {
				imp = impAplica;
			}
		}

		return imp;
	}

}
