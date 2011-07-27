package ar.edu.utn.elecciones

class Legislador {
	private Integer orden
	private Lista lista

	public Legislador(Integer orden, Lista lista) {
		super();
		this.orden = orden;
		this.lista = lista;
	}
	
	def votosAbsolutos(){
		return lista.getVotos()
	}
	
	def votosRelativos(){
		return lista.getVotos() / orden
	}
	
	@Override
	public String toString() {
		return "{" + lista.toString() + " ord:" + orden +
		" vr:" + this.votosRelativos() + "}"
	}
	
	def Lista getLista(){
		return lista
	}


}
