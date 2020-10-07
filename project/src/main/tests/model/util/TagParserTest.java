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
        Set<String> actualCategories = myParser.getAllCategories();
        Set<String> expectedCategories = new HashSet<>();
        expectedCategories.add("kött");
        expectedCategories.add("fryst");
        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void getAllTagsTest(){
        Set<String> actualTags = myParser.getAllTags();
        String expectedTag1 = "köttfärs";
        String expectedTag2 = "övrigt kött";
        String expectedTag3 = "köttbullar";
        String expectedTag4 = "övrigt fryst";
        assertTrue("Do tags contain köttfärs?", actualTags.contains(expectedTag1));
        assertTrue("Do tags contain övrigt kött?", actualTags.contains(expectedTag2));
        assertTrue("Do tags contain köttbullar?", actualTags.contains(expectedTag3));
        assertTrue("Do tags contain övrigt fryst?", actualTags.contains(expectedTag4));
    }

    @Test
    public void getTagsForCategory(){
        Set<String> actualCategoryTags = myParser.getTagsForCategory("fryst");
        Set<String> expectedCategoryTags = new HashSet<>();
        expectedCategoryTags.add("köttbullar");
        expectedCategoryTags.add("fiskpinnar");
        expectedCategoryTags.add("frysta grönsaker");
        expectedCategoryTags.add("övrigt fryst");
        assertEquals(expectedCategoryTags, actualCategoryTags);
    }
}
