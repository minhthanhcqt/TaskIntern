package InformationUser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class User {
		private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String middleName;
        private String fullName;
        private String birthDay;
        private String gender;
       private static String DB_URL = "jdbc:mysql://localhost:3306/informationuser";
       private static String USER_NAME = "root";
       private static String PASSWORD = "0801";
       private static List<User>userList;

        public User(String userName, String password, String firstName, String lastName, String middleName,String birthDay, String gender)
        {
            this.userName=userName;
            this.password=password;
            this.firstName=firstName;
            this.lastName=lastName;
            this.middleName=middleName;
            this.fullName=this.firstName+" "+this.lastName+" "+this.middleName;
            this.birthDay=birthDay;
            this.gender=gender;
        }
        
        public String getBirthDay() {
            return birthDay;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getFullName() {
            return fullName;
        }

        public String getGender() {
            return gender;
        }

        public String getLastName() {
            return lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getPassword() {
            return password;
        }

        public String getUserName() {
            return userName;
        }
        
        public User() {
			// TODO Auto-generated constructor stub
		}
		public void EnterInformation()
        {
            Scanner scanner= new Scanner(System.in);
            System.out.print("Enter userName : ");
            String username=scanner.nextLine();
            this.userName=username;
            System.out.print("Enter Password: ");
            String password=scanner.nextLine();
            this.password=password;
            System.out.print("Enter FirstName: ");
            String firstName=scanner.nextLine();
            this.firstName=firstName;
            System.out.print("Enter LastName: ");
            String lastName=scanner.nextLine();
            this.lastName=lastName;
            System.out.print("Enter MiddleName: ");
            String middleName=scanner.nextLine();
            this.middleName=middleName;
            this.fullName=this.firstName+" "+this.lastName+" "+this.middleName;
            System.out.print("Enter BirthDay (yyyy-MM-dd): ");
	        String dateString=scanner.nextLine();
	        this.birthDay=dateString;
            System.out.print("Enter gender: ");
            String gender=scanner.nextLine();
            this.gender=gender;
           
            
        }


        
        void printUser()
        {
        	System.out.print("UserNane: "+ this.userName+"\t");
        	System.out.print("PassWord: "+ this.password+"\t");
        	System.out.print("FullName: "+ this.fullName+"\t");
        	System.out.print("BirthDay: "+ this.birthDay+"\t");
        	System.out.println("Gender: "+ this.gender);
        	
        	
        }
        
        
        void writeFile(String namefile)
	    {
	        try (FileWriter f = new FileWriter(namefile, true);
	        BufferedWriter b = new BufferedWriter(f);
	        PrintWriter p = new PrintWriter(b);)
	        {
	            p.print(this.userName+"/");
	            p.print(this.password+"/");
	            p.print(this.firstName+"/");
	            p.print(this.lastName+"/");
	            p.print(this.middleName+"/");
	            p.print(this.birthDay+"/");
	            p.println(this.gender);
	            p.flush();
	           
	        }
	        catch (IOException i)
	        {
	            i.printStackTrace();
	        }
	    }
        
      
       
  
    public static final void readFile(String namefile)
    {
        try{
            File f=new File(namefile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
      
            while((line=br.readLine())!=null)
            {
            
            	String[]x=line.split("/");
            	userList.add(new User(x[0], x[1], x[2], x[3], x[4], x[5],x[6]));
            	
            }
            
            fr.close();
            br.close();
            System.out.println("Data Successfully reading into object");
        }
        catch (IOException e){
            System.out.println("I/O Error: " + e);
        }
      
    }
    
    public static final void ReadDatabase()
    {
    	try(Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery("select * from user");
    	      ) {		      
    	         while(rs.next()){
    	        	String username_db=rs.getString("userName");
    	        	String password_db=rs.getString("password");
    	        	String firstName_db=rs.getString("firstName");
    	        	String lastName_db=rs.getString("lastName");
    	        	String middleName_db=rs.getString("middleName");
    	        	String  date_db=rs.getString("birthDay");
    	        	int gender_db=rs.getInt("gender");
    	        	String gender_x;
    	        	if(gender_db==1)
    	        	{
    	        		gender_x="Nam";	
    	        	}
    	        	else
    	        	{
    	        		gender_x="Nu";
    	        	}
    	        
    	        	User a=new User(username_db, password_db, firstName_db,lastName_db, middleName_db,date_db,gender_x);
    	        	userList.add(a);
    	         }
    	      } catch (SQLException e) {
    	         e.printStackTrace();
    	      } 
    	   }
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
   
    public static final void  WriteData()
    {
    	try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            Scanner scanner=new Scanner(System.in);
	        System.out.print("Enter the number User: ");
	        int n=scanner.nextInt();
	        scanner.nextLine();
		        for(int i=0; i<n ;i++)
		        {
		            User a=new User();
		            a.EnterInformation();
		            int gender_;
		            if(a.getGender().equals("Name"))
		            {
		            	gender_=1;
		            }
		            else
		            {
		            	gender_=0;
		            }
		            a.writeFile("text.txt");
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                String currentDateandTime = sdf.format(new Date());
		            String query="INSERT INTO user(userName, password, firstName, lastName, middleName, fullName, birthDay,gender, createdAt, createdBy, updateAt, updateBy, role)";
		            query+=" VALUES('"+a.getUserName()+"','"+a.getPassword()+"','"+a.getFirstName()+"','"+a.getLastName()+"','"+a.getMiddleName()+"','"+a.getFullName()+"','"+a.getBirthDay()+"',"+gender_+",'"+currentDateandTime+"','Admin','"+currentDateandTime+"','Admin',1)";
		            stmt.executeUpdate(query);
		        }
            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
        }
    	
    }
  
    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
    	System.out.print("Choose: \n 1.Enter new User: \t 2.Display List User From File Text: \t 3.Display list user from Database: \n");
    	String c=scanner.nextLine();
    	 userList=new ArrayList<>();
    	if(c.equals("1"))
    	{
    		 User.WriteData();
    	}
    	else
    	{
	        if(c.equals("2"))
	        {
	        	  User.readFile("text.txt");
	        
		        for(int i=0; i<userList.size() ;i++)
		        {
		           
		           
		            userList.get(i).printUser();
		
		        }
	        }
	        else
	        {
	        	
	        	if(c.equals("3"))
	            {
	            	  User.ReadDatabase();
	    	        for(int i=0; i<userList.size() ;i++)
	    	        {
	    	           
	    	           
	    	            userList.get(i).printUser();
	    	
	    	        }
	            }
	        	
	        }   
       
    	}
    
    }
}
