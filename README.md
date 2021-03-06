This simple project analyze the performance of bulk insert operations using Hibernate & plain JDBC API

###### Technology stack used:

*Hibernate 4.2.10.Final, MYSQL v 5.1.73, Junit 4.12*

###### Hardware: 
*Windows 7, Intel i3 processor with 4 cores and 8 GB RAM*

What am I doing ?  
Performing bulk inserts (350K) records in database ( MySql ) using Hibernate & plain JDBC API. Table in which the data is to be inserted is small table with only 2 columns:ID, WORD

Yes it's a simple table which will store an ID & a word, sample data could be fetched from below Github URL

[https://github.com/dwyl/english-words]

My special thanks to the source provider as it helped me to complete my analysis

**Copyright still belongs to the origianl source** 

How am I doing bulk inserts ?

1. Inserting records sequentially with Hibernate generated value for primary key
2. Inserting records sequentially with Hibernate but programmatically generated value for primary key
3. Performing a batch inserts(50) with Hibernate but programmatically generated value for primary key
4. Plain JDBC batch insert(50) with programmatically generated primary id

**Test Results:**

> With MySql:

1. Hibernate **sequential** inserts with **auto generated** value for primary key  
   Time : 75.959  
   
   	*Here it's important to note that for each value of primary key, hibernate issues a select query to retrieve unique value from a sequence so it takes too much time as    compared to other tests.*  
   
2. Hibernate **sequential** inserts with program assigned value for primary key  
   Time : 13.802
   
3. Hibernate **batch** insert(50) & program assigned primary id  
   Time : 10.822
   
   3a. Hibernate **batch** insert(50) and program assigned value for primary key and **rewriteBatchedStatements=false**  
   Time : 40.27
   
   3b. Hibernate **sequential** inserts with program assigned value for primary key and **rewriteBatchedStatements=false**  
   Time : 41.581


> With plain JDBC API

With plain JDBC	
	
4. Plain JDBC **sequential** inserts with program assigned value for primary key and with **rewriteBatchedStatements=false**
   Total time : 35.806

5. Plain JDBC **batch** insert(50) with **rewriteBatchedStatements=true**
   Total time : 6.467	


**With 'rewriteBatchedStatements=true' ,the JDBC will pack as many queries as possible into a single network packet, lowering this way the network overhead.**   
   
   
**Analysis**

In all the cases JDBC's performance is better than using Hibernate ( only for bulk inserts, sequentially or batch )

1. Comparing 3b & 4, performing sequential inserts operation by **JDBC API** takes less time around 5.775 seconds less  
2  Comparing 3 & 5, performing batch inserts operation by **JDBC API** also takes less time around 4.35 seconds less

Here, I am not concluding that that Hibernate is poor or have less performance as compared to using plain JDBC API for performing bulk inserts but Hibernate do have some overhead. 

My affinity for Hibernate will always be there and shall always use hibernate. 


   
   
   