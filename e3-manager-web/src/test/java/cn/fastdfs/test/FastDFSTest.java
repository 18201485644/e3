package cn.fastdfs.test;

import static org.junit.Assert.*;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSTest {
	@Test
	public void testFileUpload() throws Exception {
		//1、加载配置文件,配置文件中的内容就是tracker服务的地址
		ClientGlobal.init("I:/project/project2_git/e3-manager-web/src/main/resources/conf/client.conf");
		//2、创建一个trackerclient对象.直接new 一个
		TrackerClient tracherClient = new TrackerClient();
		//3、使用tracherClient对象创建链接,获得一个trackerserver对象
		TrackerServer trackerServer = tracherClient.getConnection();
		//4、创建一个storageServer对象引用值为空.
		StorageServer storageServer=null;
		//5、创建一个storageClient对象,需要两个参数对象的引用 参数1 trackerServer对象,storageServer对象
		StorageClient storageClient =new StorageClient(trackerServer, storageServer);
		//6、使用storageClient上传图片
		//参数1 文件绝对地址(上传路径:文件在客户端的路径)
		//参数2 文件后缀名不带.
		//参数3文件元信息(可以不设置,直接赋值为null)
		String[] str = storageClient.upload_file("C:/Users/Public/Pictures/Sample Pictures/p.jpg", "jpg",null);
		for (String string : str) {
			System.out.println(string);
		}
	};
}
