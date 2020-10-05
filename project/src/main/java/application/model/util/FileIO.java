package application.model.util;

import java.io.*;

public class FileIO {

    /**
     * Load an object
     * @param path the path of the object
     * @return the object otherwise
     *          null
     * Writes a message to console in case of file not found or loading failed.
     */
    public static Object loadObject (String path){
        Object object = null;
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loading of object failed");
        }
        return object;
    }

    // Saves a particular object to disk.
    public static void saveObject(Serializable object, String path) throws IOException {
        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        outputStream.close();
    }

}
