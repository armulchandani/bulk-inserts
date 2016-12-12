This simple project analyze the performance of bulk insert operations using Hibernate & plain JDBC API

###### Technology stack used:

*Hibernate 4.2.10.Final, MYSQL v 5.1.73, Junit 4.12*

###### Hardware: 
*Windows 7, Intel i3 processor with 4 cores and 8 GB RAM*

What am I doing ?
Performing bulk inserts (350K) records in database ( MySql ) using Hibernate & plain JDBC API. Table in which the data is to be inserted is small table with only 2 columns:ID, WORD

Yes it's a simple table which will store an ID & a word, sample data could be fetched from below Github URL

How am I doing bulk inserts ?

1. Inserting records sequentially with Hibernate generated value for primary key
2. Inserting records sequentially with Hibernate but programmatically generated value for primary key
3. Performing a batch inserts(50) with Hibernate but programmatically generated value for primary key
4. Plain JDBC batch insert(50) with programmatically generated primary id

> With MySql:

1. Hibernate sequential inserts with Hibernate generated value for primary key
   Time : 84.044
2. Hibernate sequential inserts with programmatically generated value for primary key
   Time : 41.926
3. Hibernate batch insert(50) & programmatically generated primary id
   Time : 42.635
   
   3a. Hibernate batch insert(50) and programmatically generated value for primary key and rewriteBatchedStatements=true
   Time : 12.471
4. Hibernate batch insert(1000) and programmatically generated value for primary key and with rewriteBatchedStatements=false
   Total time : 44.112
4a. Hibernate batch insert(1000) with programmatically generated value for primary id and rewriteBatchedStatements=true
   Total time : 9.482

**rewriteBatchedStatements=true the JDBC will pack as many queries as possible into a single network packet, lowering this way the network overhead.**

> With plain JDBC API

1. Plain JDBC batch inserts(1000) with programmatically generated value for primary key and with rewriteBatchedStatements=false
   Total time : 37.492
   
   1a. Plain JDBC batch insert(1000) with programmatically generated value for primary key and with rewriteBatchedStatements=true
   Total time : 5.522	
