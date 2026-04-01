-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题', '3', '1', 'discussion', 'system/discussion/index', 1, 0, 'C', '0', '0', 'system:discussion:list', '#', 'admin', sysdate(), '', null, '在线讨论主题菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:discussion:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:discussion:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:discussion:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:discussion:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('在线讨论主题导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:discussion:export',       '#', 'admin', sysdate(), '', null, '');