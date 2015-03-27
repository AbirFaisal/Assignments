//package com.GroupB;
//
///**
// * Created by abirfaisal on 3/23/15.
// */
//public class PrintRecords {
//
//    public static void print(Animal[] animalArray){
//
//
//
//        //Determine spacing based on name longest length
//        //String to hold spaces
//        String space = "";
//        //Get number of spaces to generate
//        int spaceIterations = Name.getConcatNameLength(animalArray);
//        //Add spaces
//        for (int i = 0; i < spaceIterations; i++) {
//
//            space = space.concat(" ");
//
//        }
//
//
//        //Print Header
//        System.out.print("# Name" + space + " Gender  " + "Salary \n");
//
//        //Go through array and print each record
//        for (int i = 0; i < animalArray.length; i++) {
//
//            //Determine spacing for record based on record length
//            //String to hold spaces
//            String recordSpace = "";
//            //Get number of spaces to generate
//
//            //store lengths
//            int tempfirst = animalArray[i].getName().getFirstName().length();
//            int tempMiddle = animalArray[i].getName().getMiddleName().length();
//            int tempLast = animalArray[i].getName().getLastName().length();
//
//            //record name length
//            int recordLength = tempfirst + tempMiddle + tempLast;
//            //calculate amount of space between name and gender
//            int recordSpaceIterations = spaceIterations - recordLength + 3;
//            //Add spaces
//            for (int d = 0; d < recordSpaceIterations; d++) {
//                recordSpace = recordSpace.concat(" ");
//            }
//
//            //Print out record
//            System.out.printf("%d %s %s %s" + recordSpace + "%s  $%s \n",
//                    (i+1),
//                    animalArray[i].getName().getFirstName(),
//                    animalArray[i].getName().getMiddleName(),
//                    animalArray[i].getName().getLastName(),
//                    genderToMaleFemale(i, animalArray),
//                    animalArray[i].getSalary());
//        }
//    }
//
//
//
//
//}
