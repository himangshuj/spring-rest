#Springboot rest sample application

## Objective
* Basic crud operations for generic [company] (src/main/java/models/Company.java) over http
  * A company is made up of 
  * name
  * email
  * address
  * city
  * country
  * companyId -> this is autogenerated
  Additionally it may have
  * email
  * phone number
  * list of owners
## Prerequisites
* Postgres
* java8
* maven8
* postgres db with dbname spring_rest and spring_rest_test with username and password as postres

## Run instructions
``` mvn clean package && /java -jar -Dspring.profiles.active=dev  target/rest-crud-1.0-SNAPSHOT.jar ```

## Usage directions
* Get all companies  by page Number
```curl  -v http://localhost:8080/api/getAll?pageNo=<<pageNo>>```
* Get total number of companies
```curl  -v http://localhost:8080/api/getCount```
* Create a new company -> this does not add owners ,email and phonenumber are option
``` curl -v http://localhost:8080/api/insert -H "Content-Type: application/json" -d'{"name":"Name4","address":"Address4","city":"City4","country":"Country4"}' ```
``` curl -v http://localhost:8080/api/insert -H "Content-Type: application/json" -d'{"name":"Name4","address":"Address4","city":"City4","country":"Country4",
email:"mail@mail.com",phoneNumber:"phoneNumber"}' ```
  * if you see 400 error, probably you missed a comma in the curl call
* update a company -> we cannot change owners
``` http://localhost:8080/api/update/<<companyId>> -H "Content-Type: application/json" 
-d'{"country":"India","address":"Address","city":"Bangalore","name":"Name","email":"newemail@email.com"}' ```
   
* Add Owner 
```curl  http://localhost:8080/api/<<companyId>>/addOwner?owner=<<owner>>```

* Using with html
open localhost:8080 in browser 
 * this open the paginated list of companies
 * clicking any company opens the details form of the company which can edited
 * new page selection can be done at home.
 * there is a separate area in details page to add owners
  
## TODO Authentication
  Recommended approach will be https://github.com/spring-projects/spring-data-examples/tree/master/rest/security
  Basic http authentication with user id and pass in each curl call. This is standard simple and stateless. I do not want to use sessions for this 
  project at this point of time.
  
