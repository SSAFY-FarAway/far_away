package com.ssafy.faraway.domain.hotplace.controller;

import com.ssafy.faraway.common.PagingResponse;
import com.ssafy.faraway.common.SearchCondition;
import com.ssafy.faraway.domain.hotplace.dto.req.*;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceCommentListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceListResponseDto;
import com.ssafy.faraway.domain.hotplace.dto.res.HotPlaceResponseDto;
import com.ssafy.faraway.domain.hotplace.service.FileInfoService;
import com.ssafy.faraway.domain.hotplace.service.HotPlaceCommentService;
import com.ssafy.faraway.domain.hotplace.service.HotPlaceService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotplace")
@Api(tags = "hotplace")
public class HotPlaceController {
    private final HotPlaceService hotPlaceService;
    private final FileInfoService fileService;
    private final HotPlaceCommentService hotPlaceCommentService;

    @Value("${file.path}")
    private String uploadPath;


    @PostMapping()
    public ResponseEntity saveHotPlace(@RequestBody @Valid final HotPlaceSaveRequestDto hotPlaceSaveRequestDto, @RequestParam(value = "uploadFiles", required = false) MultipartFile[] files) {
        try {
            Long hotPlaceId = hotPlaceService.save(hotPlaceSaveRequestDto);
            if (hotPlaceId == 0) {
                return ResponseEntity.badRequest().build();
            }
            if (files != null && !files[0].isEmpty()) {
                String today = new SimpleDateFormat("yyMMdd").format(new Date());
                String saveFolder = uploadPath + File.separator + today;
                File folder = getFolder(saveFolder);
                List<FileInfoSaveRequestDto> fileInfoSaveRequestDtos = getFileInfoSaveRequestDtos(hotPlaceId, files, today, folder);
                fileService.save(fileInfoSaveRequestDtos);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    private static File getFolder(String saveFolder) {
        File folder = new File(saveFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }

    private static List<FileInfoSaveRequestDto> getFileInfoSaveRequestDtos(Long hotPlaceId, MultipartFile[] files, String today, File folder) throws IOException {
        List<FileInfoSaveRequestDto> fileInfoSaveRequestDtos = new ArrayList<>();
        for (MultipartFile file : files) {
            FileInfoSaveRequestDto fileInfoSaveRequestDto = new FileInfoSaveRequestDto();
            String originalFileName = file.getOriginalFilename();
            if (!originalFileName.isEmpty()) {
                String saveFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf('.'));
                fileInfoSaveRequestDto = FileInfoSaveRequestDto.builder()
                        .hotPlaceId(hotPlaceId)
                        .saveFolder(today)
                        .originalFile(originalFileName)
                        .saveFile(saveFileName)
                        .build();
                file.transferTo(new File(folder, saveFileName));
            }
            fileInfoSaveRequestDtos.add(fileInfoSaveRequestDto);
        }
        return fileInfoSaveRequestDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotPlaceResponseDto> findHotPlaceById(@PathVariable Long id) {
        try {
            HotPlaceResponseDto hotPlaceResponseDto = hotPlaceService.findById(id);
            hotPlaceService.updateHit(id);
            if (hotPlaceResponseDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<HotPlaceResponseDto>(hotPlaceResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity findAllHotPlace(@ModelAttribute SearchCondition searchCondition) {
        PagingResponse<HotPlaceListResponseDto> pagingResponse = null;
        try {
            pagingResponse = hotPlaceService.findAllByCondition(searchCondition);
            if (pagingResponse == null) {
                return ResponseEntity.noContent().build();
            }
            return new ResponseEntity<PagingResponse<HotPlaceListResponseDto>>(pagingResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping()
    public ResponseEntity updateHotPlace(@RequestBody @Valid final HotPlaceUpdateRequestDto hotPlaceUpdateRequestDto) {
        try {
            int result = hotPlaceService.update(hotPlaceUpdateRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHotPlace(@PathVariable Long id) {
        try {
            int result = hotPlaceService.delete(id);
            if (result == 0) {
                return ResponseEntity.badRequest().build()
                        ;
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/comment")
    public ResponseEntity saveHotPlaceComment(@RequestBody @Valid final HotPlaceCommentSaveRequestDto hotPlaceCommentSaveRequestDto) {
        try {
            int result = hotPlaceCommentService.save(hotPlaceCommentSaveRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/comment")
    public ResponseEntity findAllCommentByHotPlaceId(@PathVariable Long id) {
        try {
            List<HotPlaceCommentListResponseDto> list = hotPlaceCommentService.findAllByHotPlaceId(id);
            if (list == null) {
                return ResponseEntity.noContent().build();
            }
            return new ResponseEntity<List<HotPlaceCommentListResponseDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/comment")
    public ResponseEntity updateComment(@RequestBody @Valid final HotPlaceCommentUpdateRequestDto hotPlaceCommentUpdateRequestDto) {
        try {
            int result = hotPlaceCommentService.update(hotPlaceCommentUpdateRequestDto);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        try {
            int result = hotPlaceCommentService.delete(id);
            if (result == 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}