package application.model.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TagParser {
    final String DELIMITER = "#";
    //Input file which needs to be parsed
    String fileToParse = "tags.csv";
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
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
            int tagnr = 0;
            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                for(int i = 0; i < tokens.length; i++)
                {
                    if(tokens[i].equals("tags")){
                        for(int j = 1; j < tokens.length-i; j++) {
                            result[tagnr] = tokens[i + j];
                            tagnr++;
                        }
                    }
                }
            }
            for (String tags : result){
                System.out.println(tags);
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

    public String[] getTagsForCategory (String kategori) {
        String[] result = new String[10];
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
            int tagkatnr = 0;
            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                for(int i = 0; i < tokens.length; i++)
                {
                    if(tokens[i].equals(kategori)){
                        result[tagkatnr] = tokens[i+1];
                        tagkatnr++;
                        int k = i+2;
                        while (!(tokens[k].equals("kategori"))){
                            result[tagkatnr] = tokens[k];
                            tagkatnr++;
                            if (k < tokens.length-1) {
                                k++;
                            } else {
                                break;
                            }                        }
                    }
                }
            }
            for (String category : result){
                System.out.println(category);
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
}
