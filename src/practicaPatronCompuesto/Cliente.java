package practicaPatronCompuesto;

public class Cliente {
	
	private int edad;
	private String nombre;
	
	public Cliente(String n, int e) {
		
		this.edad = e;
		this.nombre = n;
		
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
