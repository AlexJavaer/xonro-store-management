/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.productinfo.service;

import java.util.HashMap;
import java.util.List;

import com.jeesite.common.entity.DataScope;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.dao.XrProductinfoDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * xr_productinfoService
 * @author Crysta-hu
 * @version 2019-04-04
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class XrProductinfoService extends CrudService<XrProductinfoDao, XrProductinfo> {

	@Autowired
	private XrProductinfoDao xrProductinfoDao;


	/**
	 * 获取单条数据
	 * @param xrProductinfo
	 * @return
	 */
	@Override
	public XrProductinfo get(XrProductinfo xrProductinfo) {
		return super.get(xrProductinfo);
	}

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrProductinfo
	 * @return
	 */
	@Override
	public Page<XrProductinfo> findPage(Page<XrProductinfo> page, XrProductinfo xrProductinfo) {
		// 生成数据权限过滤条件
		QueryDataScope sss = xrProductinfo.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, xrProductinfo);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrProductinfo xrProductinfo) {
		if(xrProductinfo.getIsNewRecord()){
			xrProductinfo.setXpdStockNum(0L);
		}

		if(!xrProductinfo.getIsNewRecord()&& xrProductinfo.getStatus().equals("1")){
			//建档产品入库后，库存数量就是你入库后的数量
			xrProductinfo.setXpdStockNum(xrProductinfo.getXpdStockNum());
		}else if(!xrProductinfo.getIsNewRecord()&& xrProductinfo.getStatus().equals("2")){
			//建档产品入库后，库存数量就是你出库后的数量
			xrProductinfo.setXpdStockNum(xrProductinfo.getXpdStockNum());
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrProductinfo.setUserCode(user);
		xrProductinfo.setOfficeCode(office);
		super.save(xrProductinfo);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xrProductinfo.getId(), "xrProductinfo_image");
		// 保存上传附件
		//FileUploadUtils.saveFileUpload(xrProductinfo.getId(), "xrProductinfo_file");
	}
	
	/**
	 * 更新状态
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrProductinfo xrProductinfo) {
		super.updateStatus(xrProductinfo);
	}
	
	/**
	 * 删除数据
	 * @param xrProductinfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrProductinfo xrProductinfo) {
		super.delete(xrProductinfo);
	}


	public XrProductinfo getByForm(String product_code,String productCode){

		HashMap<String,Object>  hmap= new HashMap<String,Object>();
		hmap.put("product_code",product_code);
		hmap.put("productCode",productCode);

		return xrProductinfoDao.getByForm(hmap);
	}

	
}