/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.collect.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.entity.DataScope;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.base.collect.dao.XrCollectProductinfoDao;
import com.jeesite.modules.base.collect.dao.XrCollectProjectinfoDao;
import com.jeesite.modules.base.collect.entity.XrCollectProductinfo;
import com.jeesite.modules.base.collect.entity.XrCollectProjectinfo;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.productinfo.entity.XrProductinfo;
import com.jeesite.modules.base.productinfo.service.XrProductinfoService;
import com.jeesite.modules.base.project.dao.XrProjectinfoDao;
import com.jeesite.modules.base.project.entity.XrProjectinfo;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	XrCollectProjectinfoDao xrCollectProjectinfoDao;

	@Autowired
	XrCollectProductinfoDao xrCollectProductinfoDao;

	@Autowired
	private MemberInfoService memberInfoService;

	@Autowired
	private CollectMoneyDao collectMoneyDao;

	@Autowired
	private XrProductinfoService xrProductinfoService;

	/**
	 * 获取单条数据
	 * @param collectMoney
	 * @return
	 */
	@Override
	public CollectMoney get(CollectMoney collectMoney) {
		CollectMoney entity = super.get(collectMoney);
		if(entity !=null){
			//项目子表
			XrCollectProjectinfo xrCollectProjectinfoList = new XrCollectProjectinfo(entity);
			xrCollectProjectinfoList.setStatus(XrCollectProjectinfo.STATUS_NORMAL);
			entity.setXrCollectProjectinfoList(xrCollectProjectinfoDao.findList(xrCollectProjectinfoList));

			//产品子表
			XrCollectProductinfo xrCollectProductinfoList = new XrCollectProductinfo(entity);
			xrCollectProductinfoList.setStatus(XrCollectProductinfo.STATUS_NORMAL);
			entity.setXrCollectProductinfoList(xrCollectProductinfoDao.findList(xrCollectProductinfoList));

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

			/*collectMoney.setCmDate(new Date());*/

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

		collectMoney.setCmAccountBalance(memberData.getMiBalance());
		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		collectMoney.setUserCode(user);
		collectMoney.setOfficeCode(office);


		//会员购买产品后，产品库存减少
		

		super.save(collectMoney);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(collectMoney.getId(), "collectMoney_file");

		//保存项目子表
		for(XrCollectProjectinfo xrCollectProjectinfo : collectMoney.getXrCollectProjectinfoList()){
			if(!xrCollectProjectinfo.STATUS_DELETE.equals(xrCollectProjectinfo.getStatus())){

			    xrCollectProjectinfo.setCollectMoney(collectMoney);

			    if(xrCollectProjectinfo.getIsNewRecord()){
			        xrCollectProjectinfo.preInsert();
			        xrCollectProjectinfoDao.insert(xrCollectProjectinfo);
                }else{
                    xrCollectProjectinfo.preUpdate();
                    xrCollectProjectinfoDao.update(xrCollectProjectinfo);
                }

			}else{
			    xrCollectProjectinfoDao.delete(xrCollectProjectinfo);
            }

		}

		//保存产品子表
		for(XrCollectProductinfo xrCollectProductinfo : collectMoney.getXrCollectProductinfoList()){
			if(!xrCollectProductinfo.STATUS_DELETE.equals(xrCollectProductinfo.getStatus())){
				xrCollectProductinfo.setCollectMoney(collectMoney);

				if(xrCollectProductinfo.getIsNewRecord()){
					xrCollectProductinfo.preInsert();
					xrCollectProductinfoDao.insert(xrCollectProductinfo);
				}else{
					xrCollectProductinfo.preUpdate();
					xrCollectProductinfoDao.update(xrCollectProductinfo);

				}

				XrProductinfo productinfoData = xrProductinfoService.getByForm("product_code", xrCollectProductinfo.getProductCode());

				//产品库存数量
				Long xpdStockNum = productinfoData.getXpdStockNum();
				System.out.println(xpdStockNum);
				if(xpdStockNum>0&& productinfoData.getProductCode().equals(xrCollectProductinfo.getProductCode())){
                  List lists = new ArrayList();
                  lists.add(xrCollectProductinfo.getProductCode());
                    int productNum = lists.size();
                    xpdStockNum = xpdStockNum-productNum;
                    productinfoData.setXpdStockNum(xpdStockNum);
                    productinfoData.setStatus("3");
                    xrProductinfoService.save(productinfoData);
                }


			}else{
				xrCollectProductinfoDao.delete(xrCollectProductinfo);
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
		//删除项目子表
		XrCollectProjectinfo xrCollectProjectinfo = new XrCollectProjectinfo();
		xrCollectProjectinfo.setCollectMoney(collectMoney);
		xrCollectProjectinfoDao.delete(xrCollectProjectinfo);

		//删除产品子表

		XrCollectProductinfo xrCollectProductinfo = new XrCollectProductinfo();
		xrCollectProductinfo.setCollectMoney(collectMoney);
		xrCollectProductinfoDao.delete(xrCollectProductinfo);

	}
}