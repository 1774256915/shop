package com.javabishe1234.util;

import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

public class FastDFSUtils {

	/**
	    * 上传文件到fastdfs系统
	 * @param pic
	 * @param name
	 * @param size
	 * @return
	 */
	public static String uploadPic(byte[] pic ,String name,long size){
		String path = null;
		//ClientGloble 读配置文件
		ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
		try {
			ClientGlobal.init(resource.getClassLoader().getResource("config/fdfs_client.conf").getPath());
			//老大客户端
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer  = null;
			StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
			String ext = FilenameUtils.getExtension(name);
			
			NameValuePair[] meta_list = new NameValuePair[3];
			meta_list[0] = new NameValuePair("fileName",name);
			meta_list[1] = new NameValuePair("fileExt",ext);
			meta_list[2] = new NameValuePair("fileSize",String.valueOf(size));
			
			
			//  group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
			path = storageClient1.upload_file1(pic, ext, meta_list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 下载文件到本地
	 */
	public static void testDownload(String url) {
		try {
			ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
		ClientGlobal.init(resource.getClassLoader().getResource("config/fdfs_client.conf").getPath());
			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer, storageServer);
			byte[] b = storageClient.download_file("group1", url);
			IOUtils.write(b, new FileOutputStream("D:/" + UUID.randomUUID().toString() + ".conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
