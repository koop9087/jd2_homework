--вывести список получателей платежей, и сумму платежей по каждому из них
select sum(value) as Потрачено, name from expenses, receivers rs where receiver=rs.id group by receiver;
--вывести сумму платажей за тот день, когда был наибольший платеж
select paydate, sum(value) from expenses where paydate=(select paydate from expenses where value=(select max(value) from expenses));
--вывести наибольший платеж за тот день когда сумма платажей была наибольшей
select paydate, max(value) from expenses where paydate=(select paydate from expenses where value=(select max(value) from expenses));
