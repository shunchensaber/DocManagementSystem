package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("doc\\a.txt");
		System.out.print(file.getAbsolutePath());
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("创建文件失败");
			}
		InputStream inputStream = null;
		try {
			 inputStream = new FileInputStream(file);
			 } catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] b = new byte[(int)file.length()];
		try {
			inputStream.read(b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(b));
				
		
	
	}

}
