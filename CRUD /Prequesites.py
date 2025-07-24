When we are Running some applications by using hibernate frame work we must create 4 files
1) pom.xml---> conatins Dependency like hibernate, mysql connector
2) hibernate.cfg.xml(Name should be anything but extenson should be xml) 
            -----> JdbcDriver,Connection url, username, password, mysql dilect etc.
3) Entity Class ---> Contains Annotations and Constructors etc.
4) App.class or Launch.class----> Contains some steps 
        // Create Configuration & load 
        1) Configuration config = new Configuration(); 
        // Add Annotated Class to Configuration
        2) config.addAnnotatedClass(classname.class);
        // Build sessionFactory and Open Session
        3) SessionFactory sessionfactory = config.buildSessionFactory();
           Session session = sessionfactory.opendSession();
        // Begin Transaction 
        4) Transcation transaction = session.beginTransaction();
        // Save Object to Database
        5) Employee e = new Employee(1,'rajesh');
           session.save(e);
        //  Commit Transaction to save data into the database
         6) session.commit();
            (or)
 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
