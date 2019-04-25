/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.entity.DataScope;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.base.collect.dao.ProductinfoDao;
import com.jeesite.modules.base.collect.dao.ProjectinfoDao;
import com.jeesite.modules.base.collect.entity.Productinfo;
import com.jeesite.modules.base.collect.entity.Projectinfo;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.productinfo.dao.XrProductinfoDao;
import com.jeesite.modules.base.project.dao.XrProjectinfoDao;
import com.jeesite.modules.base.xr.entity.XrStore;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.jsoup.helper.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.base.collect.entity.CollectMoney;
import com.jeesite.modules.base.collect.dao.CollectMoneyDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * collectMoneyService
 * @author Crysta-hu
 * @version 2019-04-16
 */
@Service
@Transactional(readOnly=true)
@SuppressWarnings("all")
public class CollectMoneyService extends CrudService<CollectMoneyDao, CollectMoney> {

	@Autowired
	private ProjectinfoDao projectInfoDao;

	@Autowired
	private ProductinfoDao productinfoDao;

	@Autowired
	private MemberInfoService memberInfoService;

	@Autowired
	private CollectMoneyDao collectMoneyDao;

	/**
	 * 获取单条数据
	 * @param collectMoney
	 * @return
	 */
	@Override
	public CollectMoney get(CollectMoney collectMoney) {
		CollectMoney entity = super.get(collectMoney);
		if(entity !=null){
			Projectinfo projectInfo = new Projectinfo();
			projectInfo.setStatus("0");
			entity.setXrProjectinfoList(projectInfoDao.findList(projectInfo));

		}
		return entity;
	}

	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param collectMoney
	 * @return
	 */
	@Override
	public Page<CollectMoney> findPage(Page<CollectMoney> page, CollectMoney collectMoney) {
		// 生成数据权限过滤条件
		QueryDataScope sss = collectMoney.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, collectMoney);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CollectMoney collectMoney) {
		if(collectMoney.getIsNewRecord()){
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMdd");
			String nowDate = dateFormat.format(new Date());
			String s = StringUtils.getRandomNum(3);
			collectMoney.setCmCode(nowDate+s);

		}

		//会员消费之后更新会员档案中的数据

		MemberInfo memberData = memberInfoService.getByForm("mi_card_number", collectMoney.getCmMemberCard());
		Long miBalance = memberData.getMiBalance();
		Long cmPaymentMoney = collectMoney.getCmPaymentMoney();
		if(miBalance>=cmPaymentMoney){
			miBalance = miBalance-cmPaymentMoney;
			memberData.setMiBalance(miBalance);
			memberData.setStatus("2");
			memberInfoService.save(memberData);
		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		collectMoney.setUserCode(user);
		collectMoney.setOfficeCode(office);
		super.save(collectMoney);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_file");

		//保存collectMoney子表
		for(Projectinfo projectinfo : collectMoney.getXrProjectinfoList()){
			if (Projectinfo.STATUS_DELETE.equals(projectinfo.getStatus())){
				projectinfo.setCollectMoney(collectMoney);
				if(projectinfo.getIsNewRecord()){
					projectinfo.preInsert();
					projectInfoDao.insert(projectinfo);
				}else{
					projectinfo.preUpdate();
					projectInfoDao.update(projectinfo);
				}
			}else{
				projectInfoDao.delete(projectinfo);
			}

		}
	}

	/**
	 * 更新状态
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CollectMoney collectMoney) {
		super.updateStatus(collectMoney);
	}

	/**
	 * 删除数据
	 * @param collectMoney
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CollectMoney collectMoney) {
		super.delete(collectMoney);
		Projectinfo projectInfo = new Projectinfo();
		projectInfo.setCollectMoney(collectMoney);
		projectInfoDao.delete(projectInfo);

	}
}