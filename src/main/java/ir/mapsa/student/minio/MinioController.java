package ir.mapsa.student.minio;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/minio")
@AllArgsConstructor
public class MinioController {
    private final MinioService service;

    @PostMapping(path= "/upload", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Map<String, String> uploadFile(@RequestPart(value="file",required = false) MultipartFile files) throws Exception{
        String gKey= service.uploadFile(files);
        Map<String, String> result = new HashMap<>();
        result.put("GeneratedKey",gKey);
        return result;
    }

    @GetMapping(path="/download")
    public ResponseEntity<ByteArrayResource> uploadFile(@RequestParam(value="file") String file) throws IOException{
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
