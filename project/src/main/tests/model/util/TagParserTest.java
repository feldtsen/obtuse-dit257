package model.util;

import application.ResourceLoader;
import application.model.util.TagParser;
import org.junit.Test;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TagParserTest {

    private String testFilePath = ResourceLoader.tagsFile + ".test"; //new path to test file tags.csv.test

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

        try {
            TagParser newParser = new TagParser(testFilePath, "#");
        } catch (IOException e) {
            System.out.println("Couldn't read the file!");
        }
    }

    @Test
    public void correctFilePathTest(){
    }
}
