INSERT INTO category(depth,list_seq,name,parent_name,parent_seq,view_flag) VALUES(0,1,'일상','single',0,'Y'),(0,2,'JAVA','root',0,'Y'),(0,3,'PHP','root',0,'Y'),(1,2,'Spring','JAVA',1,'Y'),(1,3,'TEST','PHP',2,'Y')

INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트1',0,'N','제목1','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트2',0,'N','제목2','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트3',0,'N','제목3','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트4',0,'N','제목4','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트5',0,'N','제목5','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트6',0,'N','제목6','admin','admin',now(),now(),'Y',4)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트',0,'N','제목','admin','admin',now(),now(),'Y',5)