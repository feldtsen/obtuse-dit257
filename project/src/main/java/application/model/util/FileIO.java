package application.model.util;

import java.io.*;

public class FileIO {
    // Loads an object from disk. Returns null and writes a message to console if
    // loading failed.
    public static Object loadObject (String path){
        Object object = null;
        try {
            // Create file with specified path
            File file = new File(path);

            // Open input streams
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // Read object
            object = objectInputStream.readObject();

            // Close streams
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
        // Create file for specified path
        File file = new File(path);

        // Open streams
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // Write to disk
        objectOutputStream.writeObject(object);

        // Close streams
        objectOutputStream.close();
        outputStream.close();
    }

}
