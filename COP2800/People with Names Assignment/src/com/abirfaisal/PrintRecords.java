package com.abirfaisal;

/**
 * Created by abirfaisal on 2/21/15.
 */
public class PrintRecords {


    //Print out Records with proper spacing
    public static void print(Person[] personArray){



        //Determine spacing based on name longest length
        //String to hold spaces
        String space = "";
        //Get number of spaces to generate
        int spaceIterations = Name.getConcatNameLength(personArray);
        //Add spaces
        for (int i = 0; i < spaceIterations; i++) {

            space = space.concat(" ");

        }








        //Print Header
        System.out.print("# Name" + space + " Gender  " + "Salary \n");

        //Go through array and print each record
        for (int i = 0; i < personArray.length; i++) {

            //Determine spacing for record based on record length
            //String to hold spaces
            String recordSpace = "";
            //Get number of spaces to generate

            //store lengths
            int tempfirst = personArray[i].getName().getFirstName().length();
            int tempMiddle = personArray[i].getName().getMiddleName().length();
            int tempLast = personArray[i].getName().getLastName().length();

            //record name length
            int recordLength = tempfirst + tempMiddle + tempLast;
            //calculate amount of space between name and gender
            int recordSpaceIterations = spaceIterations - recordLength + 3;
            //Add spaces
            for (int d = 0; d < recordSpaceIterations; d++) {
                recordSpace = recordSpace.concat(" ");
            }

            //Print out record
            System.out.printf("%d %s %s %s" + recordSpace + "%s  $%s \n",
                    (i+1),
                    personArray[i].getName().getFirstName(),
                    personArray[i].getName().getMiddleName(),
                    personArray[i].getName().getLastName(),
                    genderToMaleFemale(i, personArray),
                    personArray[i].getSalary());
        }
    }


    //Returns gender as string
    public static String genderToMaleFemale(int index, Person[] array){

        if (array[index].isGender()) {
            return "Male  ";
        }else if (!array[index].isGender()){
            return "Female";
        }
        return null;
    }
}
