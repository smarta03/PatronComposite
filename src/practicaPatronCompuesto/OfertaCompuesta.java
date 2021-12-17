package practicaPatronCompuesto;

import java.util.ArrayList;

public abstract class OfertaCompuesta implements IOferta {
	protected ArrayList<IOferta> items;

	// TODO
	public OfertaCompuesta() {
		items = new ArrayList<IOferta>();
	}

	public void addOferta(IOferta io) {

	}
	
	public ArrayList<IOferta> getItems() {
		return this.items;
	}
	
	public void setItems(ArrayList<IOferta> iOfertas) {
		this.items = iOfertas;
	}

}
