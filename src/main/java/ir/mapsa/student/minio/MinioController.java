package ir.mapsa.student.minio;

import ir.mapsa.student.student.IStudentService;
import ir.mapsa.student.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/minio")
@AllArgsConstructor
public class MinioController {
    private final MinioService service;
    private final IStudentService stService;

    @PostMapping(path= "/upload/{id}", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String, String> uploadFile(@RequestPart(value="file",required = false) MultipartFile files,@PathVariable long id) throws Exception{
        String gKey= service.uploadFile(files);
        Map<String, String> result = new HashMap<>();
        result.put("GeneratedKey",gKey);
        Student student = stService.getByID(id);
        student.setPicture(gKey);
        stService.update(student);
        return result;
    }

    @GetMapping(path="/download/{id}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value="file") String file) throws IOException{IOException
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable long id) throws IOException{
        String file = stService.getByID(id).getPicture();
        byte[] data= service.getFile(file);
        ByteArrayResource resource= new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("content-type","application/octet-stream")
                .header("content-disposition","attachment; filename=\""+file+"\"")
                .body(resource);
    }
}
