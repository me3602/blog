INSERT INTO category(depth,list_seq,name,parent_name,parent_seq,view_flag) VALUES(0,1,'JAVA','root',0,'Y'),(0,2,'PHP','root',0,'Y'),(1,1,'Spring','JAVA',1,'Y'),(1,2,'TEST','PHP',2,'Y')

INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트',0,'N','제목','admin','admin',now(),now(),'Y',3)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트',0,'N','제목','admin','admin',now(),now(),'Y',3)
INSERT INTO board(contents,hit,notice_flag,title,user_id,user_nick,reg_date,mod_date,view_flag,cat_seq_no) VALUES('테스트',0,'N','제목','admin','admin',now(),now(),'Y',4)