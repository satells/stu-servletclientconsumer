package br.com.stu.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWeb {
    public static void main(String[] args) {
	try {
	    String retorno = Request.Post("http://localhost:9000/gerenciador/empresas").addHeader("Accept", "application/xml").execute().returnContent().asString();
	    System.out.println(retorno);

	    retorno = Request.Post("http://localhost:9000/gerenciador/empresas").addHeader("Accept", "application/json").execute().returnContent().asString();
	    System.out.println(retorno);

	    retorno = Request.Post("http://localhost:9000/gerenciador/empresas").addHeader("Accept", "text/html").execute().returnContent().asString();
	    System.out.println(retorno);
	} catch (ClientProtocolException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }
}