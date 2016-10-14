// register SQL JDBC driver
import groovy.sql.*
com.eviware.soapui.support.GroovyUtils.registerJdbcDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver")


// Change the following variables for desired environment
// They are all strings
def serverName 	= ""	// Examples: "localhost" "127.0.0.1"
def instance 	= ""	// Example: "instance1"
def serverPort = ""		// 

// 1433 is the default port
// instance1, instance2, 43001, 43002 are examples
if (instance == "instance1")
	serverPort = "43001"	
else if (instance == "instance2")
	serverPort = "43002"
else
	serverPort = "1433"

def dbName = ""

// Connection String Template:
// jdbc:sqlserver://localhost;instanceName=instance1;databaseName=dbName;integratedSecurity=true;<more properties as required>;
// from: https://msdn.microsoft.com/en-us/library/ms378428%28v=sql.110%29.aspx

def db = [url:"jdbc:sqlserver://" + serverName+ ":" + serverPort + ";instanceName=" + instance + ";databaseName=" + dbName + ";integratedSecurity=true", driver:"com.microsoft.sqlserver.jdbc.SQLServerDriver"]

log.info "Attempting to connect to db url:  " + db.url

try
{
	// Connect to DB
	def connection = Sql.newInstance(db.url, db.driver)
	
	context.setProperty("dbconn",connection)
	log.info "connected to the database: " + db.url

	// Documentation on commands to run: http://docs.groovy-lang.org/latest/html/api/groovy/sql/Sql.html
	// Useful methods:
	// - execute()
	// - executeInsert()
	// - rows()
	
	log.info "Closing connection..."
	context.setProperty("dbconn",null)
	// Close DB connection
	connection.close()
	log.info "Connection closed."
}
catch(Exception e)
{
	log.error "Could not connect to the database: " + e
}

