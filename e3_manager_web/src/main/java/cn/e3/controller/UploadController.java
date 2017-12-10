package cn.e3.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;
import cn.e3.utils.KindEditorModel;

@Controller
public class UploadController {

	@Value("${IMAGE_URL}")
	private String IMAGE_URL;
	
	/**
	 * 图片上传
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile) {
		try {
			//获取文件扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			//工具类上传，加载配置文件
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			url = IMAGE_URL + url;
			KindEditorModel kindEditorModel = new KindEditorModel();
			kindEditorModel.setUrl(url);
			kindEditorModel.setError(0);
			String picJson = JsonUtils.objectToJson(kindEditorModel);
			return picJson;
		} catch (Exception e) {
			e.printStackTrace();
			KindEditorModel kindEditorModel = new KindEditorModel();
			kindEditorModel.setMesssage("失败");
			kindEditorModel.setError(1);
			String picJson = JsonUtils.objectToJson(kindEditorModel);
			return picJson;
		}
	}
}
