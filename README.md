# local-ejb-injection

This is a sample project demonstrating injecting EJBs from EJB JARs into web
applications packaged as WARs inside a master EAR.

Here's how the result looks:

    application-ear.ear
    ├── service-ejb-impl.jar
    ├── web-application.war
    ├── lib
    │   └── service-ejb-api.jar
    └── META-INF
        ├── MANIFEST.MF
        └── application.xml

Here’s a usage scenario:

You have a web application packaged as a WAR that needs to use EJB services
that cannot be packaged into the WAR as they are used by other WARs in the EAR.
You annotate the service interface with `@Local`, extract it into a separate
API JAR and reference the API JAR from both the WAR and EAR projects. Then you
implement the service in an EJB JAR that is packaged into the EAR and inject
the interface with `@EJB` annotation as an instance field into a servlet in the
WAR.

It’s a Maven project with the following modules:

* *web-application* – servlet that calls the EJB service, open
  <http://localhost:8080/web-application/hello> to access it
* *service-ejb-api* – service interface with `@Local` annotation
* *service-ejb-impl* – `@Stateless` EJB that implements the service interface
* *application-ear* – packages the EJB JAR into an EAR.

Build it with `mvn package` and deploy
`application-ear/target/application-ear.ear` to the application server to run
it.
