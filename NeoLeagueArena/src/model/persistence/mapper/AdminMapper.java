package model.persistence.mapper;

import model.Admin;
import model.persistence.dto.AdminDTO;

import java.util.ArrayList;
import java.util.List;

public class AdminMapper {

    public static Admin convertAdminDTOToAdmin(AdminDTO dto) {
        if (dto == null) return null;

        return new Admin(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getCountry(),
                dto.getCity()
        );
    }

    public static AdminDTO convertAdminToAdminDTO(Admin admin) {
        if (admin == null) return null;

        AdminDTO dto = new AdminDTO();

        dto.setId(admin.getId());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        dto.setCountry(admin.getCountry());
        dto.setCity(admin.getCity());

        return dto;
    }

    public static List<AdminDTO> convertAdminListToAdminDTOList(List<Admin> admins) {
        List<AdminDTO> dtos = new ArrayList<>();
        
        if (admins != null) {
            for (Admin admin : admins) {
                dtos.add(convertAdminToAdminDTO(admin));
            }
        }
        
        return dtos;
    }

    public static List<Admin> convertAdminDTOListToAdminList(List<AdminDTO> dtos) {
        List<Admin> admins = new ArrayList<>();
        
        if (dtos != null) {
            for (AdminDTO dto : dtos) {
                admins.add(convertAdminDTOToAdmin(dto));
            }
        }
        
        return admins;
    }
}
