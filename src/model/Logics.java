package model;

import controller.MainViewController;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Guillermo Brugarolas on 07/05/2018.
 */
public class Logics {

    private static MainViewController mainViewController;

    public Logics() {
    }


    public boolean checkRegData(String regData, boolean checkRegPasswords){
        String[] array = new String[3];
        array = regData.split("/");
        if (!array[0].isEmpty()){
            if ((!array[1].isEmpty()) && (array[1].contains("@"))
                    && (array[1].contains("."))){
                if (array[2].length() >= 8) {
                    if (checkPassword(array[2])) {
                        if (checkRegPasswords) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkPassword(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

    public void registerMainViewController(MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    public User parseBasicUserData(String userData){
        int i=0, j=0, length;
        User user;
        Project p;
        LinkedList<Project> own, joined;
        String[] fullArray, first, second, third;
        own = new LinkedList<Project>();
        joined = new LinkedList<Project>();
        fullArray = new String[3];
        fullArray = userData.split("//");
        first = new String[3];
        first = fullArray[0].split(",");
//        second = fullArray[1].split(",");
//        length = second.length;
        user = new User(first[0], first[1], first[2], null, null);
//        for (i = 0; i < length; i++){
//            p = new Project(user, null, second[i], "", null, null, null);
//            own.add(p);
//        }
//        third = fullArray[2].split(",");
//        length = third.length;
//        for (i = 0; i < length; i++){
//            p = new Project(null, null, third[i], "", null, null, null);
//            joined.add(p);
//        }
//        user.setOwnProjects(own);
//        user.setJoinedProjects(joined);
        return user;
    }

    public String[] parseAllUsersData(String allUsersData){
        String[] usersList;
        usersList = allUsersData.split("/");
        return usersList;
    }
}
