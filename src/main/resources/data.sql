insert into user_details(id,name,birth_date)
values(101,'Sandip',current_date());

insert into user_details(id,name,birth_date)
values(102,'Sandip123',current_date());

insert into user_details(id,name,birth_date)
values(103,'Sandip456',current_date());

insert into post(id,description,user_id)
values(201,'I learn Java',101);

insert into post(id,description,user_id)
values(202,'I learn Spring',101);

insert into post(id,description,user_id)
values(203,'I learn AWS',102);

insert into post(id,description,user_id)
values(204,'I learn Azure',102);

insert into post(id,description,user_id)
values(205,'I learn MySQL',103);

insert into post(id,description,user_id)
values(206,'I learn OracleSQL',103);

insert into todo (id,description,done,target_date,username)
values (1001,'Learn Spring boot',false,CURRENT_DATE(),'sandip');

insert into todo (id,description,done,target_date,username)
values (1002,'Learn Spring ',false,CURRENT_DATE(),'sandip');

insert into todo (id,description,done,target_date,username)
values (1003,'Learn Spring JPA',false,CURRENT_DATE(),'sandip');
