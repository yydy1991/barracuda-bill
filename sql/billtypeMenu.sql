-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型', '2000', '1', '/barracudabill/billtype', 'C', '0', 'barracudabill:billtype:view', '#', 'admin', sysdate(), '', null, '账单类型菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型查询', @parentId, '1',  '#',  'F', '0', 'barracudabill:billtype:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型新增', @parentId, '2',  '#',  'F', '0', 'barracudabill:billtype:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型修改', @parentId, '3',  '#',  'F', '0', 'barracudabill:billtype:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型删除', @parentId, '4',  '#',  'F', '0', 'barracudabill:billtype:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('账单类型导出', @parentId, '5',  '#',  'F', '0', 'barracudabill:billtype:export',       '#', 'admin', sysdate(), '', null, '');
