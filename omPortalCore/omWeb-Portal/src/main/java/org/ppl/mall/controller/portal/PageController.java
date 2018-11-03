package org.ppl.mall.controller.portal;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import org.ppl.mall.pojo.TbContent;
import org.ppl.mall.pojo.TbItemCat;
import org.ppl.mall.service.ContentService;
import org.ppl.mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author PPL
 *
 */
@Controller
public class PageController {
	
	@Reference
	private ContentService contentService;
	@Reference
    private ItemCatService itemCatService;
	
	@Value("${CONTENT_SHOW_NOW}")
	private Long CONTENT_SHOW_NOW;
	
	//主页 
	@RequestMapping("/index")
	public String index(Model model) {
	    //直接跳转到静态页面服务器
		return "redirect:http://localhost:8703/";
	}


	@RequestMapping("/blank")
	public String blank() {
		return "blank";
	}
}
