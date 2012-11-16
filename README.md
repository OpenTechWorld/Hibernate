Hibernate
=========

Various Examples using Hibernate.


Module 1: SimpleJPAHibernate

Key Points:

    * JPA needs persistence configuration in META-INF/persistence.xml in the classpath.
        - For maven project, place the META-INF/persistence.xml in src/main/resources
    * persistence.xml contains the JPA configuration of the following
        - data source details
        - database driver
        - jpa provider
    * Each persistent unit has a unique ID and it is used while creating the EntityManager



HOW-TO
*******

Generating the Entities class from database Table

Eclipse plugin : Daly (installed by default in Juno 4.2)