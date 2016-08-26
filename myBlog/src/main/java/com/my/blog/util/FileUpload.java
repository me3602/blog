package com.my.blog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

@Component("FileUpload")
public class FileUpload {

	public boolean registerFileLocal(String path, String fileType, String filename, byte[] byteFile, long fileSize) {
		
		boolean result = false;
		File file = new File(path+filename);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte[] buf = byteFile;			
			os.write(buf);
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		return result;

	}

}
