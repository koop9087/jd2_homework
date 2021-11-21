create database if not exists task9;
create table if not exists task9.receivers(
id int auto_increment primary key,
name varchar(255) not null
);
create table if not exists task9.expenses(
id int (10) auto_increment primary key,
paydate date not null,
receiver int (12) not null,
value dec (8,3) not null,
constraint receiver foreign key (receiver) references receivers(id)
);
insert into task9.receivers (name) values ("prostor");
insert into task9.receivers (name) values ("walmart");
insert into task9.receivers (name) values ("grin");
insert into task9.expenses (id,paydate,receiver,value)
values (1, '10.11.2012',1,78.40);
insert into task9.expenses (id,paydate,receiver,value)
values (2, '2013.12.08',2,99.82);
insert into task9.expenses (paydate,receiver,value)
values ('2019.05.01',3,81.21);
insert into task9.expenses (paydate,receiver,value)
values ('2019.05.01',3,8612.91);
select sum(value) as Потрачено, name from task9.expenses, task9.receivers rs where receiver=rs.id group by receiver;
select paydate, sum(value) from task9.expenses where paydate=(select paydate from task9.expenses where value=(select max(value) from task9.expenses));
select paydate, max(value) from task9.expenses where paydate=(select paydate from task9.expenses where value=(select max(value) from task9.expenses));
