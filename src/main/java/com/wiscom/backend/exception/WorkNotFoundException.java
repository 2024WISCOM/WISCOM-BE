package com.wiscom.backend.exception;

public class WorkNotFoundException extends RuntimeException {
    public WorkNotFoundException(Long id) {
      super("ID가 " + id + "인 작품 데이터를 찾을 수 없습니다.");
    }
}
