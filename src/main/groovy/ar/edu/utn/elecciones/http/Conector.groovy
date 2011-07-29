package ar.edu.utn.elecciones.http

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

class Conector {
	
	def url
	def HttpMethod method
	def HttpClient client
	public Conector(Object url) {
		super();
		this.url = url;
		this.client = new HttpClient()
		this.method = new GetMethod(url);
	}
	
	def getBody(){
		def body
		try {
			client.executeMethod(method)
			body = new String(method.getResponseBody());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			method.releaseConnection()
		}
		return body
	}
	
	def getResultados(){
		return this.getBody().replaceAll("\n", "")
	}
}
