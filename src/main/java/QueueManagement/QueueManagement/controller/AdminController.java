package QueueManagement.QueueManagement.controller;

import QueueManagement.QueueManagement.dto.AdminDto;
import QueueManagement.QueueManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminDto> registerAdmin(@RequestBody AdminDto adminDto) {
        return ResponseEntity.ok(adminService.registerAdmin(adminDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestParam String email,
                                             @RequestParam String password) {
        AdminDto dto = adminService.loginAdmin(email, password);
        if (dto != null) {
            return ResponseEntity.ok("Login successful! Welcome " + dto.getName());
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
