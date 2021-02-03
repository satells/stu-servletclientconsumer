package br.com.stu.cliente;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ClienteWebService {

    public static void main(String[] args) throws Exception {

	// Creating CloseableHttpClient object
	CloseableHttpClient httpclient = HttpClients.createDefault();

	// Creating the RequestBuilder object
	RequestBuilder reqbuilder = RequestBuilder.post();

	// Setting URI and parameters
	RequestBuilder reqbuilder1 = reqbuilder.setUri("http://localhost:9000/gerenciador/entrada");

	RequestBuilder reqbuilder2 = reqbuilder1.addParameter("name", "mauro").addParameter("senha", "123").addParameter("acao", "Login");

	// Building the HttpUriRequest object
	HttpUriRequest httppost = reqbuilder2.build();

	// Executing the request
	HttpResponse httpresponse = httpclient.execute(httppost);

	// Printing the status and the contents of the response
	System.out.println(EntityUtils.toString(httpresponse.getEntity()));
	System.out.println(httpresponse.getStatusLine());

	Header[] allHeaders = httpresponse.getAllHeaders();
	for (Header header : allHeaders) {
	    System.out.println(header);
	}

	reqbuilder1 = reqbuilder.setUri("http://localhost:9000/gerenciador/entrada?acao=EmpresasXml");
//	reqbuilder2 = reqbuilder1.addParameter("acao", "EmpresasJson");

	// Building the HttpUriRequest object
	httppost = reqbuilder1.build();
	httppost.setHeader("Cookie", "JSESSIONID=283C0EE478EB7BA1A8D3CD919F4108F0");

	// Executing the request
	httpresponse = httpclient.execute(httppost);

	// Printing the status and the contents of the response
	System.out.println(httpresponse.getStatusLine());
	System.out.println(EntityUtils.toString(httpresponse.getEntity()));

//	allHeaders = httpresponse.getAllHeaders();
//	System.out.println("------------------------------------------------");
//	for (Header header : allHeaders) {
//	    System.out.println(header);
//	}
    }

}
