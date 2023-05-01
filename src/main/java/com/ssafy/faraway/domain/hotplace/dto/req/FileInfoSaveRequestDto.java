package com.ssafy.faraway.domain.hotplace.dto.req;

import com.ssafy.faraway.domain.hotplace.entity.FileInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@ToString
public class FileInfoSaveRequestDto {
    @NotNull(message = "게시글 정보가 없습니다.")
    private long hotPlaceId;
    @NotBlank(message = "저장될 폴더 이름을 입력해주세요.")
    @Size(max = 45, message = "폴더 이름은 45자 이하입니다.")
    private String saveFolder;
    @NotBlank(message = "저장할 파일 이름을 입력해주세요.")
    @Size(max = 50, message = "파일 이름은 50자 이하입니다.")
    private String originalFile;
    @NotBlank(message = "저장될 파일 이름을 입력해주세요.")
    @Size(max = 50, message = "파일 이름은 50자 이하입니다.")
    private String saveFile;

    @Builder
    public FileInfoSaveRequestDto(long hotPlaceId, String saveFolder, String originalFile, String saveFile) {
        this.hotPlaceId = hotPlaceId;
        this.saveFolder = saveFolder;
        this.originalFile = originalFile;
        this.saveFile = saveFile;
    }

    public FileInfo toEntity() {
        return FileInfo.builder()
                .hotPlaceId(hotPlaceId)
                .saveFolder(saveFolder)
                .originalFile(originalFile)
                .saveFile(saveFile)
                .build();
    }
}
