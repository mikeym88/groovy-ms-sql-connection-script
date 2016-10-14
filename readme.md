# Groovy MS SQL Connection Script

This groovy script for SoapUI Pro/ReadyAPI! that connects to an Microsoft MS SQL Server.

## Requirements & Resources

* [Microsoft JDBC Drivers 6.0, 4.2, 4.1, and 4.0 for SQL Server](https://www.microsoft.com/en-us/download/details.aspx?id=11774)
  * **Note**: ReadyAPI 1.8.0 does not support the JDBC 6.0 drives
* [Groovy SQL Documentation](http://docs.groovy-lang.org/latest/html/api/groovy/sql/Sql.html)

## Setup Instructions for SoapUI

1. Download the JDBC drivers `.tar.gz` archive.
2. Extract all the `*.jar` files from the archive and place them in the `<ReadyAPI installation path>\bin\ext\` folder.
   *  **Example**: Place the `sqljdbc4.jar`, `sqljdbc41.jar`, `sqljdbc42.jar` files in `C:\Program Files\SmartBear\ReadyAPI-1.8.5\bin\ext`.
3. Extract the `sqljdbc_auth.dll` (32-bit or 64-bit depending on installed ReadyAPI/SoapUI installation) from the archive and place it in the `<ReadyAPI installation path>\bin\` folder.
   * **Example**: place the `sqljdbc_auth.dll` file in `C:\Program Files\SmartBear\ReadyAPI-1.8.5\bin\`
4. Modify and run the groovy script in this repository to connect to an MS SQL database.

## Connection String

The connection string will allow the groovy script to connect to the database:

    jdbc:sqlserver://serverName:portNumber;instanceName=instance1;databaseName=dbName;integratedSecurity=true;<more properties as required>;

From the [Microsoft MSDN *Building the Connection URL* dcoumentation](https://msdn.microsoft.com/en-us/library/ms378428%28v=sql.110%29.aspx), the components of the string:
* `jdbc:sqlserver://` (Required) is known as the sub-protocol and is constant.
* `serverName` (Optional) is the address of the server to connect to. This could be a DNS or IP address, or it could be localhost or 127.0.0.1 for the local computer. If not specified in the connection URL, the server name must be specified in the properties collection.
* `portNumber` (Optional) is the port to connect to on serverName. The default is 1433. If you are using the default, you do not have to specify the port, nor its preceding ':', in the URL.
* `instanceName` (Optional) is the instance to connect to on serverName. If not specified, a connection to the default instance is made.
* `databaseName` (Optional) is the database to which the groovy script will connect.


## References

[1]w. version, "what is the GROOVY connection string to an JDBC database with SSPI = True? I am running this from SoapUI Free version", Stackoverflow.com, 2016. [Online]. Available: http://stackoverflow.com/questions/30105214/what-is-the-groovy-connection-string-to-an-jdbc-database-with-sspi-true-i-am. [Accessed: 12- Oct- 2016].

[2]A. Beer, "RE: Connecting to MS SQL from SoapUI", 2016.

[3]"Building the Connection URL", Msdn.microsoft.com, 2016. [Online]. Available: https://msdn.microsoft.com/en-us/library/ms378428%28v=sql.110%29.aspx. [Accessed: 12- Oct- 2016].

[4]"Sql (Groovy 2.4.7)", Docs.groovy-lang.org, 2016. [Online]. Available: http://docs.groovy-lang.org/latest/html/api/groovy/sql/Sql.html. [Accessed: 12- Oct- 2016].