
/**
 * Write a description of BabyNames here.
 * This program read CSV file of USA baby Name(1880-2014) to get useful informations for better analysis 
 * and better understanding of each file.
 * @author (Yashi Saxena) 
 * @version (07/08/2020)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File.*;
import java.io.*;
import java.util.*;
public class BabyNames {
    
   public void totalBirths(FileResource fr)
   {
       int totalBirth=0; int totalBoys=0; int totalGirls=0;
       for(CSVRecord rec : fr.getCSVParser(false))
       {
           int num= Integer.parseInt(rec.get(2));
           totalBirth +=num;
           if(rec.get(1).equals("F"))
           {
              totalGirls +=1;
           }
           else
           {
               totalBoys +=1;
            }
       }
         System.out.println("Total Names " +totalBirth);
         System.out.println("Number of girl's names " +totalGirls);
         System.out.println("Number of boy's names " +totalBoys);
   }
   //testTotalBirths() is use to print the number of girls names,the number of boys names and the total names in the file.
   public void testTotalBirths()
   {
       FileResource fr = new FileResource();
       totalBirths(fr);
   }
   
   public int getRank(int year, String name, String gender)
   {
      int rank =0;
      String fname= "C://Users//Admin//Desktop//Yashi saxena prog//BabyNames//us_babynames//us_babynames_by_year//yob"+year+".csv"; 
      FileResource fr= new FileResource(fname);
      for(CSVRecord rec : fr.getCSVParser(false))
       { 
        if(rec.get(1).equals(gender))
        {
            rank += 1;
        }
        if(rec.get(0).equals(name)&&rec.get(1).equals(gender))
        {
            return rank;
        }
       }
       return  -1;
   }
   //testGetRank()- This method returns the rank of the name in the file for the given gender, 
   //where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.
   public void testGetRank()
   {
       int rank=  getRank(1971,"Frank","M");
       System.out.println("The rank of name is " +rank);
   }
  
     public String getName(int year, int rank, String gender)
   { 
      String fname= "C://Users//Admin//Desktop//Yashi saxena prog//BabyNames//us_babynames//us_babynames_by_year//yob"+year+".csv"; 
      FileResource fr= new FileResource(fname); int count=0;
       for(CSVRecord rec : fr.getCSVParser(false))
       { 
        if(rec.get(1).equals(gender)) 
        {
          count+= 1;
          if(count == rank)
          {
              return rec.get(0);
          }
        }
       }
       return "NO NAME";
   }
   //testGetName()-  This method returns the name of the person in the file at this rank, for the given gender,
   //where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.
    public void testGetName()
   {
       String name=  getName(1982, 450,"M");
       System.out.println(" Name a/q to provided rank is " +name);
   }
   
   public void whatIsNameInYear(String name, int year, int newyear, String gender)
   {
       int rankyear = getRank(year,name,gender);
       String newName = getName(newyear,rankyear,gender);
       System.out.println(name +" born in " +year +" would be " +newName +" if she was born in " +newyear +".");
   }
   //testWhatIsNameInYear()- This method determines what given name would have been named if they were born in a different year, 
   //based on the same popularity.
   public void testWhatIsNameInYear()
   {
       whatIsNameInYear("Owen",1974,2014,"M");
   }
   
   public int yearOfHighestRank(String name, String gender)
   {
       DirectoryResource dr = new DirectoryResource();int currentyear = 0;int currentRank= 0;
        int highrankyear=0;int highrank=0;
       for(File f: dr.selectedFiles())
       {
          String fname = f.getName();
          currentyear = Integer.parseInt(fname.substring(3,7));
          currentRank= getRank(currentyear,name,gender);
          if(currentRank!=-1&&highrankyear==0&&highrank==0)
          {
             highrankyear= currentyear;
             highrank= currentRank;
          }
          if(currentRank!=-1&&highrank>currentRank)
           {
              highrank = currentRank; 
              highrankyear= currentyear;
           }
       }
       if(highrank==0)
        {
           return -1;
        }
       else
       return highrankyear;
   }
   //testYearOfHighestRank()- This method selects a range of files to process and returns an integer, the year with the highest rank for the given name and gender. 
   public void testYearOfHighestRank()
   {
    int year = yearOfHighestRank("Mich","M");
    System.out.println("Given name's highest ranking was in " +year);
   }
   
   public double getAverageRank(String name, String gender)
   {
      int currentyear = 0;int currentRank= 0; int totalRank=0; int avg=0;
      DirectoryResource dr = new DirectoryResource();
      for(File f: dr.selectedFiles())
      {
         String fname = f.getName();
         currentyear = Integer.parseInt(fname.substring(3,7));
         currentRank= getRank(currentyear,name,gender);
         if(currentRank!=-1)
         {
          totalRank+= currentRank;
          avg +=1;
         }   
      }
      if(totalRank==0)
      {
         return -1;
      }
      return ((double)totalRank/avg);
   }
   //testGetAverageRank()- This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
   public void testGetAverageRank()
   {
       double avg = getAverageRank("Robert", "M");
       System.out.println("Average rank of the name in selected file " +avg);
   }
   
   public int getTotalBirthsRankedHigher(int year, String name, String gender)
   {
      int totalBirth=0; int  count=0;
      String fname= "C://Users//Admin//Desktop//Yashi saxena prog//BabyNames//us_babynames//us_babynames_by_year//yob"+year+".csv"; 
      FileResource fr= new FileResource(fname); 
      int rank=getRank(year,name,gender);
      if(rank==-1)
      {
          return -1;
      }
      for(CSVRecord rec :fr.getCSVParser(false))
       { 
           if(rec.get(1).equals(gender))
           {
             count+=1;
           }
           if(rec.get(1).equals(gender)&&count<rank)
           {
              int num= Integer.parseInt(rec.get(2));
              totalBirth +=num;
           }  
       }
       if(totalBirth==0)
       {
        return 0;
       }
       return totalBirth;
   }
   //testGetTotalBirthsRankedHigher()- This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than given name.
   public void testGetTotalBirthsRankedHigher()
   {
    int num = getTotalBirthsRankedHigher(1990,"Drew","M");
    if(num==-1)
    {
      System.out.println("The given name not found in file");
    }
     else if (num==0)
      {
         System.out.println("The given name has highest rank in file");
      }
    else
    {
    System.out.println("Total number of births ranked higher than given name " +num);
    }
   }
   
}
