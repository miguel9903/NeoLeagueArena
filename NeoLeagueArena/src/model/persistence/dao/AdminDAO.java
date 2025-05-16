package model.persistence.dao;

import java.util.ArrayList;

import model.Admin;
import model.persistence.FileManager;
import utils.PersistencePaths;

public class AdminDAO implements InterfaceDAO<Admin> {

    private ArrayList<Admin> admins;
    private FileManager<Admin> fileManager;

    public AdminDAO() {
        fileManager = new FileManager<>(PersistencePaths.ADMINS_FILE);
        admins = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        ArrayList<Admin> loaded = fileManager.readFromFile();
        if (loaded != null) {
            admins = loaded;
        }
    }

    private void saveToFile() {
        fileManager.writeToFile(admins);
    }

    @Override
    public ArrayList<Admin> getAll() {
        return new ArrayList<>(admins);
    }

    @Override
    public String getAllAsString() {
        StringBuilder sb = new StringBuilder();
        for (Admin a : admins) {
            sb.append(a).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Admin admin) {
        if (find(admin) == null) {
            admins.add(admin);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        Admin found = find(admin);
        if (found != null) {
            admins.remove(found);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Admin oldAdmin, Admin newAdmin) {
        Admin existing = find(oldAdmin);
        if (existing != null) {
            admins.remove(existing);
            admins.add(newAdmin);
            saveToFile();
            return true;
        }
        return false;
    }

    @Override
    public Admin find(Admin admin) {
        for (Admin a : admins) {
            if (a.equals(admin)) {
                return a;
            }
        }
        return null;
    }
    
}
