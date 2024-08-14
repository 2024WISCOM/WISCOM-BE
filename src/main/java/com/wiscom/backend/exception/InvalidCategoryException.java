package com.wiscom.backend.exception;

public class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException(String category) {
        super("카테고리 이름이 " + category + "인 카테고리를 찾을 수 없습니다.");
    }
}
