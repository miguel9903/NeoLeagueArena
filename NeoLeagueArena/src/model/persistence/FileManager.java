package model.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Coach;
import model.Player;
import model.Team;
import model.Game;

import model.persistence.dto.AdminDTO;
import model.persistence.dto.CoachDTO;
import model.persistence.dto.PlayerDTO;
import model.persistence.dto.TeamDTO;
import model.persistence.dto.GameDTO;

import model.persistence.mapper.AdminMapper;
import model.persistence.mapper.CoachMapper;
import model.persistence.mapper.PlayerMapper;
import model.persistence.mapper.TeamMapper;
import model.persistence.mapper.GameMapper;

/**
 * Clase para gestionar la lectura y escritura de objetos en archivos.
 * Permite manejar diferentes tipos de objetos como Admin, Coach, Player, Team y Game.
 *
 * @param <T> El tipo de objeto que se gestionará.
 */
public class FileManager<T> {

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private File fileLocation;

    /**
     * Constructor para inicializar el FileManager con una ruta de archivo específica.
     *
     * @param filePath La ruta del archivo donde se leerán o escribirán los objetos.
     */
    public FileManager(String filePath) {
        this.fileLocation = new File(filePath);

        try {
            File parentDir = fileLocation.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            if (!fileLocation.exists()) {
                fileLocation.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribe una lista de objetos en el archivo.
     *
     * @param objects   La lista de objetos a escribir en el archivo.
     * @param className La clase de los objetos para determinar el tipo de conversión.
     */
    public void writeToFile(ArrayList<T> objects, Class<T> className) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));

            if (className == Admin.class) {
                ArrayList<Admin> admins = (ArrayList<Admin>) (ArrayList<?>) objects;
                List<AdminDTO> dtos = AdminMapper.convertAdminListToAdminDTOList(admins);
                outputStream.writeObject(dtos);

            } else if (className == Coach.class) {
                ArrayList<Coach> coaches = (ArrayList<Coach>) (ArrayList<?>) objects;
                List<CoachDTO> dtos = CoachMapper.convertCoachListToCoachDTOList(coaches);
                outputStream.writeObject(dtos);

            } else if (className == Player.class) {
                ArrayList<Player> players = (ArrayList<Player>) (ArrayList<?>) objects;
                List<PlayerDTO> dtos = PlayerMapper.convertPlayerListToPlayerDTOList(players);
                outputStream.writeObject(dtos);

            } else if (className == Team.class) {
                ArrayList<Team> teams = (ArrayList<Team>) (ArrayList<?>) objects;
                List<TeamDTO> dtos = TeamMapper.convertTeamListToTeamDTOList(teams);
                outputStream.writeObject(dtos);

            } else if (className == Game.class) {
                ArrayList<Game> games = (ArrayList<Game>) (ArrayList<?>) objects;
                List<GameDTO> dtos = GameMapper.convertGameListToGameDTOList(games);
                outputStream.writeObject(dtos);

            } else {
                outputStream.writeObject(objects);
            }

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee una lista de objetos desde el archivo.
     *
     * @param className La clase de los objetos para determinar el tipo de conversión.
     * @return La lista de objetos leídos desde el archivo.
     */
    public ArrayList<T> readFromFile(Class<T> className) {
        ArrayList<T> objects = null;

        if (fileLocation.length() != 0) {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(fileLocation));

                if (className == Admin.class) {
                    List<AdminDTO> dtos = (List<AdminDTO>) inputStream.readObject();
                    List<Admin> adminList = AdminMapper.convertAdminDTOListToAdminList(dtos);
                    objects = new ArrayList<>((List<T>) adminList);

                } else if (className == Player.class) {
                    List<PlayerDTO> dtos = (List<PlayerDTO>) inputStream.readObject();
                    List<Player> playerList = PlayerMapper.convertPlayerDTOListToPlayerList(dtos);
                    objects = new ArrayList<>((List<T>) playerList);

                } else if (className == Coach.class) {
                    List<CoachDTO> dtos = (List<CoachDTO>) inputStream.readObject();
                    List<Coach> coachList = CoachMapper.convertCoachDTOListToCoachList(dtos);
                    objects = new ArrayList<>((List<T>) coachList);

                } else if (className == Team.class) {
                    List<TeamDTO> dtos = (List<TeamDTO>) inputStream.readObject();
                    List<Team> teamList = TeamMapper.convertTeamDTOListToTeamList(dtos);
                    objects = new ArrayList<>((List<T>) teamList);

                } else if (className == Game.class) {
                    List<GameDTO> dtos = (List<GameDTO>) inputStream.readObject();
                    List<Game> gameList = GameMapper.convertGameDTOListToGameList(dtos);
                    objects = new ArrayList<>((List<T>) gameList);

                }

                inputStream.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return objects;
    }

    /**
     * Obtiene el ObjectInputStream utilizado para leer desde el archivo.
     *
     * @return El ObjectInputStream.
     */
    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    /**
     * Establece el ObjectInputStream utilizado para leer desde el archivo.
     *
     * @param inputStream El nuevo ObjectInputStream.
     */
    public void setInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Obtiene el ObjectOutputStream utilizado para escribir en el archivo.
     *
     * @return El ObjectOutputStream.
     */
    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * Establece el ObjectOutputStream utilizado para escribir en el archivo.
     *
     * @param outputStream El nuevo ObjectOutputStream.
     */
    public void setOutputStream(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Obtiene la ubicación del archivo.
     *
     * @return El archivo asociado a este FileManager.
     */
    public File getFileLocation() {
        return fileLocation;
    }

    /**
     * Establece la ubicación del archivo.
     *
     * @param fileLocation El nuevo archivo asociado a este FileManager.
     */
    public void setFileLocation(File fileLocation) {
        this.fileLocation = fileLocation;
    }
}

