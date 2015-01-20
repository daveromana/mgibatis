# mgibatis
梦来梦往学习使用ibatis

##0015-1-19
完成ibatis的快速入门。

将数据库从mysql改为oracle。
oracle的主键自动增长，需要用序列来实现。
	CREATE SEQUENCE autoReq
	INCREMENT BY 1 -- 每次加几个
	START WITH 1 -- 从1开始计数
	NOMAXVALUE -- 不设置最大值
	NOCYCLE -- 一直累加，不循环
	CACHE 10;
