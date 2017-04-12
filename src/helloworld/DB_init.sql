--数据库建表语句，初始化项目内容
-- Create table  账号测试表
create table TEST_ACCOUNT
(
  acc_code       INTEGER not null,
  acc_name       VARCHAR2(64),
  acc_remark     VARCHAR2(64),
  acc_state      VARCHAR2(64),
  acc_creat_time TIMESTAMP(6),
  acc_login_time TIMESTAMP(6),
  acc_type       VARCHAR2(64)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TEST_ACCOUNT
  is '账号管理表';
-- Add comments to the columns 
comment on column TEST_ACCOUNT.acc_code
  is '主键';
comment on column TEST_ACCOUNT.acc_name
  is '名称';
comment on column TEST_ACCOUNT.acc_remark
  is '备注';
comment on column TEST_ACCOUNT.acc_state
  is '状态';
comment on column TEST_ACCOUNT.acc_creat_time
  is '创建时间';
comment on column TEST_ACCOUNT.acc_login_time
  is '登陆时间';
comment on column TEST_ACCOUNT.acc_type
  is '账号类型';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEST_ACCOUNT
  add constraint PK_TEST_ACCOUNT primary key (ACC_CODE)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

  
  
-- Create table  日志信息表
create table TEST_SYS_LOG
(
  id          VARCHAR2(64) not null,
  user_code   VARCHAR2(128),
  user_name   VARCHAR2(256),
  class_name  VARCHAR2(128),
  mothod_name VARCHAR2(256),
  create_time TIMESTAMP(6),
  log_level   VARCHAR2(32),
  log_msg     VARCHAR2(1024)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column TEST_SYS_LOG.id
  is '主键';
comment on column TEST_SYS_LOG.user_code
  is '用户ID';
comment on column TEST_SYS_LOG.user_name
  is '用户姓名';
comment on column TEST_SYS_LOG.class_name
  is '类名';
comment on column TEST_SYS_LOG.mothod_name
  is '方法名';
comment on column TEST_SYS_LOG.create_time
  is '产生时间';
comment on column TEST_SYS_LOG.log_level
  is '日志级别';
comment on column TEST_SYS_LOG.log_msg
  is '日志信息';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEST_SYS_LOG
  add constraint TEST_SYS_LOG_PKEY primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
