package com.wiscom.backend.exception;

public class WorkNotInCategoryException extends RuntimeException {
    public WorkNotInCategoryException(Long id, String category) {
        super(" ID가 " + id + "인 작품의 카테고리가 " + category + "이 아닙니다.");
    }
}
