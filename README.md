onion-mng
=========

The idea is to have the _core_ module in the application completely decoupled to frameworks, databases, frontend, etc...

So using the onion architecture, or [clean architecture](http://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html), we are pushing all the **technology** related code to the outer layers, leaving the inner layers independent.

![Architecture diagram](https://raw.githubusercontent.com/adarrivi/onion-mng/master/wiki/images/onionDiagram1.png)

The project contains:
* ``onion-mng-parent``: _maven parent module_ containing references to all the other modules, as well as the dependency versions
* ``onion-mng-core``: contains the entities, contracts, adapters and user cases.
* ``onion-mng-relational``: uses [Spring Framework](http://spring.io/)for dependency injection and Spring Data+Hibernate+Hsql to persist the data. Has a **relational-db approach**.
* ``onion-mng-norelational``: uses [Guice](https://code.google.com/p/google-guice/) for depencency injection and a key-value in memory store for persist the data. Also all the data is persisted in JSON format (much like a [Couchbase db](http://www.couchbase.com/)). Also it has a **no-relational-db approach** for the persistence.
* ``onion-mng-test``: test module with the testing dependencies and some utility classes for testing.

Both ``onion-mng-relational`` and ``onion-mng-norelational`` contains a JUnit test, ``StructureUserCaseTest.java``, using a user-case verifier from ``onion-mng-test`` that will ensure the logic keeps the same no matter the technologies (spring/guice/jpa/key-valueJson) and approaches(relational-norelational) are being used.
