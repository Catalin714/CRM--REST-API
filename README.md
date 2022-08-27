**CUSTOMER RELATIONSHIP MANAGEMENT (CRM) REST API**

I did a simple Customer Relationship Management (CRM) REST API.

Tools and technologies used:

- Java 11
- Spring MVC
- Spring SECURITY
- Spring ORM
- Hibernate
- Jackson
- Eclipse
- Postman
- MySql

**API Requirements**

Create a REST API for a Customer Relationship Management (CRM) system.

REST clients should be able to:

- Get a list of customers
- Get a single customer by id
- Add a new customer
- Update a customer
- Delete a customer

**Steps**

1. Create Maven Project
2. Create database tables and populate-it
3. Create Packaging Structure and classes:
  - Config
  - entity
  - service
  - dao
  - rest
4. Configure MySQL Database:
  - DAO connect to database
    - JDBC URL
    - Username
    - Password
5. Testing created API with Postman client

**THINGS TO REMEMBER**

When we use Hibernate saveOrUpdate method in REST controller, we explicitly need to set the id to 0 because if the primary key or the id is empty basically checks the primary key. If the primary key or the id is empty that'll actually perform an insert else it'll perform an update.
