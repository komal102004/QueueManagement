package QueueManagement.QueueManagement.service;

import QueueManagement.QueueManagement.dto.AdminDto;

public interface AdminService {
    AdminDto registerAdmin(AdminDto adminDto);
    AdminDto loginAdmin(String email, String password);
}
