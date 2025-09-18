package QueueManagement.QueueManagement.service.impl;

import QueueManagement.QueueManagement.dto.AdminDto;
import QueueManagement.QueueManagement.entity.Admin;
import QueueManagement.QueueManagement.repository.AdminRepository;
import QueueManagement.QueueManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminDto registerAdmin(AdminDto adminDto) {
        // DTO → Entity
        Admin admin = new Admin();
        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword()); // Future: hash this!

        // Save in DB
        Admin savedAdmin = adminRepository.save(admin);

        // Entity → DTO
        AdminDto responseDto = new AdminDto();
        responseDto.setName(savedAdmin.getName());
        responseDto.setEmail(savedAdmin.getEmail());
        responseDto.setPassword(savedAdmin.getPassword());

        return responseDto;
    }

    @Override
    public AdminDto loginAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!admin.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        // Entity → DTO
        AdminDto dto = new AdminDto();
        dto.setName(admin.getName());
        dto.setEmail(admin.getEmail());
        return dto;
    }// Future: throw custom exception
}
