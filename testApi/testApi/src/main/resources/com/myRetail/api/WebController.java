package com.myRetail.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Path("/webservice")
public class WebController {

	// this method is to insert the record to MongoDB

	@GET
	@Path("/insert/{id}/{name}/{value}/{currency_code}")
	@Produces("text/plain")
	public Response insert(@PathParam("id") String id, @PathParam("name") String name, @PathParam("value") Long value,
			@PathParam("currency_code") String currency_code) {
		// gettng MongoDB singleton object
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		// getting database parameters for API
		DB db = dbSingleton.getAPIdb();
		// Get collection to access from database
		DBCollection coll = db.getCollection("Product");
		// build document to insert n the database
		BasicDBObject currency_value = new BasicDBObject("value", value).append("currency_code", currency_code);
		BasicDBObject doc = new BasicDBObject("id", id).append("name", name).append("currency_value", currency_value);
		coll.insert(doc);
		// build a ok response to return
		return Response.ok().build();

	}

	// to get the product list from mongodb
	@GET
	@Path("/products/{id}")
	@Produces("text/plain")
	public String getRecords(@PathParam("id") int id) {
		// gettng MongoDB singleton object
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		// getting database parameters for API
		DB db = dbSingleton.getAPIdb();
		// Get collection to access from database
		DBCollection coll = db.getCollection("Product");
		// Build query for the get specific record for id from database
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("id", id);
		DBCursor cursor = coll.find(whereQuery);
		String s = null;
		while (cursor.hasNext()) {
			DBObject o = cursor.next();
			s = o.toString();
		}
		return s;
	}

	// to get the product list from mongodb
	@GET
	@Path("/consumeURL")
	@Produces("text/plain")
	public String consumeURL() {
		// Instantiate the CLient to onsume URL
		TargetAPIClient tc = new TargetAPIClient();
		// return API response
		return tc.getResponseFromAPI();
	}

	// to POST the data and insert it in mongoDB database

	@POST
	@Path("/postDataFromURL")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDataFromURL() {
		// API client for posting the URL
		TargetAPIClient tc = new TargetAPIClient();
		// response string
		String responseString = tc.getResponseFromAPI();
		// instantiate mongodb singleton object
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getAPIdb();
		// select collection from the database
		DBCollection coll = db.getCollection("Product");
		// insert reponse from into the collection
		DBObject dbObject = (DBObject) JSON.parse(responseString);
		coll.insert(dbObject);
		return Response.ok().build();
	}

	// to get all the product list from mongodb
	@GET
	@Path("/getAllRecords")
	@Produces("text/plain")
	public String getAllRecords() {
		// instantiate mongodb singleton object
		MongoDBSingleton dbSingleton = MongoDBSingleton.getInstance();
		DB db = dbSingleton.getAPIdb();
		// select collection from the database
		DBCollection coll = db.getCollection("Product");
		// querying all records from the database
		DBCursor cursor = coll.find();
		String s = null;
		// printing out all the records on the host
		while (cursor.hasNext()) {
			DBObject o = cursor.next();
			s = s + o.toString();
			s = s + "\n\n";
			s = s + "---------------------------------------------------------------------------------";
			s = s + "\n\n";
		}
		return s;
	}

}