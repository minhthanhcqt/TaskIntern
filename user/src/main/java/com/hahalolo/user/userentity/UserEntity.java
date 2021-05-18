package com.hahalolo.user.userentity;

public class UserEntity {
	private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private String birthDay;
    private String gender;
    
    public UserEntity(String userName, String password, String firstName, String lastName, String middleName,String birthDay, String gender)
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
    public UserEntity() {
		// TODO Auto-generated constructor stub
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFullName() {
        this.fullName = this.firstName+" "+this.lastName+" "+this.middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    
   
}
