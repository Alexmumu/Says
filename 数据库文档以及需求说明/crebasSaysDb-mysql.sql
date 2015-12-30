/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/1/6 19:14:43                            */
/*==============================================================*/


drop table if exists says_album;

drop table if exists says_browse;

drop table if exists says_comments;

drop table if exists says_friends;

drop table if exists says_leaveword;

drop table if exists says_like;

drop table if exists says_news;

drop table if exists says_photo;

drop table if exists says_protection;

drop table if exists says_relay;

drop table if exists says_reply;

drop table if exists says_rizhi;

drop table if exists says_rizhitype;

drop table if exists says_shuoshuo;

drop table if exists says_user;

drop table if exists says_userword;

drop table if exists says_visit;

drop table if exists says_msgcenter;

drop table if exists says_frequest;

/*==============================================================*/
/* Table: says_album                                            */
/*==============================================================*/
create table says_album
(
   albumid              varchar(100) not null,
   albumtitle           varchar(200),
   userid               varchar(100),
   albumremark          varchar(500),
   albumdate            timestamp,
   albumtopimg          varchar(200),
   albumstatus          int comment '相册的状态  0 已删除 1代表正常 2 代表不可删除',
   primary key (albumid)
);

alter table says_album comment '相册表，每个用户下 都有一个默认的相册 是不可删除的。';

/*==============================================================*/
/* Table: says_browse                                           */
/*==============================================================*/
create table says_browse
(
   browseid             varchar(100) not null,
   browsefor            varchar(100),
   fromuserid           varchar(100),
   primary key (browseid)
);

alter table says_browse comment '浏览阅读表';

/*==============================================================*/
/* Table: says_comments                                         */
/*==============================================================*/
create table says_comments
(
   commentid            varchar(100) not null,
   commentcontent       varchar(500),
   userid               varchar(100),
   commentdate          timestamp,
   commentsforid        varchar(100) comment '指的是 说说或日志或相片。',
   commentstatus        varchar(100) comment '评论的状态 0代表已删除，1代表正常。',
   primary key (commentid)
);

alter table says_comments comment '评论表';

/*==============================================================*/
/* Table: says_friends                                          */
/*==============================================================*/
create table says_friends
(
   friendid             varchar(100) not null,
   userid               varchar(100),
   userfriendid         varchar(100),
   primary key (friendid)
);

alter table says_friends comment '好友关系记录表';

/*==============================================================*/
/* Table: says_leaveword                                        */
/*==============================================================*/
create table says_leaveword
(
   leavewordid          varchar(100) not null,
   leavewordcontent     varchar(1000),
   leaveworddate        timestamp,
   userid               varchar(100),
   fromuserid           varchar(100),
   levewodidstatus      int comment '0代表删除，1代表正常。',
   primary key (leavewordid)
);

alter table says_leaveword comment '留言表';

/*==============================================================*/
/* Table: says_like                                             */
/*==============================================================*/
create table says_like
(
   likeid               varchar(100) not null,
   likefor              varchar(100),
   fromuserid           varchar(100),
   primary key (likeid)
);

alter table says_like comment '点赞表';

/*==============================================================*/
/* Table: says_news                                             */
/*==============================================================*/
create table says_news
(
   newsid               varchar(100) not null,
   newscontent          varchar(100) comment '代表是说说或者日志相片',
   userid               varchar(100),
   newsstatus           int comment '动态的类型详解：1,发表说说 2.转发说说 3.发表日志 4.转载日志 5.上传相片 6.转载相片',
   newtime              timestamp,
   primary key (newsid)
);

alter table says_news comment '动态表：记录用户的行为，发表说说，转发说说，发表日志，转载日志，上传相片，转载相片。';

/*==============================================================*/
/* Table: says_photo                                            */
/*==============================================================*/
create table says_photo
(
   photoid              varchar(100) not null,
   photosrc             varchar(200),
   photoremark          varchar(500),
   photodate            timestamp,
   albumid              varchar(100),
   userid               varchar(100),
   photofrom            int comment '相片是自己传的，还是转载的。 1.自己传的  2.转载的。',
   photostatus          int comment '相片状态详解：0代表删除，1代表正常，2代表是转载的',
   primary key (photoid)
);

alter table says_photo comment '相片表，相片转载后就永久存在了，原照片的主人删除照片还是可以存在我自己的相册中。';

/*==============================================================*/
/* Table: says_protection                                       */
/*==============================================================*/
create table says_protection
(
   protectionid         varchar(100) not null,
   questionno1          varchar(200),
   answerno1            varchar(200),
   questionno2          varchar(200),
   answerno2            varchar(200),
   questionno3          varchar(200),
   answerno3            varchar(200),
   userid               varchar(100),
   primary key (protectionid)
);

alter table says_protection comment '密码保护问题表';

/*==============================================================*/
/* Table: says_relay                                            */
/*==============================================================*/
create table says_relay
(
   relayid              varchar(100) not null,
   relayfor             varchar(100),
   userid               varchar(100),
   relayfrom            varchar(100) comment '被转发的项目id',
   relayafter           varchar(100) comment '根据项目，转发后的另一个项目的id',
   primary key (relayid)
);

alter table says_relay comment '转发表';

/*==============================================================*/
/* Table: says_reply                                            */
/*==============================================================*/
create table says_reply
(
   replyid              varchar(100) not null,
   replycontent         varchar(500),
   replydate            timestamp,
   userid               varchar(100),
   commentid            varchar(100),
   replyare             varchar(100),
   replystatus          int comment '回复的状态详解： 0代表删除，1代表正常，2代表这是个回复别人的回复。',
   primary key (replyid)
);

alter table says_reply comment '回复表的作用，在评论下面进行回复。';

/*==============================================================*/
/* Table: says_rizhi                                            */
/*==============================================================*/
create table says_rizhi
(
   rizhiid              varchar(100) not null,
   rizhititle           varchar(200),
   rizhicontent         varchar(5000),
   rizhidate            timestamp,
   rizhitype            varchar(100),
   rizhistatus          int comment '日志类型状态详解：0代表已删除，1代表正常，2代表是转载的日志。',
   rizhiuserid          varchar(100),
   primary key (rizhiid)
);

alter table says_rizhi comment '转载的日志，是把内容深拷贝到并是新创建一个日志。
若日志是转载的，本日志将共享日志源的转载数，并且转载的日志';

/*==============================================================*/
/* Table: says_rizhitype                                        */
/*==============================================================*/
create table says_rizhitype
(
   typeid               varchar(100) not null,
   userid               varchar(100),
   typeform             varchar(100),
   typename             varchar(200),
   timedate             timestamp,
   typestatus           int comment '日志类型状态详解：0代表删除，1代表正常，2代表不可删除。',
   primary key (typeid)
);

alter table says_rizhitype comment '日志类型中 每个用户都有一条默认的数据 个人日志，那个是不可删除的。';

/*==============================================================*/
/* Table: says_shuoshuo                                         */
/*==============================================================*/
create table says_shuoshuo
(
   shuoid               varchar(100) not null,
   shuocontent          varchar(500),
   shuoimg              varchar(200),
   userid               varchar(100),
   shuodate             timestamp,
   shuostatus           int comment '说说状态详解，0代表删除，1代表正常，2代表是转发的。',
   primary key (shuoid)
);

alter table says_shuoshuo comment '说说表，转发他人说说，若他人的说说i删除，你这边的说说将显示说说已删除。每个说说不管是转发 还是自己发表的，都将拥有自己';

/*==============================================================*/
/* Table: says_user                                             */
/*==============================================================*/
create table says_user
(
   userid               varchar(100) not null,
   username             varchar(200),
   userpassword         varchar(200),
   usernickname         varchar(200),
   usersex              int,
   userimg              varchar(200),
   usersig              varchar(200),
   userbirthday         timestamp,
   userregisterday      timestamp,
   userarea             varchar(200),
   primary key (userid)
);

alter table says_user comment '用户信息表';

/*==============================================================*/
/* Table: says_userword                                         */
/*==============================================================*/
create table says_userword
(
   userwordid           varchar(100) not null,
   userwordcontent      varchar(1000),
   userid               varchar(100),
   primary key (userwordid)
);

alter table says_userword comment '用于在想说网主人留言板模块的留言寄语中';

/*==============================================================*/
/* Table: says_visit                                            */
/*==============================================================*/
create table says_visit
(
   visitid              varchar(100) not null,
   userid               varchar(100),
   fromuserid           varchar(100),
   primary key (visitid)
);

alter table says_visit comment '访问记录表';

/*==============================================================*/
/* Table: says_msgcenter                                        */
/*==============================================================*/
create table says_msgcenter
(
   mcid                 varchar(100) not null,
   userid               varchar(100),
   mcfromid             varchar(100) comment '消息源的id  如好友申请表的id，点赞表，转发表的id，评论表的id，回复表的id',
   mctype               int comment '消息的类型
            1.好友申请
            2.说说被评论
            3.说说被转发
            4.说说被赞
            5.日志被评论
            6.日志被转发
            7.日志被赞
            8.相片被评论
            9.相片被转发
            10.相片被赞',
   mcstatus             int comment '根据状态来判断 已读 和 未读 0代表已读  1.代表未读',
   mcuser               varchar(100),
   msctime              timestamp,
   primary key (mcid)
);

alter table says_msgcenter comment '记录关于用户的各种消息 并向用户推送
1.好友申请
2.说说被评论
3.说说被转发
';

/*==============================================================*/
/* Table: says_frequest                                         */
/*==============================================================*/
create table says_frequest
(
   frid                 varchar(100) not null,
   fruser               varchar(100),
   fruserare            varchar(100),
   frstatus             int comment '1.代表申请已发出  2.代表同意 3.代表拒绝',
   frtime               timestamp,
   primary key (frid)
);

alter table says_frequest comment '好友申请表：好友申请的数据，用一个列的状态 代表各种情况 来回修改';

alter table says_album add constraint fk_reference_19 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_browse add constraint fk_reference_13 foreign key (fromuserid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_comments add constraint fk_reference_6 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_friends add constraint fk_reference_2 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_friends add constraint fk_reference_3 foreign key (userfriendid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_leaveword add constraint fk_reference_22 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_leaveword add constraint fk_reference_23 foreign key (fromuserid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_like add constraint fk_reference_11 foreign key (fromuserid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_news add constraint fk_reference_9 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_photo add constraint fk_reference_20 foreign key (albumid)
      references says_album (albumid) on delete restrict on update restrict;

alter table says_photo add constraint fk_reference_25 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_protection add constraint fk_reference_1 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_relay add constraint fk_reference_14 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_relay add constraint fk_reference_15 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_reply add constraint fk_reference_7 foreign key (commentid)
      references says_comments (commentid) on delete restrict on update restrict;

alter table says_reply add constraint fk_reference_8 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_rizhi add constraint fk_reference_18 foreign key (rizhitype)
      references says_rizhitype (typeid) on delete restrict on update restrict;

alter table says_rizhitype add constraint fk_reference_24 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_shuoshuo add constraint fk_reference_16 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_userword add constraint fk_reference_21 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_visit add constraint fk_reference_4 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_visit add constraint fk_reference_5 foreign key (fromuserid)
      references says_user (userid) on delete restrict on update restrict;

alter table says_msgcenter add constraint fk_reference_26 foreign key (userid)
      references says_user (userid) on delete restrict on update restrict;

