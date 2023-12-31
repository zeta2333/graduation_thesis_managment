package usts.cs2020.controller.file;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import usts.cs2020.utils.file.FileUtil;
import usts.cs2020.utils.result.Result;

import java.nio.charset.StandardCharsets;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 2:15 PM
 */
@RestController
@RequestMapping("system/sysFile")
public class FileDealController {

    /**
     * 上传文件的方法，将文件上传到某个存在的位置
     *
     * @param file 文件名
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        // 这里由于逻辑较多所以封装了一个util
        String fileName = FileUtil.upload(file);
        return Result.ok(fileName);
    }

    /**
     * 下载文件的方法，将文件从某个存在的位置上下载下来
     *
     * @param filename 文件名
     */
    @GetMapping("/download")
    public ResponseEntity download(@RequestParam("filename") String filename) throws Exception {
        // 指定预下载文件的位置
        FileSystemResource file = new FileSystemResource(FileUtil.FILE_PATH_PREFIX + filename);
        HttpHeaders httpHeaders = new HttpHeaders();
        // 指定下载后的文件名等，new String(filename.getBytes("UTF-8"),"ISO8859-1")很重要，不然会下载中文名的时候名字为空
        httpHeaders.add("Content-Disposition", "attachment; filename=" + new String(filename.getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }


}

