package com.hahalolo.user.userrepositories;

import java.util.Scanner;

import com.hahalolo.user.userentity.UserEntity;

public class UserEnterInformation {
	public static final void EnterInformation( UserEntity userEntity)
    {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter userName : ");
        String username=scanner.nextLine();
        userEntity.setUserName(username);
        System.out.print("Enter Password: ");
        String password=scanner.nextLine();
        userEntity.setPassword(password);
        System.out.print("Enter FirstName: ");
        String firstName=scanner.nextLine();
        userEntity.setFirstName(firstName);;
        System.out.print("Enter LastName: ");
        String lastName=scanner.nextLine();
        userEntity.setLastName(lastName);;
        System.out.print("Enter MiddleName: ");
        String middleName=scanner.nextLine();
        userEntity.setMiddleName(middleName);;
        userEntity.setFullName();
        System.out.print("Enter BirthDay (yyyy-MM-dd): ");
        String dateString=scanner.nextLine();
        userEntity.setBirthDay(dateString);
        System.out.print("Enter gender: ");
        String gender=scanner.nextLine();
        userEntity.setGender(gender);
        scanner.close();
        
    }

}
