use manish;

create table progressUser1(
u_id int references user1(user_id) ,
learn_cpp varchar(20),
learn_sql varchar(20),
learn_html varchar(20),
learn_javascript varchar(20),
learn_java varchar(20)
);
drop table progressuser1;

insert into progressuser1 
values (1,'Completed', 'started', 'completed', 'not enrolled', 'completed'),
(2,'Completed', 'incomplete', 'completed', 'started', 'completed'),
(3,'started', 'not started', 'completed', 'notstarted', 'incomplete'),
(4,'Completed', 'not enrolled', 'started', 'started', 'started'),
(5,'Completed', 'completed', 'completed', 'incomplete', 'completed'),
(6,'Completed', 'completed', 'completed', 'started', 'started'),
(7,'not started', 'completed', 'completed', 'started', 'completed'),
(8,'incomplete', 'started', 'completed', 'completed', 'completed'),
(9,'Completed', 'incomplete', 'completed', 'incomplete', 'started'),
(10,'Completed', 'started', 'incompleted', 'notstarted', 'incompleted');

select * from progressuser1;

-----------------------------------------------------------------------------
create table user1(
user_id int primary key,
email_domain varchar(20),
country varchar(20),
city varchar(20),
postal int,
mobile_app varchar(20),
sign_up_at timestamp
);

drop table user1;

insert into user1 
values(1, 'psb.edu', 'US', 'New York', 67975, 'mobile-user','2015-01-01 18:33:52'),
(2, 'nsk.edu', 'Uk', 'London', 469875, null,'2020-03-06 12:36:22'),
(3, 'shoi.edu', 'Rs', 'Mosco', 58858, null,'2017-08-07 17:56:06'),
(4, 'hgf.edu', 'Pk', 'Lahore', 00454, 'mobile-user','2019-06-21 11:33:54'),
(5, 'sri.edu', 'IN', 'Hyderbad', 500006, 'mobile-user','2016-10-30 01:54:40'),
(6, 'rhe.edu', 'US', 'New York', 67975, null,'2014-03-02 17:43:22'),
(7, 'ibm.edu', 'IN', 'Pune', 64049, 'mobile-user','2013-04-04 18:33:42'),
(8, 'kkr.edu', 'UK', 'Oval', 96464, 'mobile-user','2013-01-21 08:13:52'),
(9, 'Burj.edu', 'Ae', 'Dubai', 645975, null,'2016-04-03 23:03:52'),
(10, 'pgtf.edu', 'US', 'New York', 67975, null,'2014-01-21 22:13:32');

update user1 set city ='Hyderabad'
where user_id = 5;

select * from user1;
---------------------------------------------------------------------------------------------------
-- What are the Top 25 schools?

select email_domain, count(*) from user1
group by email_domain
order by count(*) desc
limit 25;

-- How many .edu learners are located in New York?
select city, count(*)
 from user1
 where city = 'new york';
 

-- How many of these Codecademy learners are using the mobile app?
select mobile_app, 
count(*) 
from user1
 group by mobile_app;


-- Using strftime()

select timestamp(sign_up_at, '%Y-%m-%d %H:0:0') as singup_hour,
count(*) as signup_count 
from user1
group by 1
order by 1;

-- joins
select * from user1 
join progressuser1 on user1.user_id = progressuser1.u_id;

-- prefered courses by diff .edu schools 
select u.email_domain,p.learn_cpp,p.learn_sql,p.learn_html,p.learn_javascript,p.learn_java
from user1 u
join progressuser1 p on u.user_id = p.u_id
group by 1,2,3,4,5,6;

-- course taken by new york students
select u.email_domain,p.learn_cpp,p.learn_sql,p.learn_html,p.learn_javascript,p.learn_java
from user1 u
join progressuser1 p on u.user_id = p.u_id
where u.city = 'new york';

-- course taken by hyderabad students
select u.email_domain,p.learn_cpp,p.learn_sql,p.learn_html,p.learn_javascript,p.learn_java
from user1 u
join progressuser1 p on u.user_id = p.u_id
where u.city = 'hyderabad';





