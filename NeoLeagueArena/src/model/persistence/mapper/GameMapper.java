package model.persistence.mapper;

import model.Game;
import model.enums.GameGenre;
import model.enums.GameMode;
import model.enums.GamePlatform;
import model.persistence.dto.GameDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para mapear entre objetos Game y GameDTO.
 */
public class GameMapper {

    /**
     * Convierte un objeto GameDTO a un objeto Game.
     *
     * @param dto El objeto GameDTO a convertir.
     * @return El objeto Game convertido, o null si el DTO es null.
     */
    public static Game convertGameDTOToGame(GameDTO dto) {
        if (dto == null) return null;

        GameGenre genre = dto.getGenre() != null ? GameGenre.valueOf(dto.getGenre().toUpperCase()) : null;
        GamePlatform platform = dto.getPlatform() != null ? GamePlatform.valueOf(dto.getPlatform().toUpperCase()) : null;

        List<GameMode> modes = new ArrayList<>();

        if (dto.getModes() != null) {
            for (String mode : dto.getModes()) {
                if (mode != null) {
                    modes.add(GameMode.valueOf(mode.toUpperCase()));
                }
            }
        }

        return new Game(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getLogo(),
                genre,
                platform,
                modes
        );
    }

    /**
     * Convierte un objeto Game a un objeto GameDTO.
     *
     * @param game El objeto Game a convertir.
     * @return El objeto GameDTO convertido, o null si el Game es null.
     */
    public static GameDTO convertGameToGameDTO(Game game) {
        if (game == null) return null;

        GameDTO dto = new GameDTO();

        dto.setId(game.getId());
        dto.setName(game.getName());
        dto.setDescription(game.getDescription());
        dto.setLogo(game.getLogo());

        dto.setGenre(game.getGenre() != null ? game.getGenre().name() : null);
        dto.setPlatform(game.getPlatform() != null ? game.getPlatform().name() : null);

        List<String> modeStrings = new ArrayList<>();

        if (game.getModes() != null) {
            for (GameMode mode : game.getModes()) {
                if (mode != null) {
                    modeStrings.add(mode.name());
                }
            }
        }

        dto.setModes(modeStrings);

        return dto;
    }

    /**
     * Convierte una lista de objetos GameDTO a una lista de objetos Game.
     *
     * @param dtoList La lista de objetos GameDTO a convertir.
     * @return La lista de objetos Game convertidos.
     */
    public static List<Game> convertGameDTOListToGameList(List<GameDTO> dtoList) {
        List<Game> games = new ArrayList<>();
        if (dtoList != null) {
            for (GameDTO dto : dtoList) {
                games.add(convertGameDTOToGame(dto));
            }
        }
        return games;
    }

    /**
     * Convierte una lista de objetos Game a una lista de objetos GameDTO.
     *
     * @param gameList La lista de objetos Game a convertir.
     * @return La lista de objetos GameDTO convertidos.
     */
    public static List<GameDTO> convertGameListToGameDTOList(List<Game> gameList) {
        List<GameDTO> dtos = new ArrayList<>();
        if (gameList != null) {
            for (Game game : gameList) {
                dtos.add(convertGameToGameDTO(game));
            }
        }
        return dtos;
    }
}

