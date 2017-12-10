package cn.e3.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3.utils.FastDFSClient;

public class FastdfsTest {

	@Test
	public void uploadTest1() throws Exception {
		//指定上传文件路径
		String pic = "/Volumes/H/1.jpg";
		//配置文件路径
		String client = "/Users/huanggeng/Documents/e3mall/e3/e3_manager_web/src/main/resources/conf/client.conf";
		//加载配置文件
		ClientGlobal.init(client);
		//创建tracker客户端，从客户端获取对象
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建storage客户端
		StorageClient storageClient = new StorageClient(trackerServer, null);
		//图片上传
		String[] file = storageClient.upload_appender_file(pic, "jpg", null);
		//输出文件信息
		for (String string : file) {
			System.out.println(string);
		}
	}
	/**
	 * 工具类上传
	 * @throws Exception
	 */
	@Test
	public void uploadTest2() throws Exception {
		//指定上传文件路径
		String pic = "/Volumes/H/1.jpg";
		//配置文件路径
		String client = "/Users/huanggeng/Documents/e3mall/e3/e3_manager_web/src/main/resources/conf/client.conf";
		FastDFSClient fastDFSClient = new FastDFSClient(client);
		String string = fastDFSClient.uploadFile(pic);
		System.out.println(string);
	}
}
