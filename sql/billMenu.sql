-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单', '2000', '1', '/barracudabill/bill', 'C', '0', 'barracudabill:bill:view', '#', 'admin', sysdate(), '', null, '账单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单查询', @parentId, '1',  '#',  'F', '0', 'barracudabill:bill:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单新增', @parentId, '2',  '#',  'F', '0', 'barracudabill:bill:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单修改', @parentId, '3',  '#',  'F', '0', 'barracudabill:bill:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单删除', @parentId, '4',  '#',  'F', '0', 'barracudabill:bill:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单导出', @parentId, '5',  '#',  'F', '0', 'barracudabill:bill:export',       '#', 'admin', sysdate(), '', null, '');
