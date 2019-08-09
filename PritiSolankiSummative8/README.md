Read Me File for Summative 8 

Project Title : Stwitter Service

This Project consists of following services : 

Post Service (running on 1777 port)
Comment Service (running on 6868 port)
Stwitter Service (running on 8889 port)
Config Server (running on 1999 port)
Eureka Service Registry (running on 8761 port)

In order to run this project, you will need to run the services in following order.

Config Server
Eureka Service Registry
Post Service
Comment Service
Stwitter Service

Endpoints (to test service from postman) for Stwitter service are :

‘/posts’ for create (post) and getAll posts.
‘/posts/{id}’ for getting posts by id.
‘/posts/user/{posterName}’ for getting posts by poster name.
