package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import Bean.Db;

/**
 * Servlet implementation class receiveFile
 */
@WebServlet("/ReceiveFile")
public class ReceiveFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveFile() {
        super();
        // TODO Auto-generated constructor stub
       

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String pathString=null;
			String userString =(String)request.getSession().getAttribute("id");
			String father = "D:/jsp/DocManagementSystem/";
			DiskFileItemFactory factory = new DiskFileItemFactory();//�����ļ�����
	        ServletFileUpload sfuFileUpload = new ServletFileUpload(factory);//�ļ��ϴ�����
	        // ���ý����ļ��ϴ��е��ļ����ı����ʽ
	        sfuFileUpload.setHeaderEncoding("utf-8");

	        // ���� list������������ ���е�����������Ϣ
	        List<FileItem> items = new ArrayList<FileItem>();

	        // �����е�����������Ϣ���� list������
	        try {
	            items = sfuFileUpload.parseRequest(request);
	        } catch (FileUploadException e) {
	            e.printStackTrace();
	        }
	        HashMap<String, String> hm = new HashMap<String, String>();
	        // ���� list���������� ÿ�������� �е���Ϣ
	        for (FileItem item : items) {
	            // �ж��Ƿ�����ͨ��
	            if (item.isFormField()) {
	                // ���� ��ͨ������ ��Ϣ
	                String filednameString  = item.getFieldName();
	                System.out.println(filednameString);
	                String valueString="";
	                valueString = item.getString("utf-8");
	               hm.put(filednameString, valueString);
	                //System.out.println("filename = "+filednameString+";"+"valueString="+valueString);
	            } else {
	                // ���� �ļ������� ��Ϣ
	            	String filednameString = item.getName();
	            	//System.out.println(filednameString);
	            	if(filednameString==null||filednameString.equals(""))
	            		return;
	    			
	            	pathString  = father+"doc/"+userString+UUID.randomUUID()+".txt";
	            	
	    			System.out.println(pathString);
	            
	            	File file = new File(pathString);
	            	try {
	            		
						item.write(file);
						//pathString = file.getAbsolutePath();
						System.out.println("pathstring="+pathString);
						
						
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	           
            	
	        }
	        hm.put("path",pathString);
			hm.put("userid",userString);
            Db db = new Db();
        	db.Insertdocinf(hm.get("userid"), hm.get("title"), hm.get("main"),hm.get("path"));
        	response.sendRedirect("Upload/upLoad.jsp");
	}

	/**S
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
