import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Account> users = new ArrayList<>();
        boolean exit = false;
        boolean loggedIn = false;
        Account loggedInAccount = new Account("IF YOU","SEE THIS","THAT'S BAD");

        Scanner scanner = new Scanner(System.in);
        while(!exit) {
            if(loggedIn){
                System.out.println("logged in as: " + loggedInAccount.getName());
            }
            System.out.println("[0] Exit\n[1]new account\n[2]login with account\n[3]Upload a Picture\n[4]Show account\n[5]like a picture\n[6]See likes of a picture");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("enter a name:");
                    String name = scanner.nextLine();
                    System.out.println("enter an email:");
                    String email = scanner.nextLine();
                    System.out.println("enter a password:");
                    String password = scanner.nextLine();
                    users.add(new Account(name,email,password));
                    break;
                case 2:
                    System.out.println("enter your email:");
                    String lEmail = scanner.nextLine();
                    System.out.println("enter your name:");
                    String lName = scanner.nextLine();
                    System.out.println("enter your password:");
                    String lPassword = scanner.nextLine();
                    int index = -1;
                    for(int i = 0; i < users.size(); i++){
                        if(users.get(i).getEmail().equals(lEmail)){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("User not found");
                    }
                    else{
                        if(users.get(index).login(lName,lPassword)){
                            loggedIn = true;
                            loggedInAccount = users.get(index);
                            System.out.println("Success");
                        }
                        else{
                            System.out.println("Your Credentials were not correct");
                        }
                    }
                    break;
                case 3:
                    if(loggedIn){
                        System.out.println("enter the path to your picture");
                        String picturePath = scanner.nextLine();
                        System.out.println("Do you want this picture as profile picture? Y/N");
                        String selection = scanner.nextLine();
                        if(selection.equals("Y") || selection.equals("y")){
                            loggedInAccount.setProfilePicture(picturePath);
                        }
                        else{
                            if(loggedInAccount.uploadPicture(picturePath)){
                                System.out.println("Your Picture was successfully uploaded");
                            }
                        }
                    }
                    else{
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("Enter the name for the account that you want to see");
                    String accountToShow = scanner.nextLine();
                    index = -1;
                    for(int i = 0; i < users.size(); i++){
                        if(users.get(i).getName().equals(accountToShow)){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("The account was not found");
                    }
                    else {
                        System.out.println("Username: " + users.get(index).getName());
                        System.out.println("Email: " + users.get(index).getEmail());
                        System.out.println("Profile picture:" + users.get(index).getProfilePicture());
                    }
                    break;
                case 5:
                    System.out.println("Enter the name for the account that you want to like a picture from");
                    accountToShow = scanner.nextLine();
                    index = -1;
                    for(int i = 0; i < users.size(); i++){
                        if(users.get(i).getName().equals(accountToShow)){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("The account was not found");
                    }
                    else {
                        for(int i = 0; i < users.get(index).showPictures().size(); i++){
                            System.out.println("[" + i + "]" + users.get(index).showPictures().get(i).getPath());
                        }
                        System.out.println("Please select the picture from the list above");
                        int index2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("this is the amount of likes, including the one you added: " + users.get(index).showPictures().get(index2).like());
                    }
                    break;
                case 6:
                    System.out.println("Enter the name for the account that you want to see the likes from a picture");
                    accountToShow = scanner.nextLine();
                    index = -1;
                    for(int i = 0; i < users.size(); i++){
                        if(users.get(i).getName().equals(accountToShow)){
                            index = i;
                        }
                    }
                    if(index == -1){
                        System.out.println("The account was not found");
                    }
                    else {
                        for(int i = 0; i < users.get(index).showPictures().size(); i++){
                            System.out.println("[" + i + "]" + users.get(index).showPictures().get(i).getPath());
                        }
                        System.out.println("Please select a picture from the list above");
                        int index2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("this is the amount of likes: " + users.get(index).showPictures().get(index2).getLikes());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
