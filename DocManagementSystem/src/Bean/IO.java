package Bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public class IO {

	private File file;
	private InputStream inputStream;
	private String filename;
	public String getfilenameString()
	{
		return filename;
	}
	
	public IO(String filename)
	{
		
		file = new File(filename);
		this.filename = file.getAbsoluteFile().toString();
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
	public String read()
	{
		StringBuilder sBuilder = new StringBuilder();

		try {
		Reader reader=null;
		
			reader = new FileReader(this.filename);
	
		BufferedReader bufferedReader = new BufferedReader(reader);
		String string = null;
		while((string=bufferedReader.readLine())!=null)
		{
			sBuilder.append(string+"\n");
			//System.out.print(string);
		
		}
		bufferedReader.close();
		reader.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return sBuilder.toString();
		
		
		
		
	}
	public void write(String re)
	{
		try {
			Writer writer = new FileWriter(file);
			writer.write(re);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void delfile()
	{
		if(file.exists()&&file.isFile())
		{
			file.delete();
		}
	}
	public static void main(String[] args) {
		
		IO io = new IO("D:\\jsp\\DocManagementSystem\\doc/c.txt");
		System.out.println(io.filename);
		
		io.write("±ðÊÇ¹þÆ¤");
		System.out.print(io.read());
		io.delfile();
		
		
	}
}
