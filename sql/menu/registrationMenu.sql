-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛', '3', '1', 'registration', 'system/registration/index', 1, 0, 'C', '0', '0', 'system:registration:list', '#', 'admin', sysdate(), '', null, '报名参赛菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:registration:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:registration:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:registration:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:registration:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('报名参赛导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:registration:export',       '#', 'admin', sysdate(), '', null, '');