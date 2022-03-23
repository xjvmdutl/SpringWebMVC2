package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName;
    private String storeFileName; //파일 이름이 안겹치게 하기위해 //유일한 값

    //서로 같은 파일명이라도 고객 명이 다를수 있기 떄문에 같으면 안된다.

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
