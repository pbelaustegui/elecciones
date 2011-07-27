package ar.edu.utn.elecciones

class BloqueLegisladores {
	private List<Legislador> legisladores
	private Lista lista
	

	public BloqueLegisladores(List<Legislador> legisladores, Lista lista) {
		super();
		this.legisladores = legisladores;
		this.lista = lista;
	}
	
	def Integer cantidadBancas(){
		return legisladores.size()
	}
	
	@Override
	public String toString() {
		return "Lista: $lista bancas: " + this.cantidadBancas()
	}

}
