
CREATE DATABASE flowerdb; 

USE flowerdb;

-- 用户角色表
CREATE TABLE user_role
(
	role_id INT AUTO_INCREMENT COMMENT '角色id 主键自增',
	role_identity VARCHAR(30) NOT NULL COMMENT '身份 1网站用户 2管理员 3管理员',
	PRIMARY KEY(role_id)
);

-- 用户信息表
CREATE TABLE user_info
(
	user_id INT COMMENT '用户编号，主键',
	user_name VARCHAR(200) NOT NULL COMMENT '用户昵称',
	phone CHAR(11) NOT NULL COMMENT '手机号',
	`password` VARCHAR(16) NOT NULL COMMENT '用户密码',
	
	avatar VARCHAR(100) NOT NULL COMMENT '头像图片路径',
	birthdate DATE  COMMENT '出生日期',
	autograph VARCHAR(500) COMMENT '签名',
	`status` INT NOT NULL DEFAULT 1 COMMENT '用户状态 1正常，0异常',
	created DATETIME NOT NULL DEFAULT NOW() COMMENT '注册时间',
	
	role_id INT COMMENT '角色id',
	PRIMARY KEY(user_id),
	FOREIGN KEY(role_id) REFERENCES user_role(role_id)
	
)
-- 会员表
CREATE TABLE user_member
(
	member_id INT AUTO_INCREMENT COMMENT '会员编号，自增',
	member_level INT NOT NULL DEFAULT 1 COMMENT '会员等级，最低等级lv1，最高等级lv5',
	discount DECIMAL(2,1) NOT NULL DEFAULT 9.5 COMMENT '会员折扣，会员等级1 9.5折...',
	integral DECIMAL(7,2) NOT NULL DEFAULT 0 COMMENT '会员积分',
	
	`status` INT DEFAULT 1 COMMENT '会员状态 1正常，2 退出会员',
	
	user_id INT COMMENT '用户编号，外键',
	PRIMARY KEY(member_id),
	FOREIGN KEY(user_id) REFERENCES user_info(user_id)
)


-- 仓库表
CREATE TABLE flower_warehouse
(
	id INT AUTO_INCREMENT COMMENT'仓库编号',
	ware_name VARCHAR(100) COMMENT '仓库名称',
	
	capacity INT COMMENT '仓库总容量',
	stock INT COMMENT '当前仓库存量',
	`status` INT COMMENT '仓库状态 ，1 正常 2，仓库已满',
	ware_explain VARCHAR(1000) COMMENT '存放说明',
	PRIMARY KEY(id)
	
)

-- 仓库数据
INSERT INTO flower_warehouse(ware_name,capacity,stock,`status`,ware_explain) VALUES('一号仓库',1000,0,1,'此仓库只存放玫瑰系列的花')



/**鲜花用途表**/
CREATE TABLE flower_purpose(
	purpose_id INT AUTO_INCREMENT COMMENT '编号', 
	purpose_name VARCHAR(50) COMMENT '用途名称',
	PRIMARY KEY(purpose_id)
)
INSERT INTO flower_purpose(purpose_name) VALUES('生日祝福')
INSERT INTO flower_purpose(purpose_name) VALUES('爱情鲜花')

/**鲜花表**/
CREATE TABLE flower_info(
  flower_id INT AUTO_INCREMENT COMMENT'鲜花编号' ,     
  title VARCHAR(32) COMMENT'鲜花标题', 
  
  cover VARCHAR(128) COMMENT'封面图',
  material VARCHAR(60) COMMENT'材料',             
  pack  VARCHAR(60) COMMENT'包装',
  
  price DECIMAL(10,2) COMMENT'销售价格',            
  stock INT COMMENT'库存',
  buy_Count INT DEFAULT 0 NOT NULL COMMENT'已售数量',

   
  flower_language  VARCHAR(40) COMMENT'花语',     
  details VARCHAR(60) COMMENT'产品说明',
               
  `status` INT COMMENT'鲜花状态，1 表示上架，2 表示下架',
  created DATETIME NOT NULL DEFAULT NOW() COMMENT'创建时间',
  

  purpose_id INT COMMENT '鲜花用途编号',
  warehouse_id INT COMMENT'仓库编号',
  PRIMARY KEY(flower_id)
  )		
    

SELECT * FROM flower_info
DELETE FROM flower_info

/**鲜花图片**/
CREATE TABLE flower_picture(
  picture_id INT PRIMARY KEY AUTO_INCREMENT,    #鲜花图片编号
  flower_id INT,                    		#鲜花编号
  img_url VARCHAR(128)         			#图片路径
);
SELECT * FROM FLOWER_picture

DROP TABLE flower_picture
DROP TABLE user_member

SELECT * FROM user_role

        SELECT
        user_id,user_name,phone,avatar,birthdate,autograph,`status`,created,user_info.role_id roleId
        FROM user_info
        LEFT JOIN user_role ON user_info.role_id = user_role.role_id
        
             SELECT user_role.role_id,role_identity,user_name FROM user_role
        LEFT JOIN user_info ON user_info.role_id=user_role.role_id



-- 测试数据
INSERT INTO user_role(role_identity) VALUES('网站用户');
INSERT INTO user_role(role_identity) VALUES('管理员');
INSERT INTO user_role(role_identity) VALUES('超级管理员');


INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10001,'小花','110','123123','/img/aaa.jpg',1);
INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10002,'小白','120','123123','/img/bbb.jpg',2);
INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10003,'小牛','119','123123','/img/ccc.jpg',2);
INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10004,'小陈','112','123123','/img/ddd.jpg',1);
INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10005,'小虎','12306','123123','/img/aaa.jpg',1);
INSERT INTO user_info(user_id,user_name,phone,`password`,avatar,role_id) VALUES(10006,'小志','888','123123','/img/aaa.jpg',1);

-- 会员数据
INSERT INTO user_member(member_level,discount,integral,user_id) VALUES(2,9,2000,10001)

SELECT * FROM user_info
SELECT * FROM user_member

DROP TABLE user_info
DROP TABLE user_member

SELECT * FROM userinfo


