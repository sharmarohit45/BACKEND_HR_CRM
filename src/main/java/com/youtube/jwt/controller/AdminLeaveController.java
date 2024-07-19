package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.AdminLeave;
import com.youtube.jwt.entity.Deals;
import com.youtube.jwt.entity.Designations;
import com.youtube.jwt.entity.Proposal;
import com.youtube.jwt.entity.ProposalProduct;
import com.youtube.jwt.service.AdminLeaveService;

@RestController
public class AdminLeaveController {
	@Autowired
	private AdminLeaveService adminLeaveService;

	@PostMapping("/leaves")
	public ResponseEntity<AdminLeave> saveLeave(@RequestBody AdminLeave adminLeave)
	{
		AdminLeave saveleave = adminLeaveService.saveLeave(adminLeave);
		return ResponseEntity.ok(saveleave);
	}
	@GetMapping("/leaves")
	 public List<AdminLeave> getAllLeaves() {
       return adminLeaveService.getAllLeaves();
   }
	@GetMapping("/leaves/{id}")
    public ResponseEntity<AdminLeave> getLeaveById(@PathVariable Long id) {
        AdminLeave leave = adminLeaveService.getLeaveById(id);
        return ResponseEntity.ok(leave);
    }

    @PutMapping("/leaves/{id}")
    public ResponseEntity<AdminLeave> updateLeave(@PathVariable Long id, @RequestBody AdminLeave adminLeave) {
        AdminLeave updatedLeave = adminLeaveService.updateLeave(id, adminLeave);
        return ResponseEntity.ok(updatedLeave);
    }

    @DeleteMapping("/leaves/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        adminLeaveService.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }

}
