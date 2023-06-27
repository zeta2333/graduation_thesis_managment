package usts.cs2020.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 2:14 PM
 */
public class FileUtil {

    public final static String FILE_PATH_PREFIX = "src/main/resources/static/uploadFile/";

    /**
     * @param names 文件下文件名的集合
     * @param name  存入的文件名
     * @param index 索引的开始位置
     * @return 符合要求的文件名
     */
    private static String checkFileName(ArrayList<String> names, String name, int index) {
        String indexName;
        if (index == 0) {
            indexName = name;
        } else {
            indexName = name.substring(0, name.indexOf(".")) + "(" + index + ")" + name.substring(name.indexOf("."));
        }
        if (names.contains(indexName)) {
            index += 1;
            name = checkFileName(names, name, index);
        } else {
            return indexName;
        }
        return name;
    }

    /**
     * @param path 需要遍历的路径
     * @return 路径下文件的名称集合
     */
    private static ArrayList<String> getFile(String path) {
        // 获得指定文件对象
        File file = new File(path);
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();
        ArrayList<String> list = new ArrayList<>();
        if (array != null) {
            for (File value : array) {
                list.add(value.getName());
            }
        }
        return list;
    }

    public static String upload(MultipartFile file) throws IOException {
        // 上传路径
        String uploadPath = FILE_PATH_PREFIX;
        ArrayList<String> list = getFile(uploadPath);
        /*获取文件名*/
        String getFileName = file.getOriginalFilename();
        String fileName;
        // 查询是否重名，重名角标加一
        fileName = checkFileName(list, getFileName, 0);
        String filePath = uploadPath + fileName;
        BufferedOutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(filePath)));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();
        // 返回保存到服务器的文件名
        return fileName;
    }
}
