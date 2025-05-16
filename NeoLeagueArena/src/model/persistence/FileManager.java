package model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager<T> {

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private File fileLocation;

    public FileManager(String filePath) {
        this.fileLocation = new File(filePath);
        
        if (!fileLocation.exists()) {
            try {
                fileLocation.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(ArrayList<T> objects) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
            outputStream.writeObject(objects);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> readFromFile() {
        ArrayList<T> objects = null;
        if (fileLocation.length() != 0) {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(fileLocation));
                objects = (ArrayList<T>) inputStream.readObject();
                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return objects;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public File getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(File fileLocation) {
        this.fileLocation = fileLocation;
    }
	
}
