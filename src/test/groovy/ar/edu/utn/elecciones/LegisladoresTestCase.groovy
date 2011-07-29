package ar.edu.utn.elecciones;

import java.util.regex.Matcher;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.utn.elecciones.http.Conector;


class LegisladoresTestCase {
	def pro, pj, ucr, po, resultado, bancas, conector
	
	@Before
	def void init(){
		bancas = 30
		pro = new Lista(716532, "pro")
		pj = new Lista(556932, "pj")
		ucr = new Lista(45693, "ucr")
		po = new Lista(17345, "po")
		resultado = new ResultadoLegisladores(bancas, [pro,pj,ucr, po])
		conector = new Conector("http://www.eleccionescaba2011.gob.ar/paginas/paginas/dat01/DGO01999.htm")
	}
	
//	@Test
	def void testResultado(){
		resultado.resultado().each {unBloque -> println(unBloque) }
		Assert.assertEquals(bancas, resultado.resultado().inject( 0,
			{suma, unBloque -> suma + unBloque.cantidadBancas() }) )
		
	}
	
	@Test
	def void testConector(){
		def resultado = conector.getBody()
		def matcher = (resultado =~ /<t[hd].*>(.*)<\/t[hd].*>/)
		matcher.each {p-> println p[1] }
	}
	
//	@Test
	def void testSarlanga(){
		def Matcher matcher = ("abctotototabctototoabc" =~ /(a)b(c)/)
		matcher.each {p-> println p }
		
	}

}
