/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.base.memberrecharge.service;

import java.util.HashMap;
import java.util.List;
import com.jeesite.common.entity.DataScope;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mybatis.mapper.query.QueryDataScope;
import com.jeesite.modules.base.member.dao.MemberInfoDao;
import com.jeesite.modules.base.member.entity.MemberInfo;
import com.jeesite.modules.base.member.service.MemberInfoService;
import com.jeesite.modules.base.xr.dao.XrStoreDao;
import com.jeesite.modules.sys.utils.EmpUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private XrMemberRechargeDao xrMemberRechargeDao;
	@Autowired
	private MemberInfoService memberInfoService;
	@Autowired
	private MemberInfoDao memberInfoDao;
	@Autowired
	private XrStoreDao xrStoreDao;

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
		QueryDataScope sss = xrMemberRecharge.getSqlMap().getDataScope().addFilter("dsf", "Office",
				"a.office_code", "a.user_code", DataScope.CTRL_PERMI_MANAGE);
		return super.findPage(page, xrMemberRecharge);
	}

	/*public Page findPageByParam(Map map) {
		//获取page对象
		Page page = (Page)map.get("xrMemberRecharge");
		//查询关联后的会员充值数据表
		List list= xrMemberRechargeDao.findPageBYParam(map);
		page.setList(list);
		//查询统计总条数
		page.setCount(xrMemberRechargeDao.byParamCount(map));
		//返回page
		return page;
	}*/

	/**
	 * 保存数据（插入或更新）
	 * @param xrMemberRecharge
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(XrMemberRecharge xrMemberRecharge) {
		if(xrMemberRecharge.getIsNewRecord()){

			/*String s = StringUtils.getRandomNum(3);*/
			xrMemberRecharge.setId(IdGen.nextId());
			//会员充值之后更新会员档案中的数据
			MemberInfo memberData = memberInfoService.getByForm("mi_code",xrMemberRecharge.getMiCode());
			Long miBalance = memberData.getMiBalance();
			miBalance += xrMemberRecharge.getXmrSaveMoney();
			memberData.setMiBalance(miBalance);
			memberData.setStatus("1");
			memberInfoService.save(memberData);


		}

		String user = UserUtils.getUser().getCurrentUser().getUserCode();
		String office = EmpUtils.getOffice().getOfficeCode();
		xrMemberRecharge.setUserName(UserUtils.getUser().getCurrentUser().getUserName());
		xrMemberRecharge.setOfficeName(EmpUtils.getOffice().getOfficeName());
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

	public List<MemberInfo> findDataMemberList(MemberInfo memberInfo) {
		return this.memberInfoDao.findList(memberInfo);
	}

	public XrMemberRecharge findMemberCardNum(String miCode){
		HashMap<String,Object> hmap= new HashMap<String,Object>();
		hmap.put("mi_code",miCode);
		return this.xrMemberRechargeDao.findMemberCardNum(hmap);
	}

}