/*
 * 
SELECT CONCAT ('insert into innerfields(fieldName, fieldType, valueType, fieldSql, valid) select ', '\'', 
	 fieldName, '\', \'',fieldType, '\', \'', valueType, '\', \'', REPLACE(fieldSql,'\'','\\\''), '\', ', valid,' from dual where not exists (select id from innerfields where fieldName=\'', fieldName, '\');' ) AS sqlC
FROM innerfields;
*/
/*


INSERT INTO payitems(itemName, itemEnName,category,valueType, isSys, companyId, des) SELECT '实发工资','shifagongzi','142001','148001', 1, 1,'实发工资' FROM DUAL 
WHERE NOT EXISTS (SELECT id FROM payitems WHERE itemName='实发工资');
INSERT INTO payitems(itemName, itemEnName,category,valueType, isSys, companyId, des) SELECT '应发工资','yingfagongzi','142001','148001', 1, 1,'应发工资' FROM DUAL 
WHERE NOT EXISTS (SELECT id FROM payitems WHERE itemName='应发工资');
INSERT INTO payitems(itemName, itemEnName,category,valueType, isSys, companyId, des) SELECT '免税项','mianshuixiang','142001','148001', 1, 1,'免税项' FROM DUAL 
WHERE NOT EXISTS (SELECT id FROM payitems WHERE itemName='免税项');
INSERT INTO payitems(itemName, itemEnName,category,valueType, isSys, companyId, des) SELECT '个人所得税','gerensuodeshui','142001','148001', 2, 1,'个人所得税' FROM DUAL 
WHERE NOT EXISTS (SELECT id FROM payitems WHERE itemName='个人所得税');




INSERT  INTO `pay_rule`(`companyID`,`item`,`isOpen`,`createTime`,`des`,`valid`) SELECT 1,'rank',1,'2016-08-15 19:53:47',NULL,1 FROM DUAL WHERE NOT EXISTS (SELECT id FROM pay_rule WHERE item='rank');
INSERT  INTO `pay_rule`(`companyID`,`item`,`isOpen`,`createTime`,`des`,`valid`) SELECT 1,'post',1,'2016-08-15 19:53:49',NULL,1 FROM DUAL WHERE NOT EXISTS (SELECT id FROM pay_rule WHERE item='post');



INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1694', '1', 'employee', '全体员工表', 'bankCard', '银行卡号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'bankCard');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1695', '1', 'employee', '全体员工表', 'bankName', '发卡银行', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'bankName');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1698', '1', 'employee', '全体员工表', 'birthDay', '出生日期', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'birthDay');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1699', '1', 'employee', '全体员工表', 'checkworkcode', '考勤卡号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'checkworkcode');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1700', '1', 'employee', '全体员工表', 'checkworkid', '关联考勤规则表', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'checkworkid');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1704', '1', 'employee', '全体员工表', 'deptID', '所属部门', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'deptID');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1707', '1', 'employee', '全体员工表', 'education', '学历', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'education');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1708', '1', 'employee', '全体员工表', 'effectiveTime', '生效日期', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'effectiveTime');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1710', '1', 'employee', '全体员工表', 'firstWorkTime', '首次工作日期', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'firstWorkTime');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1711', '1', 'employee', '全体员工表', 'gender', '性别', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'gender');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1712', '1', 'employee', '全体员工表', 'healthEndTime', '健康证到期日', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'healthEndTime');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1713', '1', 'employee', '全体员工表', 'hukouAddress', '户口所在地', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'hukouAddress');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1715', '1', 'employee', '全体员工表', 'hukouType', '户口类型', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'hukouType');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1716', '1', 'employee', '全体员工表', 'idCardType', '证件类型', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'idCardType');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1717', '1', 'employee', '全体员工表', 'isMarried', '婚姻状况', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'isMarried');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1720', '1', 'employee', '全体员工表', 'mail', '邮箱', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'mail');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1721', '1', 'employee', '全体员工表', 'nation', '民族', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'nation');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1724', '1', 'employee', '全体员工表', 'offerTime', '转正日期', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'offerTime');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1728', '1', 'employee', '全体员工表', 'origin', '籍贯', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'origin');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1729', '1', 'employee', '全体员工表', 'phone', '手机号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'phone');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1730', '1', 'employee', '全体员工表', 'photourl', '头像路径', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'photourl');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1731', '1', 'employee', '全体员工表', 'political', '政治面貌', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'political');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1733', '1', 'employee', '全体员工表', 'postID', '岗位', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'postID');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1734', '1', 'employee', '全体员工表', 'qq', 'qq号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'qq');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1735', '1', 'employee', '全体员工表', 'rankID', '职级', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'rankID');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1737', '1', 'employee', '全体员工表', 'startTime', '入职日期', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'startTime');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1741', '1', 'employee', '全体员工表', 'urgentPerson', '紧急联系人', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'urgentPerson');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1742', '1', 'employee', '全体员工表', 'urgentPhone', '紧急联系人电话', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'urgentPhone');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1743', '1', 'employee', '全体员工表', 'userIDCard', '证件号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'userIDCard');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1744', '1', 'employee', '全体员工表', 'userName', '员工姓名', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'userName');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1745', '1', 'employee', '全体员工表', 'userNamePY', '员工拼音', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'userNamePY');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1746', '1', 'employee', '全体员工表', 'userNum', '工号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'userNum');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1748', '1', 'employee', '全体员工表', 'userType', '用工类型', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'userType');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1750', '1', 'employee', '全体员工表', 'weChat', '微信号', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'weChat');
INSERT INTO `comtablefieldinfo` (`id`, `companyId`, `tableNameEn`, `tableNameCh`, `fieldNameEn`, `fieldNameCh`, `valid`) SELECT '1752', '1', 'employee', '全体员工表', 'dormistory', '员工宿舍', '0' FROM DUAL WHERE NOT EXISTS (SELECT id FROM comtablefieldinfo WHERE fieldNameEn = 'dormistory');


INSERT INTO `tableinfo` (`id`, `tableNameEn`, `tableNameCh`) SELECT '1', 'employee', '全体员工表' FROM DUAL WHERE NOT EXISTS (SELECT id FROM tableinfo WHERE tableNameEn = 'employee');


INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '1', 'userName', '员工姓名', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'userName');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '2', 'userNamePY', '员工拼音', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'userNamePY');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '3', 'userNum', '工号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'userNum');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '4', 'idCardType', '证件类型', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'idCardType');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '5', 'userIDCard', '证件号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'userIDCard');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '6', 'education', '学历', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'education');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '7', 'political', '政治面貌', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'political');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '8', 'birthDay', '出生日期', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'birthDay');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '9', 'gender', '性别', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'gender');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '10', 'nation', '民族', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'nation');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '11', 'photourl', '头像路径', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'photourl');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '12', 'origin', '籍贯', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'origin');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '13', 'hukouAddress', '户口所在地', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'hukouAddress');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '14', 'isMarried', '婚姻状况', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'isMarried');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '15', 'hukouType', '户口类型', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'hukouType');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '16', 'urgentPerson', '紧急联系人', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'urgentPerson');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '17', 'urgentPhone', '紧急联系人电话', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'urgentPhone');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '19', 'healthEndTime', '健康证到期日', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'healthEndTime');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '21', 'deptID', '所属部门', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'deptID');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '25', 'weChat', '微信号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'weChat');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '26', 'mail', '邮箱', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'mail');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '27', 'qq', 'qq号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'qq');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '28', 'phone', '手机号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'phone');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '31', 'bankCard', '银行卡号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'bankCard');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '32', 'bankName', '发卡银行', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'bankName');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '34', 'firstWorkTime', '首次工作日期', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'firstWorkTime');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '35', 'startTime', '入职日期', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'startTime');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '36', 'effectiveTime', '生效日期', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'effectiveTime');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '37', 'offerTime', '转正日期', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'offerTime');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '38', 'userType', '用工类型', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'userType');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '40', 'rankID', '职级', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'rankID');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '42', 'postID', '岗位', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'postID');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '48', 'checkworkcode', '考勤卡号', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'checkworkcode');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '50', 'checkworkid', '关联考勤规则表', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'checkworkid');
INSERT INTO `fieldinfo` (`id`, `fieldNameEn`, `fieldNameCh`, `tableId`) SELECT '51', 'dormistory', '员工宿舍', '1' FROM DUAL WHERE NOT EXISTS (SELECT id FROM fieldinfo WHERE fieldNameEn = 'dormistory');


INSERT INTO `pay_incometax_type` (id, `name`, `startpoint`) select 1, '国内', '3500' from dual where not exists (select id from pay_incometax_type where name='国内'); 
INSERT INTO `pay_incometax_type` (id, `name`, `startpoint`) select 2, '外籍', '4800' from dual where not exists (select id from pay_incometax_type where name='外籍');

INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '1', '1', '0', '1500', '0', '1455', '3', '0' from dual where not exists (select id from pay_incometax where rank = 1);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '2', '2', '1500', '4500', '1455', '4155', '10', '105' from dual where not exists (select id from pay_incometax where rank = 2);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '3', '3', '4500', '9000', '4155', '7755', '20', '555' from dual where not exists (select id from pay_incometax where rank = 3);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '4', '4', '9000', '35000', '7755', '27255', '25', '1005' from dual where not exists (select id from pay_incometax where rank = 4);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '5', '5', '35000', '55000', '27255', '41255', '30', '2755' from dual where not exists (select id from pay_incometax where rank = 5);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '6', '6', '55000', '80000', '41255', '57505', '35', '5505' from dual where not exists (select id from pay_incometax where rank = 6);
INSERT INTO `pay_incometax` (`id`, `rank`, `lowLimitAll`, `topLimitAll`, `lowLimit`, `topLimit`, `taxRate`, `deduct`) select '7', '7', '80000', '0', '57505', '0', '45', '13505' from dual where not exists (select id from pay_incometax where rank = 7);


UPDATE payforstaff SET sendNum = 1;

UPDATE paystaff SET sendNum = 1;

update employee set country = 151001;
update employeepay set country = 151001;


DELETE from pushcardtime  where id NOT in (
select * from (
SELECT MAX(ID) from pushcardtime   GROUP BY userID,pushCardTime
) s
);
DELETE from schedule_day  where id NOT in (
select * from (
SELECT MAX(ID) from schedule_day   GROUP BY companyID,userID,monthDate
) s
);
*/
/*
ALTER TABLE `tab_register`
MODIFY COLUMN `des`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述' AFTER `valid`;
-- 小时排班表删掉重复数据
DELETE from schedule_hour  where id NOT in (
select * from (
SELECT MAX(ID) from schedule_hour   GROUP BY companyID,userID,monthDate,startTime,endTime
) s
);

-- 小时排班表增加索引
ALTER TABLE `schedule_hour`
ADD UNIQUE INDEX `ids` (`companyID`, `userID`, `monthDate`, `startTime`, `endTime`) ;

ALTER TABLE `checkwork_rule`
MODIFY COLUMN `overtimeRule`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加班规则1打卡记加班2审批记加班4打卡和审批最低为准记加班5打卡和审批最高为准记加班3超额工时记加班' AFTER `overtimeUnitType`;

ALTER TABLE `checkwork_overtime`
MODIFY COLUMN `overtimeRule`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加班规则1打卡记加班2审批记加班4打卡和审批最低为准记加班5打卡和审批最高为准记加班3超额工时记加班' AFTER `overtimeUnitType`;

update transferwork set status = '150005' where state = '已提交';

update transferwork set status = '150006' where state = '保存未提交';

alter table transferwork drop column state;

update department set type='dept' where type is null or type ='';


ALTER TABLE `dormitoryemployee` drop index `key_dormitoryID`;
ALTER TABLE `dormitoryemployee`
ADD INDEX `key_dormitoryID` (`dormitoryID`) USING BTREE ;

alter table wk_re_arguments drop index `uq`;
alter table wk_re_arguments
add UNIQUE KEY `uq` (`nodeId`,`toNodeId`,`deployId`) USING BTREE COMMENT '唯一索引';

update actleave set status = 150005 where status = 5;

INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '入职', 'employee', '用工类型', 'userType', 'Code', '100000');
INSERT INTO `wk_bus_arguments` (`tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '入职', 'employee', '民族', 'nation', 'Code', '113000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('入职', 'employee', '户口类型', 'hukouType', 'Code', '117000');
INSERT INTO `wk_bus_arguments` (`tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '入职', 'employee', '婚姻状况', 'isMarried', 'Code', '114000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '入职', 'employee', '转正日期', 'offerTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '出差', 'actbustrip', '时长', 'hourOrDays', 'String', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '出差', 'actbustrip', '出差原因', 'reason', 'Code', '134000');

INSERT INTO `wk_bus_arguments` (`tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '加班', 'actovertime', '加班时长', 'dayOrHours', 'String', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '异动', 'transferwork', '异动类型', 'type', 'Code', '124000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '异动', 'transferwork', '异动原因', 'reasion', 'Code', '109000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '异动', 'transferwork', '生效日期', 'effectiveTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '离职', 'leaveoffice', '生效日期', 'effectTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '离职', 'leaveoffice', '离职原因', 'reason', 'Code', '101000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '请假', 'actleave', '请假原因', 'reason', 'Code', '138000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '请假', 'actleave', '请假类型', 'type', 'Code', '133000');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('请假', 'actleave', '请假开始时间', 'startTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '转正', 'official', '生效日期', 'startTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` ( `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ( '转正', 'official', '转正原因', 'reason', 'Code', '105000');
*/

/*
 
truncate table innerfields;
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('1', NULL, NULL, '月总工时', NULL, '1', NULL, NULL, '148001', NULL, 'select total_work_hours from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('5', NULL, NULL, '迟到次数', NULL, '1', NULL, NULL, '148001', NULL, 'select late from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('6', NULL, NULL, '早退次数', NULL, '1', NULL, NULL, '148001', NULL, 'select leave_early from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('7', NULL, NULL, '迟到时间', NULL, '1', NULL, NULL, '148001', NULL, 'select late_time from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('8', NULL, NULL, '早退时间', NULL, '1', NULL, NULL, '148001', NULL, 'select leave_early_time from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('9', NULL, NULL, '事假天数', NULL, '1', NULL, NULL, '148001', NULL, 'select business_leave_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('10', NULL, NULL, '病假天数', NULL, '1', NULL, NULL, '148001', NULL, 'select sick_leave_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('11', NULL, NULL, '婚假天数', NULL, '1', NULL, NULL, '148001', NULL, 'select wedding_leave_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('12', NULL, NULL, '丧假天数', NULL, '1', NULL, NULL, '148001', NULL, 'select funeral_leave_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('13', NULL, NULL, '年假天数', NULL, '1', NULL, NULL, '148001', NULL, 'select annual_leave_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('14', NULL, NULL, '加班工时', NULL, '1', NULL, NULL, '148001', NULL, 'select overtime_work_hours from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('15', NULL, NULL, '其他工时', NULL, '1', NULL, NULL, '148001', NULL, 'select other_work_hours from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('16', NULL, NULL, '调休天数', NULL, '1', NULL, NULL, '148001', NULL, 'select swap_day from month_settlement where userId = #{empID} and yearMonth = #{month}', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('17', NULL, NULL, '职级工资', NULL, '4', NULL, NULL, '148001', NULL, 'SELECT IF((SELECT isOpen FROM pay_rule WHERE item=\'rank\' )=0,0,IFNULL((SELECT salary FROM pay_rank WHERE rankID=(SELECT rankID FROM employee WHERE ID= #{empID} )),0))', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('18', NULL, NULL, '岗位工资', NULL, '4', NULL, NULL, '148001', NULL, 'SELECT IF((SELECT isOpen FROM pay_rule WHERE item=\'post\' )=0,0,IFNULL((SELECT salary FROM pay_post WHERE postID=(SELECT postID FROM employee WHERE ID= #{empID} )),0))', NULL, NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('19', NULL, NULL, '出勤天数', NULL, '1', NULL, NULL, '148001', NULL, 'select act_days from month_settlement where userId = #{empID} and yearMonth = #{month}', '2016-08-25 10:40:54', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('20', NULL, NULL, '姓名', NULL, '4', NULL, NULL, '148002', NULL, 'select userName from employee where ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('21', NULL, NULL, '员工工号', NULL, '4', NULL, NULL, '148002', NULL, 'select userNum from employee where ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('22', NULL, NULL, '员工宿舍', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT C.dormitoryCode FROM employee A LEFT JOIN dormitoryemployee B ON A.ID = B.employeeID LEFT JOIN dormitory C ON B.dormitoryID = C.ID WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('23', NULL, NULL, '户口类型', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT codeName FROM employee A LEFT JOIN codecontent B ON A.hukouType = B.code WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('24', NULL, NULL, '用工类型', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT codeName FROM employee A LEFT JOIN codecontent B ON A.userType = B.code  WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('25', NULL, NULL, '组织', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT B.des FROM employee A LEFT JOIN tab_register B ON A.organizeID = B.ID WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('26', NULL, NULL, '岗位', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT B.postName FROM employee A LEFT JOIN post B ON A.postID = B.ID WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('27', NULL, NULL, '职级', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT B.rankName FROM employee A LEFT JOIN rank B ON A.rankID = B.ID WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('28', NULL, NULL, '生效日期', NULL, '4', NULL, NULL, '148003', NULL, 'SELECT effectiveTime FROM employee WHERE ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('29', NULL, NULL, '工龄', NULL, '4', NULL, NULL, '148001', NULL, 'SELECT IFNULL(IF(FLOOR(DATEDIFF(NOW(),firstWorkTime)/365)<0, 0, FLOOR(DATEDIFF(NOW(),firstWorkTime)/365)),0) AS gongling FROM employee WHERE ID =#{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('30', NULL, NULL, '司龄', NULL, '4', NULL, NULL, '148001', NULL, 'SELECT IFNULL(IF(FLOOR(DATEDIFF(NOW(),startTime)/365)<0, 0, FLOOR(DATEDIFF(NOW(),startTime)/365)),0) AS siling FROM employee WHERE ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('31', NULL, NULL, '职位', NULL, '4', NULL, NULL, '148002', NULL, 'SELECT B.positionName FROM employee A LEFT JOIN POSITION B ON A.positionID = B.ID WHERE A.ID = #{empID}', '2016-10-13 14:44:40', NULL, '1');
INSERT INTO `innerfields` (`ID`, `tableName`, `spell`, `fieldName`, `fieldLabel`, `fieldType`, `fieldLength`, `isNullable`, `valueType`, `systype`, `fieldSql`, `createTime`, `des`, `valid`) VALUES ('32', NULL, NULL, '旷工天数', NULL, '1', NULL, NULL, '148001', NULL, 'select stay_away_hours from month_settlement where userId = #{empID} and yearMonth = #{month}', '2016-10-13 14:44:40', NULL, '1');

 */




/*
/*-表结构修改*/
ALTER TABLE `actbustrip`
MODIFY COLUMN `status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' AFTER `towhere`;

ALTER TABLE `actleave`
MODIFY COLUMN `status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '工作流状态字段编码值' AFTER `type`;

ALTER TABLE `actovertime`
MODIFY COLUMN `status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '加班原因' AFTER `reason`;

/* ** 部署参数表*/
alter TABLE wk_re_arguments MODIFY conditions VARCHAR(21000) DEFAULT '' COMMENT 'tablename#userNum#ID:>1';
/* ** 工作流部署节点详情表*/
alter TABLE wk_re_deployment MODIFY conditions TEXT DEFAULT '' COMMENT '流程条件';
/* ** 运行时参数表*/
alter TABLE wk_ru_arguments MODIFY conditions VARCHAR(21000) DEFAULT '' COMMENT 'tablename#userNum#ID:>1';

/*ALTER TABLE employee ADD expiryDate varchar(50) comment '合同到期日期';*/

/*-数据修改*/
truncate table wk_bus_arguments;
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('1', '入职', 'employee', '用工类型', 'userType', 'Code', '100000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('2', '入职', 'employee', '民族', 'nation', 'Code', '113000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('3', '入职', 'employee', '户口类型', 'hukouType', 'Code', '117000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('4', '入职', 'employee', '婚姻状况', 'isMarried', 'Code', '114000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('5', '入职', 'employee', '转正日期', 'offerTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('6', '出差', 'actbustrip', '时长', 'hourOrDays', 'String', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('7', '出差', 'actbustrip', '出差原因', 'reason', 'Code', '134000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('8', '加班', 'actovertime', '加班时长', 'dayOrHours', 'String', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('9', '异动', 'transferwork', '异动类型', 'type', 'Code', '124000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('10', '异动', 'transferwork', '异动原因', 'reasion', 'Code', '109000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('11', '异动', 'transferwork', '生效日期', 'effectiveTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('12', '离职', 'leaveoffice', '生效日期', 'effectTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('13', '离职', 'leaveoffice', '离职原因', 'reason', 'Code', '101000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('14', '请假', 'actleave', '请假原因', 'reason', 'Code', '138000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('15', '请假', 'actleave', '请假类型', 'type', 'Code', '133000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('16', '请假', 'actleave', '请假开始时间', 'startTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('17', '转正', 'official', '生效日期', 'startTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('18', '转正', 'official', '转正原因', 'reason', 'Code', '105000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('19', '入职', 'employee', '国籍', 'country', 'Code', '151000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('21', '入职', 'employee', '性别', 'gender', 'Code', '118000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('22', '入职', 'employee', '发卡银行', 'bankName', 'Code', '116000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('23', '入职', 'employee', '组织', 'organizeID', 'OrgTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('24', '入职', 'employee', '岗位', 'postID', 'PostTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('25', '入职', 'employee', '职级', 'rankID', 'DataList', '200000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('26', '入职', 'employee', '考勤规则', 'checkworkid', 'DataList', '201000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('27', '异动', 'transferwork', '组织', 'organizeID', 'OrgTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('28', '异动', 'transferwork', '岗位', 'postID', 'PostTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('29', '异动', 'transferwork', '职级', 'rankID', 'DataList', '200000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('30', '异动', 'transferwork', '目标岗位', 'toPostID', 'PostTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('31', '异动', 'transferwork', '目标组织', 'toOrganizeID', 'OrgTree', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('32', '异动', 'transferwork', '目标职级', 'toRankID', 'DataList', '200000');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('33', '请假', 'actleave', '结束时间', 'endTime', 'Date', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('34', '请假', 'actleave', '请假时长', 'dayOrHours', 'String', '0');
INSERT INTO `wk_bus_arguments` (`ID`, `tableName`, `tableNameEn`, `lable`, `lableEn`, `category`, `parentId`) VALUES ('35', '加班', 'actovertime', '加班原因', 'reason', 'Code', '0');


update employee set status = '150005' where status is null;
update employeepay set status = '150005' where status is null;

update actleave set status = '150005' where status='5';
update actbustrip set status = '150005' where status='5';
update actovertime set status = '150005' where status='5';

/*## 时间换算SQL*/
/*INSERT INTO `codedefintion` ( `defintionCode`, `difintionName`, `parentID`, `viewType`, `createTime`, `des`, `valid`) VALUES ( '197100', '时间换算/天', NULL, '单位换算-天/小时', '2016-12-02 14:59:42', '单位换算-天/小时', '1');*/
INSERT INTO `codecontent` (`codeName`, `code`, `difintionID`, `orderNum`, `createTime`, `des`, `valid`, `flag` ) VALUES ('8', '197101', (SELECT ID FROM codedefintion WHERE defintionCode = '197100') , '125', '2016-12-02 14:49:18', '单位换算-天/小时', '1', NULL );

update codecontent set flag = 1 where 
(codeName='试用' and code='120001')or(codeName='在职' and code='120002')
or
(codeName='离职' and code='120003')or(codeName='退休' and code='120004');

/*
update paystaff set sendNum = 1 where sendNum is null;
update payforstaff set sendNum = 1 where sendNum is null;
call pay_updateItems();
*/
call setOrganizeDes();
*/