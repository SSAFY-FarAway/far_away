package com.ssafy.faraway.domain.hotplace.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class FileInfoListResponseDto {
    private long id;
    private String saveFolder;
    private String originalFile;
    private String saveFile;

    @Builder
    public FileInfoListResponseDto(long id, String saveFolder, String originalFile, String saveFile) {
        this.id = id;
        this.saveFolder = saveFolder;
        this.originalFile = originalFile;
        this.saveFile = saveFile;
    }
}
