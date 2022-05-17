
class Database {
   private static Database dbObject;

   private Database() {      
   }

   public static Database getInstance() {
 	  System.out.println(dbObject == null);
      // create object if it's not already created
      if(dbObject == null) {

         dbObject = new Database();
      }

       // returns the singleton object
       return dbObject;
   }

   public void getConnection() {
       System.out.println("You are now connected to the database.");
   }
}

class SingleTonEx {
   public static void main(String[] args) {
      Database db1 ;//user1
      Database db2;//user2

      // refers to the only object of Database
      db1= Database.getInstance();
      
      db1.getConnection();
      
   // refers to the only object of Database
      db2= Database.getInstance();
      
      db2.getConnection();
 
   }
}

