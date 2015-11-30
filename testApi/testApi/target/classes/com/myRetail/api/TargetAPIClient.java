package com.myRetail.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TargetAPIClient {

	public String getResponseFromAPI() {
		String result = null;
		try {
			String clientURL = "https://api.target.com/products/v3/13860428?fields=descriptions&id_type="
					+ "TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";

			// Here we are creating client to consume the URL
			Client client = Client.create();

			// web encapsulation class to create web resource for sending and
			// receiving response
			WebResource webResource = client.resource(clientURL);

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
			/*
			 * System.out.println("Output from Server .... \n");
			 * System.out.println(output);
			 */
			// result = " Output from Server .... \n \n " + "URL used : " +
			// clientURL;
			result = result + "\n \n \n " + output;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}
}