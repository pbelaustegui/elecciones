package ar.edu.utn.elecciones

class ResultadoLegisladores {
	private Integer bancas
	private List<Lista> listas
	private List<Legislador> legisladores
	private List<BloqueLegisladores> bloques
	
	def criterioDhont = {a, b -> a.votosRelativos() == b.votosRelativos() ?
		b.votosAbsolutos() - a.votosAbsolutos() :
		b.votosRelativos() - a.votosRelativos() }
	public ResultadoLegisladores(Integer bancas, List<Lista> listas) {
		super();
		this.bancas = bancas;
		this.listas = listas;
		this.crearLegisladores()
		this.armarBloques()
	}
	
	def crearLegisladores(){
		this.legisladores = []
		(1..bancas).each {n -> listas.each {l -> legisladores.add(new Legislador(n, l)) } }
	}

	def List<Legislador> ganadores(){
		return legisladores.clone().sort(criterioDhont)[0..bancas - 1]
	}
	
	def List<BloqueLegisladores> resultado(){
		return bloques
	}
	
	def armarBloques(){
		bloques = []
		listas.each {l -> bloques.add(new BloqueLegisladores(this.ganadores().findAll {a -> a.getLista() == l }, l)) }
		bloques.sort {a, b -> b.cantidadBancas() - a.cantidadBancas()}
	}
}
