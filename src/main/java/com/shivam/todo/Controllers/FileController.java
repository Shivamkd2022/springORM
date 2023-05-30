package com.shivam.todo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/file")
public class FileController
{
    Logger logger= LoggerFactory.getLogger(FileController.class);

    @PostMapping("/singlefile")
   public String uploadSingleFile(@RequestParam("image") MultipartFile file) throws IOException {

       logger.info("file content type is: {}",file.getContentType());
        logger.info("file name is: {}", file.getName());
        logger.info("file size is: {}", file.getSize());
        logger.info("file original name is: {}", file.getOriginalFilename());;
        logger.info("is file empty? {}", file.isEmpty());

//      for getting the data of the file .......  file.getInputStream()
//       InputStream inputStream = file.getInputStream();
//       FileOutputStream fos= new FileOutputStream("abc.pdf");
//       byte data[]= new byte[inputStream.available()];
//       fos.write(data);
       return "file is uploaded";
   }

   @PostMapping("/multiplefiles")
        public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] f)
        {
            for (MultipartFile f1:f)
            {
                logger.info("file original name is: {}", f1.getOriginalFilename());
                logger.info("file type is: {}", f1.getContentType());
                logger.info("is file empty? :{}", f1.isEmpty());
                System.out.println("************************************");
                
            }
            return "Multiple files have been uploaded.";
        }

        @GetMapping("/viewimage")
        public void imageResponse(HttpServletResponse response) throws IOException {

        FileInputStream fis1= new FileInputStream("Images/unnamed.png");
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
            StreamUtils.copy(fis1,response.getOutputStream());

        }
}
