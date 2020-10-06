package model.util;

import application.ResourceLoader;
import application.model.util.TagParser;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TagParserTest {

    private String testFilePath = ResourceLoader.tagsFile + ".test"; //new path to test file tags.csv.test
    private TagParser myParser;

    public TagParserTest(){
        createTestFile();
        try {
            myParser = new TagParser(testFilePath, "#");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    /**
     * Create tags.csv.test file with the following two lines inside it
     *   kategori#kött#tags#köttfärs#korv#kyckling#övrigt kött
     *   kategori#fryst#tags#köttbullar#fiskpinnar#frysta grönsaker#övrigt fryst
     */
    private void createTestFile(){
        try{
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(testFilePath));
            myWriter.write("kategori#kött#tags#köttfärs#korv#kyckling#övrigt kött");
            myWriter.newLine();
            myWriter.write("kategori#fryst#tags#köttbullar#fiskpinnar#frysta grönsaker#övrigt fryst");
            myWriter.newLine();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't write the file!");
        }
    }

    @Test
    public void getAllCategoriesTest(){
        HashSet<String> actualSet = myParser.getAllCategories();
        HashSet<String> expectedSet = new HashSet<>();
        expectedSet.add("kött");
        expectedSet.add("fryst");
        assertEquals(expectedSet, actualSet);
    }
}
