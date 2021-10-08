package com.qian.kaobar.web;

import com.qian.kaobar.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-18 20:16
 */
public class UploadImg extends HttpServlet {
    /**
     * 上传图片到basePath路径下，并返回对应界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();

        // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 开始解析请求信息
        List items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // 对所有请求信息进行判断
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 信息为普通的格式
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String value = item.getString();
                req.setAttribute(fieldName, value);
            }
            // 信息为文件格式
            else {
                String fileName = item.getName();
                System.out.println(fileName);
                int index = fileName.lastIndexOf("\\");
                fileName = fileName.substring(index + 1);
                req.setAttribute("realFileName", fileName);

                String basePath ="D:/IDEA/LambQian/KaoBar/web/static/img/";
                File file = new File(basePath, fileName);
                String myFileName = file.getName();
                req.setAttribute("filename",myFileName);
                try {
                    item.write(file);
                    req.setAttribute("msg", "文件上传成功!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int id= WebUtils.parseInt(req.getParameter("id"),0);
            if(id==0){
                req.getRequestDispatcher("barbecueServlet?action=getBar&method=add").forward(req, resp);
            }else {
                req.getRequestDispatcher("barbecueServlet?action=getBar&id="+id+"&method=update").forward(req, resp);
            }

        }
    }
}
