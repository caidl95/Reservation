CREATE TABLE res_checkIn
(
  ID INT  primary key auto_increment COMMENT '流水号',
  BarCode VARCHAR (50) DEFAULT NULL COMMENT '登记号',
  Identity VARCHAR (50) COMMENT '身份证号',
  Name  VARCHAR (100) COMMENT '姓名',
  Age  VARCHAR (100) COMMENT '年龄',
  Sex  VARCHAR (100) COMMENT '性别',
  Province VARCHAR (300) COMMENT '省',
  City VARCHAR (300) COMMENT '市',
  Area   VARCHAR (300) COMMENT '区',
  Addr VARCHAR (300) COMMENT '详细地址',
  Email VARCHAR (300) COMMENT '邮箱',
  Phone VARCHAR (300) COMMENT '电话',
  BornDate VARCHAR (300) COMMENT '出生日期',
  Nation VARCHAR (300) COMMENT '民族',
  IsMarry VARCHAR (300) COMMENT '是否婚配',
  Status  VARCHAR (100) COMMENT '状态0-未到，1-已到',
  CombinItemCode VARCHAR (300) COMMENT '检查项目编码',
  CombinItemName VARCHAR (300) COMMENT '检查项目名称',
  CreatedBy      VARCHAR (100) COMMENT '创建人',
  CreatedOn      DATETIME COMMENT '创建日期',
  ModifiedBy     VARCHAR (100) COMMENT '修改人',
  ModifiedOn     DATETIME COMMENT '修改日期',
  DescflexField1 VARCHAR (200) COMMENT '扩展字段',
  DescflexField2 VARCHAR (201),
  DescflexField3 VARCHAR (202),
  DescflexField4 VARCHAR (203),
  DescflexField5 VARCHAR (204)
);

insert into res_checkIn
    (ID,BarCode,Identity,Name,Age,Sex,Province,City,Area,Addr,CreatedBy,CreatedOn,Status,CombinItemCode,CombinItemName,Phone)
values
       (2,'10002','333333222211119999','李四','17','男','银河系','太阳系','地球','CHina','admin','2019/7/4 10:02:00','1','CB0001','四维彩超','13344445555'),
       (3,'10003','333333222211118888','王五','17','男','银河系','太阳系','地球','CHina','admin','2019/7/4 10:02:00','0','CB0002','三维彩超','13344446666'),
       (4,'10004','333333222211117777','赵六','17','男','银河系','太阳系','地球','CHina','admin','2019/7/4 10:02:00','0','CB0003','二维彩超','13344447777'),
       (5,'10005','333333222211116666','尼古拉斯','17','男','银河系','太阳系','二次元','CHina','admin','2019/7/4 10:02:00','1','CB0001','四维彩超','13344448888'),
       (6,'10006','333333222211115555','张择端','17','男','银河系','太阳系','地球','CHina','admin','2019/7/4 10:02:00','0','CB0001','四维彩超','13344449999'),
       (7,'10007','333333222211114444','周瑞琪','17','男','银河系','太阳系','地球','CHina','admin','2019/7/4 10:02:00','0','CB0001','四维彩超','13344449999'),



--管理员登录表与信息
CREATE TABLE res_user (
	id int(11) NOT NULL AUTO_INCREMENT,
	loginname varchar(50) NOT NULL COMMENT '登录用户名',
	password varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
	email    varchar(50) DEFAULT NULL COMMENT '邮箱',
	phone    varchar(20) DEFAULT NULL COMMENT '手机号码',
	nickname varchar(50) DEFAULT 'new user' COMMENT '用户昵称',
	question varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  answer   varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  role int(4) NOT NULL COMMENT '角色0-管理员,1-员工操作',
  create_time datetime NOT NULL COMMENT '创建时间',
  update_time datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

insert into res_user values ('1','admin','E10ADC3949BA59ABBE56E057F20F883E','caidl95@163.com', '13662925808','feel', '问题','答案', '0', now(),now());

