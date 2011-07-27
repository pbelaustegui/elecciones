package ar.edu.utn.elecciones

class Lista {
	private votos
	private nombre
	public Lista(Object votos, Object nombre) {
		super();
		this.votos = votos;
		this.nombre = nombre;
	}
	
	def getVotos(){
		return votos
	}
	
	def getNombre(){
		return nombre
	}
	
	@Override
	public String toString() {
		return nombre + " : " + votos;
	}

}
