package ar.edu.utn.elecciones;

import org.junit.Before;
import org.junit.Test;


class LegisladoresTestCase {
	private pro, pj, ucr, po, resultado
	
	@Before
	def void init(){
		pro = new Lista(716532, "pro")
		pj = new Lista(556932, "pj")
		ucr = new Lista(45693, "ucr")
		po = new Lista(17345, "po")
		resultado = new ResultadoLegisladores(30, [pro,pj,ucr, po])
	}
	
	@Test
	def void testResultado(){
		resultado.resultado().each {unBloque -> println(unBloque) }
	}

}
