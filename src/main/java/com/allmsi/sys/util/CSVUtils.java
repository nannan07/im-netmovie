package com.allmsi.sys.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

public class CSVUtils {
	
	public static File createCSV(List<Object> headList, List<List<Object>> dataList, String fileName, String filePath) {
		File csvFile = null;
		BufferedWriter csvWtriter = null;
		try {
			csvFile = new File(filePath + fileName);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();

			// GB2312使正确读取分隔符","
			csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "gb2312"), 1024);

			int num = dataList.size() / 2;
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < num; i++) {
				buffer.append(" ,");
			}
		
			// 写入文件头部
			writeRow(headList, csvWtriter);

			// 写入文件内容
			for (List<Object> row : dataList) {
				writeRow(row, csvWtriter);
			}
			csvWtriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvWtriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return csvFile;
	}

	private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
		for (Object data : row) {
			StringBuffer sb = new StringBuffer();
			String rowStr = sb.append("\"").append(data).append("\",").toString();
			csvWriter.write(rowStr);
		}
		csvWriter.newLine();
	}
	
	public static void exportFile(HttpServletResponse response, String csvFilePath, String fileName)
			throws IOException {
		File file = new File(csvFilePath);
		PrintWriter out = null;
		InputStream fis = null;
		OutputStream toClient = null;
		try {
			if (file.exists()) {
				fis = new BufferedInputStream(new FileInputStream(file));
				response.reset();
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition",
						"attachment;filename=" + new String(fileName.getBytes("gb2312"), "iso-8859-1"));
				response.addHeader("Content-Length", "" + file.length());
				toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				byte[] buffer = new byte[1024 * 1024 * 4];
				int i = -1;
				while ((i = fis.read(buffer)) != -1) {
					toClient.write(buffer, 0, i);
				}
			} else {
				response.setHeader("Content-type", "text/html;charset=UTF-8");  
		        String data = "没有可下载文件！";  
		        OutputStream ps = response.getOutputStream();  
		        //这句话的意思，使得放入流的数据是utf8格式  
		        ps.write(data.getBytes("UTF-8"));
			}
		} catch (IOException ex) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");  
	        String data = "没有可下载文件！";  
	        OutputStream ps = response.getOutputStream();  
	        ps.write(data.getBytes("UTF-8"));
			/*response.setCharacterEncoding("UTF-8"); 
			out = response.getWriter();
			out.print("<script>");
			out.print("alert(\"没有可下载文件！\")");
			out.print("</script>");*/
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (toClient != null) {
				toClient.flush();
				toClient.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
}
