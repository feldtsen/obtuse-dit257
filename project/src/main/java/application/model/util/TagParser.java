package application.model.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TagParser {
    final String DELIMITER = "#";
    //Input file which needs to be parsed
    String fileToParse = "";
    BufferedReader fileReader = null;

    public TagParser(){

    }

    public String[] getAllCategories(){
        String[] result = new String[10];
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
            int kategorinr = 0;
            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                for(int i = 0; i < tokens.length; i++)
                {
                    if (tokens[i].equals("kategori")){
                        result[kategorinr] = tokens[i+1];
                        kategorinr++;
                    }
                }
            }
            for (String kategori : result){
                System.out.println(kategori);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String[] getAllTags(){
        String[] result = new String[10];
        return result;
    }
}
