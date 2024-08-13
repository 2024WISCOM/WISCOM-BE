package com.wiscom.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationResponseDTO<T> {
    private int status;               
    private String message;          
    private List<T> data;         
    private int totalPages;           
    private int currentPage;          
    private long totalElements;       
    private int pageSize;             

    
}
