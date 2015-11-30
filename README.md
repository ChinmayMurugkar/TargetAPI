# TargetAPI
83f202aa19af5787523f7189fd978219334caab9

1] Responds to an HTTP GET request at /products/{id} and delivers product data as

JSON (where {id} will be a number.

2] Performs an HTTP GET to retrieve the product name from an external API. (For 

this exercise the data will come from api.target.com, but let’s just pretend this is 

an internal resource hosted by myRetail)

3] Reads pricing information from a NoSQL data store and combines it with the 

product id and name from the HTTP request into a single response.

4] Includes appropriate test cases implemented using a framework such as JUnit and Rest 

This Project contains ;
1] Readme.md file
2] POM.xml file
3] War file in Target folder

TECHNOLOGIES USED :
1] Maven 
2]  Jersey RESTful Web Services framework
3]  REST Assuredframework for testing
4] Junit framework for testing
5] MongoDB for NoSQL database storage
6] MongoDB drivers

Database Information :
1. Database Name to be used : "testAPI"
2. Database collection name : Product

Usage :
the URL to be used :
localhost:8084/testAPI/webservice/api/{option}

Options available :
1] /products/{id}
2] /postDataFromURL
3] /getAllRecords
4] /consumeURL
5] /insert/{id}/{name}/{value}/{currency_code}

Database schema exmaple :
{"id":13860428,"name":"The Big Lebowski (Blu-ray)(Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}
