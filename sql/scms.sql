-- ----------------------------
-- 1、竞赛信息表 (对应竞赛信息模块)
-- ----------------------------
drop table if exists bus_competition;
create table bus_competition
(
    comp_id         bigint(20)      not null auto_increment    comment '竞赛ID',
    comp_name       varchar(100) not null comment '竞赛名称',
    comp_level      varchar(20)  default '' comment '竞赛级别（关联字典：国家级、省级、校级）',
    comp_type       varchar(50)  default '' comment '竞赛类别（关联字典：创新创业、学科竞赛等）',
    organizer       varchar(100) default '' comment '主办单位',
    sign_start_time datetime comment '报名开始时间',
    sign_end_time   datetime comment '报名截止时间',
    comp_start_time datetime comment '竞赛开始时间',
    comp_end_time   datetime comment '竞赛结束时间',
    content         longtext     default null comment '竞赛详情/通知正文',
    attachment      varchar(255) default '' comment '附件地址（多文件按逗号分隔）',
    status          char(1)      default '0' comment '发布状态（0发布 1草稿 2下架）',
    del_flag        char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    remark          varchar(500) default null comment '备注',
    primary key (comp_id)
) engine=innodb auto_increment=100 comment = '竞赛信息表';

-- ----------------------------
-- 2、报名参赛表 (对应报名参赛模块)
-- ----------------------------
drop table if exists bus_registration;
create table bus_registration
(
    reg_id       bigint(20)      not null auto_increment    comment '报名ID',
    comp_id      bigint(20)      not null                   comment '竞赛ID',
    user_id      bigint(20)      not null                   comment '申报人/队长ID（关联sys_user）',
    team_name    varchar(50) not null comment '团队名称',
    teacher_name varchar(50)  default '' comment '指导老师姓名',
    member_info  varchar(500) default '' comment '团队成员信息（可存JSON或逗号分隔的学号/姓名）',
    reg_file     varchar(255) default '' comment '报名附件/作品文件地址',
    audit_status char(1)      default '0' comment '审核状态（0待审核 1通过 2驳回）',
    audit_msg    varchar(200) default '' comment '审核反馈意见',
    status       char(1)      default '0' comment '状态（0正常 1停用）',
    del_flag     char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by    varchar(64)  default '' comment '创建者（报名人）',
    create_time  datetime comment '创建时间（报名时间）',
    update_by    varchar(64)  default '' comment '更新者（审核人）',
    update_time  datetime comment '更新时间（审核时间）',
    remark       varchar(500) default null comment '备注',
    primary key (reg_id),
    key          idx_comp_id (comp_id),
    key          idx_user_id (user_id)
) engine=innodb auto_increment=100 comment = '报名参赛表';

-- ----------------------------
-- 3、在线讨论主题表 (对应在线讨论模块)
-- ----------------------------
drop table if exists bus_discussion;
create table bus_discussion
(
    post_id     bigint(20)      not null auto_increment    comment '帖子ID',
    comp_id     bigint(20)      default null               comment '所属竞赛ID（为空则为公共讨论板）',
    user_id     bigint(20)      not null                   comment '发帖人ID',
    title       varchar(100) not null comment '讨论标题',
    content     longtext     not null comment '讨论内容',
    view_count  int(11)         default 0                  comment '浏览量',
    is_top      char(1)      default '0' comment '是否置顶（0否 1是）',
    status      char(1)      default '0' comment '状态（0正常 1封禁/隐藏）',
    del_flag    char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (post_id)
) engine=innodb auto_increment=100 comment = '在线讨论主题表';

-- ----------------------------
-- 4、在线讨论回复表 (对应在线讨论模块-跟帖功能)
-- ----------------------------
drop table if exists bus_reply;
create table bus_reply
(
    reply_id    bigint(20)      not null auto_increment    comment '回复ID',
    post_id     bigint(20)      not null                   comment '帖子ID',
    parent_id   bigint(20)      default 0                  comment '父回复ID（0代表直接回复主帖）',
    user_id     bigint(20)      not null                   comment '回复人ID',
    content     text not null comment '回复内容',
    status      char(1)      default '0' comment '状态（0正常 1隐藏）',
    del_flag    char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (reply_id),
    key         idx_post_id (post_id)
) engine=innodb auto_increment=100 comment = '在线讨论回复表';

-- ----------------------------
-- 5、成绩发布表 (对应成绩发布模块)
-- ----------------------------
drop table if exists bus_score;
create table bus_score
(
    score_id    bigint(20)      not null auto_increment    comment '成绩ID',
    comp_id     bigint(20)      not null                   comment '竞赛ID',
    reg_id      bigint(20)      not null                   comment '报名ID（关联队伍）',
    score_value decimal(5, 2) default null comment '具体分数（支持两位小数）',
    award_level varchar(20)   default '' comment '获奖等第（关联字典：特等奖、一等奖等）',
    ranking     int(11)         default null               comment '排名',
    is_publish  char(1)       default '0' comment '是否发布（0未发布 1已发布）',
    status      char(1)       default '0' comment '状态（0正常 1停用）',
    del_flag    char(1)       default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64)   default '' comment '创建者（录入人）',
    create_time datetime comment '创建时间',
    update_by   varchar(64)   default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500)  default null comment '评语/备注',
    primary key (score_id),
    unique key uniq_comp_reg (comp_id, reg_id)
) engine=innodb auto_increment=100 comment = '成绩发布表';

-- ----------------------------
-- 6、初始化业务字典数据 (配合若依字典管理，提高系统可维护性)
-- ----------------------------
-- 插入字典类型
insert into sys_dict_type
values (101, '竞赛级别', 'bus_comp_level', '0', 'admin', sysdate(), '', null, '竞赛级别列表');
insert into sys_dict_type
values (102, '审核状态', 'bus_audit_status', '0', 'admin', sysdate(), '', null, '报名审核状态');
insert into sys_dict_type
values (103, '奖项等第', 'bus_award_level', '0', 'admin', sysdate(), '', null, '获奖等级');

-- 插入字典数据
insert into sys_dict_data
values (1011, 1, '国家级', '1', 'bus_comp_level', '', 'primary', 'Y', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1012, 2, '省级', '2', 'bus_comp_level', '', 'success', 'N', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1013, 3, '校级', '3', 'bus_comp_level', '', 'info', 'N', '0', 'admin', sysdate(), '', null,
        '');

insert into sys_dict_data
values (1021, 1, '待审核', '0', 'bus_audit_status', '', 'warning', 'Y', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1022, 2, '已通过', '1', 'bus_audit_status', '', 'success', 'N', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1023, 3, '已驳回', '2', 'bus_audit_status', '', 'danger', 'N', '0', 'admin', sysdate(), '',
        null, '');

insert into sys_dict_data
values (1031, 1, '特等奖', '0', 'bus_award_level', '', 'danger', 'N', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1032, 2, '一等奖', '1', 'bus_award_level', '', 'primary', 'N', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1033, 3, '二等奖', '2', 'bus_award_level', '', 'success', 'N', '0', 'admin', sysdate(), '',
        null, '');
insert into sys_dict_data
values (1034, 4, '三等奖', '3', 'bus_award_level', '', 'info', 'N', '0', 'admin', sysdate(), '',
        null, '');