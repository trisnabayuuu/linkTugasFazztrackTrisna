package model;

import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String domicile;
    private String progrLangFav;
    private int bitrhYear;
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    public void setFirstName (String fName){
        firstName = fName;
    }
    public void setLastName (String lName){
        lastName = lName;
    }
    public void setDomicile (String domicileCity){
        domicile = domicileCity;
    }
    public void setProgrLangFav (String pFav){
        progrLangFav = pFav;
    }

    public void setBirthYear (String bYear){
        bitrhYear = Integer.parseInt(bYear);
    }

    public String getFullName (){
        return firstName + " " + lastName;
    }
    public String getDomicile (){
        return domicile;
    }
    public String getProgrLangFav (){
        return progrLangFav;
    }
    public int getAge (){
        return currentYear - bitrhYear;
    }

}
