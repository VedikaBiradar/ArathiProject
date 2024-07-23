package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.ReachOut;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.ReachOutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ReachOutService {

    private ReachOutRepository reachOutRepository;

    @Autowired
    public ReachOutService(ReachOutRepository reachOutRepository) {
        this.reachOutRepository = reachOutRepository;
    }


    public void saveMessage(ReachOut reachOut) {
        reachOutRepository.save(reachOut);
    }


}
