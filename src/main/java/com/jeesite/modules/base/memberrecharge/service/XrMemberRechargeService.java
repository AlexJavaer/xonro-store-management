/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.memberrecharge.service;

import java.util.List;

import com.jeesite.common.lang.StringUtils;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.memberrecharge.entity.XrMemberRecharge;
import com.jeesite.modules.base.memberrecharge.dao.XrMemberRechargeDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * memberRechargeService
 * @author Crysta-hu
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class XrMemberRechargeService extends CrudService<XrMemberRechargeDao, XrMemberRecharge> {
	
	/**
	 * 获取单条数据
	 * @param xrMemberRecharge
	 * @return
	 */
	@Override
	public XrMemberRecharge get(XrMemberRecharge xrMemberRecharge) {
		return super.get(xrMemberRecharge);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param xrMemberRecharge
	 * @return
	 */
	@Override
	public Page<XrMemberRecharge> findPage(Page<XrMemberRecharge> page, XrMemberRecharge xrMemberRecharge) {
		return super.findPage(page, xrMemberRecharge);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param xrMemberRecharge
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrMemberRecharge xrMemberRecharge) {
		if(xrMemberRecharge.getIsNewRecord()){
			String officeCode = EmpUtils.getOffice().getOfficeCode();
			String s = StringUtils.getRandomNum(3);
			xrMemberRecharge.setXmrCode(officeCode+s);
			//最新余额变动
		/*Long newBalance;
		if(xrMemberRecharge.getXmrGiftAccount()!= null && "".equals(xrMemberRecharge.getXmrGiftAccount())){
			newBalance = xrMemberRecharge.getXmrCurrentBalance()-xrMemberRecharge.getXmrProduceProjectAmount()-xrMemberRecharge.getXmrPackageAmount()+xrMemberRecharge.getXmrSaveMoney()+xrMemberRecharge.getXmrGiftAccount();
			xrMemberRecharge.setXmrLatestBalance(newBalance);
		}*/
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrMemberRecharge.setUserCode(user);
		xrMemberRecharge.setOfficeCode(office);
		super.save(xrMemberRecharge);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(xrMemberRecharge.getId(), "xrMemberRecharge_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(xrMemberRecharge.getId(), "xrMemberRecharge_file");
	}
	
	/**
	 * 更新状态
	 * @param xrMemberRecharge
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(XrMemberRecharge xrMemberRecharge) {
		super.updateStatus(xrMemberRecharge);
	}
	
	/**
	 * 删除数据
	 * @param xrMemberRecharge
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(XrMemberRecharge xrMemberRecharge) {
		super.delete(xrMemberRecharge);
	}
	
}