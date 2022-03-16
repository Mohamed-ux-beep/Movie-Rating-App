package dbadapter;


public class Info {
   private int id;
   private String name;
   private String Email;
   private int Age;
   private int password;


   
   public Info(String name, String email, int age, int password) {
		
		this.name = name;
		this.Email = email;
		this.Age = age;
		this.password = password;
	}




   //getter and setters

   

   public int getId() {
       return id;
   }


	public void setId(int id) {
       this.id = id;
   }

   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public String getEmail() {
       return Email;
   }
   public void setEmail(String email) {
       Email = email;
   }
   public int getAge() {
       return Age;
   }
   public void setAge(int age) {
       Age = age;
   }
   
	public int getPassword() {
		return password;
	}




	public void setPassword(int password) {
		this.password = password;
	}

}