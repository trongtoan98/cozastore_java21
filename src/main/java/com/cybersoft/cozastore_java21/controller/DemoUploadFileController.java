package com.cybersoft.cozastore_java21.controller;

import com.cybersoft.cozastore_java21.exception.CustomFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/demo")
public class DemoUploadFileController {
//    Path chứa toàn bộ hàm hỗ trợ sẵn liên quan đến đuòng dẫn
    @Value("${path.root}")
    private String spath;
    @GetMapping("/{filename}")
    public ResponseEntity<?> loadFile(@PathVariable String filename){
//        đường dẫn folder root lưu hình

        try{
            Path rootPath = Paths.get(spath);
            Resource resource = new UrlResource(rootPath.resolve(filename).toUri());
            if(resource.exists()){
//                nếu tồn tại thì mới cho phép download
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

            }else {
//              khi ném exception thì code sẽ dừng và văng ra lỗi

                throw new CustomFileNotFoundException(200,"File not found");
            }

        }catch (Exception e){
            throw new CustomFileNotFoundException(200,"File not found");
        }

    }
    @PostMapping("/uploadfile")
    public ResponseEntity<?> uploadFile( @RequestParam MultipartFile file){
//        định nghĩa đường dẫn
        Path rootPath = Paths.get(spath);
        try{
            if(!Files.exists(rootPath)){
//            tạo folder ứng với đường dẫn nếu không tồn tại folder
                Files.createDirectories(rootPath);
            }
//C:\Users\USER\Desktop\image21\
//            resolve tương đương với dấu \
//            file.getOriginalFilename() lấy tên file và định dạng
            String fileName = file.getOriginalFilename();
            Files.copy(file.getInputStream(),
                    rootPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            throw new CustomFileNotFoundException(500,"khong tim thay file");

        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
