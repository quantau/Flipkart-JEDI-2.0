package com.flipkart.client;



import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.GymOwnerServiceImpl;
import com.flipkart.business.GymCenterServiceImpl;

import java.util.List;
import java.util.Scanner;

import static com.flipkart.constants.Constants.INVALID_CHOICE_ERROR;
import static com.flipkart.constants.Constants.PREVIOUS_MENU_MESSAGE;

public class GymOwnerFlipfitMenu {

    public static Scanner scanner = new Scanner(System.in);

    GymOwnerServiceImpl gymOwnerService = new GymOwnerServiceImpl();
    GymCenterServiceImpl gymCentreService = new GymCenterServiceImpl();

    public boolean gymOwnerLogin(String userName, String password) {
        if(gymOwnerService.gymOwnerLogin(userName, password)){
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Successfully logged in as Gym Owner");
            gymOwnerClientMainPage(userName, password);
        }
        else{
            System.out.println("Invalid credentials");
        }
        return true;
    }

    public void register() {
        GymOwner registeredGymOwner = gymOwnerService.register();
        gymOwnerClientMainPage(registeredGymOwner.getUserName(), registeredGymOwner.getPassword());
//        gymOwnerClientMainPage(userName);
//        return userName;
    }

    public void gymOwnerChangePassword(String userName,String old_password,String new_password){
        gymOwnerService.gymOwnerChangePassword(userName, old_password, new_password);
    }

    public void gymOwnerClientMainPage(String userName, String password) {
        System.out.println("Welcome to gym owner main page!!");
        while(true) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("" +
                    "0. View all Gym Centres\n" +
                    "1. Send Gym Owner Approval Request\n" +
                    "2. Add new Gym Center\n" +
                    "3. Request Gym Centre Approval\n" +
                    "4. Add Slots to Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            System.out.println("---------------------------------------------------------------------------");
            int choice = scanner.nextInt();
            switch(choice){
                case 0:
//                    System.out.println("Gym cetres viewd\n");
                    List<GymCentre> allGymCentres = gymCentreService.getAllCentresByOwmerId(userName);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n",
                            "Centre Name", "Capacity", "City", "Amount per slot");
                    for(GymCentre gymcenter:allGymCentres ){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.printf("| %-10s | %-10s | %-20s | %-15s |\n",
                                gymcenter.getCentreName(), gymcenter.getCapacity(), gymcenter.getCity(), gymcenter.getAmountPerSlot());
                    }

                    break;

                case 1:
                    String gymOwnerId = gymOwnerService.getGymOwnerId(userName, password);
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    System.out.println("Gym owner request sent to Admin\n");
                    break;

                case 2:
                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre GSTIN: ");
                    String gstin = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.next();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    System.out.println("Enter price: : ");
                    float price = scanner.nextInt();




                    gymCentreService.addCenter(gymId,userName,gymCentreName,gstin,city,capacity,false,price );
                    System.out.println("New Gym center added\n");

                    break;

                case 3:
                    System.out.println("Gym Centre Approval Request sent to Admin\n");
                    break;

                case 4:
                    System.out.println("Slots added in the Gym centre\n");
                    break;

                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
            }
        }

    }
}