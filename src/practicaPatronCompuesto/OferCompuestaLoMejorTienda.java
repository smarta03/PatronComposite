package practicaPatronCompuesto;

public class OferCompuestaLoMejorTienda extends OfertaCompuesta{
	
	public OferCompuestaLoMejorTienda() {
		super();
	}
	
	@Override
	public double calculaImporteTotal(Venta venta) {
		// TODO Auto-generated method stub
		
		double impAplica = 0d;
		double imp = Double.MIN_VALUE;

		for (IOferta item : this.items) {
			impAplica = item.calculaImporteTotal(venta);
			if (imp < impAplica) {
				imp = impAplica;
			}
		}

		return imp;
	}

}
