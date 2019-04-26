package com.skn.Learning.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

/**
 * GBK转TF-8
 * @author skn
 *
 */
public class EncodeExchangeUtil {
    public static void main(String args[]) throws IOException{

        String srcDirPath = "E:\\eclipseworkspace\\Learning\\src"; 

        String utf8DirPath = "E:\\eclipseworkspace\\Learning1\\src"; 
                
        //读取所有java文件
        Collection<File> javaGbkFileCol =  FileUtils.listFiles(
                new File(srcDirPath), new String[]{"java"}, true); 
                
        for (File javaGbkFile : javaGbkFileCol) { 
            
        	  //UTF8格式文件路径 
              String utf8FilePath = utf8DirPath+javaGbkFile.getAbsolutePath().substring(srcDirPath.length()); 
              //使用GBK读取数据，然后用UTF-8写入数据 
              FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));        
              System.out.println(utf8FilePath);
        }
    }
}
