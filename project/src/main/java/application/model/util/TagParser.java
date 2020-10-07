package application.model.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TagParser {
    private final String path;    //Input file which needs to be parsed
    private final String delimiter;
    private Map<String, List<String>> tagsByCategory;  //a map with category as key and tags as values


    public TagParser(String path, String delimiter) throws IOException {
        this.path =path;
        this.delimiter=delimiter;
        prepareData(path, delimiter);
    }

    public String getPath() {
        return path;
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
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        tagsByCategory = new HashMap<>();
        String line = "";
        while( (line = reader.readLine()) != null) {
            String[] words = line.split(delimiter);   //convert a string line to an array of strings

            // index 1 is the category name and index 3 is the start of the tags in the line
            tagsByCategory.put(words[1], new ArrayList<>());   // set category as key

            for(int i = 3; i < words.length; i++)
                tagsByCategory.get(words[1]).add(words[i]);    //add the rest of line as HashMap value for category key
        }
        reader.close();
    }

    /**
     * Gives a set of all categories from the tags file
     * @return a set of categories
     */
    public Set<String> getAllCategories(){
        return new HashSet<>(tagsByCategory.keySet());
    }

    /**
     * Gives a set of all tags from the tags file
     * @return a set of tags
     */
    public Set<String> getAllTags(){
        HashSet<String> allTags = new HashSet<>();
        for(List<String> tagList: tagsByCategory.values())
            allTags.addAll(tagList);
        return allTags;
    }

    /**
     * Gives a set of all tags for the category specified below in the tags file
     * @param category the category for which the tags are returned
     * @return a set of tags for the specified category
     */
    public Set<String> getTagsForCategory (String category) {
        return new HashSet<>(tagsByCategory.get(category));
    }
}
