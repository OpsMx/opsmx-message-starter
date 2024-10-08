# opsmx-message-starter
This module contains common files to make messaging to and from rabbitMQ possible and a logging method for publishing logs in application.
After importing this one just needs to define route configuration between Apache Camel endpoints and RabbitMQ endpoints.

To Use this:

1) Import the dependency inside pom.xml with:
        
          ```
           <dependency>
               <groupId>com.opsmx</groupId>
               <artifactId>opsmx-message-starter</artifactId>
               <version>{version_name}</version>
           </dependency>
           ```
        

2) Define Route configuration file in your repo to define endpoints to publish or a message consumer bean.
   It should extend `org.apache.camel.builder.RouteBuilder` for it to be automatically picked by message-starter module and configure Apache Camel accordingly.
  See `com.opsmx.messaging.config.TestRouteConfiguration` for an example. While defining the route configuration you will need to construct
 RabbitMQ endpoint for Camel to use, instead of defining your own method optionally you can make use of `com.opsmx.messaging.config.MessageStarterCamelRouteConfig.configure`
 method which takes exchange name and queue name as parameters and returns and RabbitMQ uri as string.


3) Finally, set attribute to your `@SpringBootApplication` annotation to scan packages of this library: `@SpringBootApplication(scanBasePackages = "com.opsmx")`


4) For publishing, the module produces a `org.apache.camel.ProducerTemplate` bean which you can autowire in your publisher class and use it to publish a message to an endpoint.


5) `AuditPublisher` is a class that contains a static function `sendToAudit`, it can be used to send audit events for persistence to camelEndpoint: `direct:auditEvent`
