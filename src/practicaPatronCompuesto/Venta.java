package practicaPatronCompuesto;

public class Venta {

	private Cliente cliente;
	private double importe;
	private IOferta io;

	public Venta(Cliente c, double imp) {

		this.cliente = c;
		this.importe = imp;

	}

	public IOferta getOfertaAplicar() {
		return io;
	}
	
	public void setOfertaAplicar(IOferta iOfer) {
		this.io = iOfer;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double calculaImporteFinal() {
	
		return io.calculaImporteTotal(this);
	}

	

}
