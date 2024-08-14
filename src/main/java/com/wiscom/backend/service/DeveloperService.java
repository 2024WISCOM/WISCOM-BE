package com.wiscom.backend.service;

import com.wiscom.backend.dto.developer.DeveloperNameDTO;
import com.wiscom.backend.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public List<DeveloperNameDTO> getAllDevelopers() {
        return developerRepository.findAll().stream()
                .map(DeveloperNameDTO::new)
                .collect(Collectors.toList());
    }
}
