package ar.edu.utn.elecciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


class LegisladoresTestCase {
	def pro, pj, ucr, po, resultado, bancas
	
	@Before
	def void init(){
		bancas = 30
		pro = new Lista(716532, "pro")
		pj = new Lista(556932, "pj")
		ucr = new Lista(45693, "ucr")
		po = new Lista(17345, "po")
		resultado = new ResultadoLegisladores(bancas, [pro,pj,ucr, po])
	}
	
	@Test
	def void testResultado(){
		resultado.resultado().each {unBloque -> println(unBloque) }
		Assert.assertEquals(bancas, resultado.resultado().inject( 0,
			{suma, unBloque -> suma + unBloque.cantidadBancas() }) )
		
	}

}
