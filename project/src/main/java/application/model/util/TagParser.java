package application.model.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TagParser {
    private String filePath;    //Input file which needs to be parsed
    private String delimiter;
    private Map<String, List<String>> fileMap;  //a map with category as key and tags as values


    public TagParser(String filePath, String delimiter) throws IOException {
        this.filePath=filePath;
        this.delimiter=delimiter;
        prepareData(filePath, delimiter);
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDelimiter() {
        return delimiter;
    }

    /**
     * This method convert a file with the following format
     * category<delimiter><category-name><delimiter>tags<delimiter><tag1> and so on in every line of the file
     * into a Hashmap with category as key and tags as a value
     * @param filePath the file that need to be converted
     * @param delimiter what type of delimiter each word is separated with
     * @throws IOException if file not found or other reading errors occur
     */
    private void prepareData(String filePath, String delimiter) throws IOException {
        BufferedReader myReader = new BufferedReader(new FileReader(filePath));
        String aLine = "";
        ArrayList<String> anArray = new ArrayList<>();
        fileMap = new HashMap<>();
        while( (aLine = myReader.readLine()) != null) {
            String[] arrayLine = aLine.split(delimiter);   //convert a string line to an array of strings

            // index 1 is the category name and index 3 is the start of the tags in the line
            fileMap.put(arrayLine[1], new ArrayList<>());   // set category as key

            for(int i=3; i<arrayLine.length; i++)
                fileMap.get(arrayLine[1]).add(arrayLine[i]);    //add the rest of line as HashMap value for category key
        }
        myReader.close();
    }

    /**
     * Gives a set of all categories in file tags.csv
     * @return a set of categories
     */
    public HashSet<String> getAllCategories(){
        HashSet<String> mySet = new HashSet<>();
        for(String aCategory: fileMap.keySet())
            mySet.add(aCategory);
        return mySet;
    }

    /**
     * Gives a set of all tags in file tags.csv
     * @return a set of tags
     */
    public HashSet<String> getAllTags(){
        Collection<List<String>> values = fileMap.values();
        HashSet<String> mySet = new HashSet<>();
        for(List aList: values)
            for(Object aTag: aList)
                mySet.add((String)aTag);
        return mySet;
    }

    /**
     * Gives a set of all tags for the category specified below in file tags.csv
     * @param category the category for which the tags are returned
     * @return a set of tags for the specified category
     */
    public HashSet<String> getTagsForCategory (String category) {
        HashSet<String> mySet = new HashSet<>();
        for(String aTag: fileMap.get(category))
            mySet.add(aTag);
        return mySet;
    }
}
