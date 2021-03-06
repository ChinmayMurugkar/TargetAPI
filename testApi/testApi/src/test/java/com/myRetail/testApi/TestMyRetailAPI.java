package com.myRetail.testApi;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class TestMyRetailAPI {
	// test for checking if all records are pulled and posted on URL
	@Test
	public void GetRequestForAllRecordsTest() {
		String testAllRecords = "{\"product_composite_response\":{\"request_attributes\":[{\"name\":\"product_id\",\"value\":\"13860428\"},{\"name\":\"key\",\"value\":\"43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz\"},{\"name\":\"id_type\",\"value\":\"TCIN\"},{\"name\":\"fields\",\"value\":\"descriptions\"}],\"items\":[{\"relation\":\"TAC\",\"relation_description\":\"Title Authority Child\",\"data_page_link\":\"http://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428\",\"imn_identifier\":12244586,\"identifier\":[{\"id_type\":\"DPCI\",\"id\":\"058-34-0436\",\"is_primary\":null,\"source\":\"Online and Store\"},{\"id_type\":\"TCIN\",\"id\":\"13860428\",\"is_primary\":null,\"source\":\"Online\"}],\"is_orderable\":true,\"is_sellable\":true,\"general_description\":\"BIG LEBOWSKI, THE Blu-ray\",\"business_process_status\":[{\"process_status\":{\"is_ready\":true,\"operation_description\":\"assortment ready\",\"operation_code\":\"PAAP\"}},{\"process_status\":{\"is_ready\":false,\"operation_description\":\"import ready\",\"operation_code\":\"PIPT\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"order ready\",\"operation_code\":\"PORD\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"presentation ready\",\"operation_code\":\"PPRS\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"project ready\",\"operation_code\":\"PCMT\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"replenishment ready\",\"operation_code\":\"PRPL\"}},{\"process_status\":{\"is_ready\":false,\"operation_description\":\"scale ready\",\"operation_code\":\"PSCL\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"target.com ready\",\"operation_code\":\"PTGT\"}}],\"dpci\":\"058-34-0436\",\"department_id\":58,\"class_id\":34,\"item_id\":436,\"online_description\":{\"value\":\"The Big Lebowski [Blu-ray]\",\"type\":\"GENL\"},\"store_description\":{\"value\":\"BIG LEBOWSKI, THE Blu-ray\",\"type\":\"GENL\"},\"alternate_description\":[{\"type\":\"ADSG\",\"value\":\"The Big Lebowski:<\\/Blu-ray Disc\",\"type_description\":\"Ad Signage Description\"},{\"type\":\"POS\",\"value\":\"BLU-RAY\",\"type_description\":\"POS Desc\"},{\"type\":\"SHLF\",\"value\":\"BIG LEBOWSKI, THE UNIV\",\"type_description\":\"Shelf Desc\"},{\"type\":\"VEND\",\"value\":\"BIG LEBOWSKI BD\",\"type_description\":\"Vendor Description\"}]}]}}";
		expect().body(equalTo(testAllRecords)).when().get("/api/webservice/getAllRecords");
	}

	// testing for inserting the record where we will check the reponse that is
	// build
	@Test
	public void insertRecordsTest() {
		expect().body(equalTo(Response.ok().build())).when()
				.get("/api/webservice/insert/{id}/{name}/{value}/{currency_code}");
	}

	// testing if the URL is consumed
	@Test
	public void consumeURLTest() {
		String consumedRecords = "Output from Server .... \r\n \r\n URL used : https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz\r\n \r\n \r\n {\"product_composite_response\":{\"request_attributes\":[{\"name\":\"product_id\",\"value\":\"13860428\"},{\"name\":\"key\",\"value\":\"43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz\"},{\"name\":\"id_type\",\"value\":\"TCIN\"},{\"name\":\"fields\",\"value\":\"descriptions\"}],\"items\":[{\"relation\":\"TAC\",\"relation_description\":\"Title Authority Child\",\"data_page_link\":\"http://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428\",\"imn_identifier\":12244586,\"identifier\":[{\"id_type\":\"DPCI\",\"id\":\"058-34-0436\",\"is_primary\":null,\"source\":\"Online and Store\"},{\"id_type\":\"TCIN\",\"id\":\"13860428\",\"is_primary\":null,\"source\":\"Online\"}],\"is_orderable\":true,\"is_sellable\":true,\"general_description\":\"BIG LEBOWSKI, THE Blu-ray\",\"business_process_status\":[{\"process_status\":{\"is_ready\":true,\"operation_description\":\"assortment ready\",\"operation_code\":\"PAAP\"}},{\"process_status\":{\"is_ready\":false,\"operation_description\":\"import ready\",\"operation_code\":\"PIPT\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"order ready\",\"operation_code\":\"PORD\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"presentation ready\",\"operation_code\":\"PPRS\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"project ready\",\"operation_code\":\"PCMT\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"replenishment ready\",\"operation_code\":\"PRPL\"}},{\"process_status\":{\"is_ready\":false,\"operation_description\":\"scale ready\",\"operation_code\":\"PSCL\"}},{\"process_status\":{\"is_ready\":true,\"operation_description\":\"target.com ready\",\"operation_code\":\"PTGT\"}}],\"dpci\":\"058-34-0436\",\"department_id\":58,\"class_id\":34,\"item_id\":436,\"online_description\":{\"value\":\"The Big Lebowski [Blu-ray]\",\"type\":\"GENL\"},\"store_description\":{\"value\":\"BIG LEBOWSKI, THE Blu-ray\",\"type\":\"GENL\"},\"alternate_description\":[{\"type\":\"ADSG\",\"value\":\"The Big Lebowski:<\\/Blu-ray Disc\",\"type_description\":\"Ad Signage Description\"},{\"type\":\"POS\",\"value\":\"BLU-RAY\",\"type_description\":\"POS Desc\"},{\"type\":\"SHLF\",\"value\":\"BIG LEBOWSKI, THE UNIV\",\"type_description\":\"Shelf Desc\"},{\"type\":\"VEND\",\"value\":\"BIG LEBOWSKI BD\",\"type_description\":\"Vendor Description\"}]}]}}";
		expect().body(equalTo(consumedRecords)).when().get("/api/webservice/consumeURL");
	}

	// testing if the post is working fine
	@Test
	public void postDataFromURLTest() {
		expect().body(equalTo(Response.ok().build())).when().get("/api/webservice/postDataFromURL");
	}
}
