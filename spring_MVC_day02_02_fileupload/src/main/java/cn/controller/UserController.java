package cn.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {



    /**
     * 传统文件上传
     */
    @RequestMapping(path = "/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        
        //解析request对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
          //进行判断,当前item对象是否是上传文件项
          if (item.isFormField()){
              //说明是普通表单项
          }else {
              //说明上传文件项
              //获取上传文件的名称
              String fileName = item.getName();
              //完成文件上传
              item.write(new File(path,fileName));
              //删除临时文件
              item.delete();
          }
        }
        return "success";
    }

    /**
     * Spring方式文件上传
     * @return
     */
    @RequestMapping(path = "/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传...");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
         //说明上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //将上传的文件名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid+"_"+fileName;
        //完成文件上传
       upload.transferTo(new File(path,fileName));

        return "success";
    }

    /**
     *跨服务器方式文件上传
     * @return
     */
    @RequestMapping(path = "/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器方式文件上传...");
        //定义上传服务器地址
        String path = "http://localhost:9090/fileupload_war_exploded/uploads";

        //说明上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //将上传的文件名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid+"_"+fileName;

        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        //完成文件上传,跨服务器上传
        webResource.put(upload.getBytes());
        //创建客户端的对象
        return "success";
    }

}
