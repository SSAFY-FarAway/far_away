package com.ssafy.faraway.domain.hotplace.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class FileInfo {
    private long id;
    private long hotPlaceId;
    private String saveFolder;
    private String originalFile;
    private String saveFile;
    LocalDateTime createdDate;

    @Builder
    public FileInfo(long hotPlaceId, String saveFolder, String originalFile, String saveFile) {
        this.hotPlaceId = hotPlaceId;
        this.saveFolder = saveFolder;
        this.originalFile = originalFile;
        this.saveFile = saveFile;
    }
}
