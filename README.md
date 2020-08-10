# MiniProjectBabyNames
This program read CSV file of USA baby Name(1880-2014) to get useful information for better analysis and better understanding of each file.

<img align="center" width="450" height="300" src=https://user-images.githubusercontent.com/53362962/89644546-c43a2500-d8d5-11ea-828d-9314ce3e25eb.PNG>

## Description of each above test functions.<img align="right" width="250" height="150" src=https://user-images.githubusercontent.com/53362962/89645758-2005ad80-d8d8-11ea-9080-f37a6bed2fe9.jpg>
* **testTotalBirths()** - is use to print the number of girls names,the number of boys names and the total names in the file.
* **testGetRank()** - This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.
* **testGetName()** -  This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.
* **testWhatIsNameInYear()** - This method determines what given name would have been named if they were born in a different year, based on the same popularity.
* **testYearOfHighestRank()** - This method selects a range of files to process and returns an integer, the year with the highest rank for the given name and gender. 
* **testGetAverageRank()** - This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
* **testGetTotalBirthsRankedHigher()** - This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than the given name.
   
