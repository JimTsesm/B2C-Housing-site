select * from listings where id in(
SELECT idProperty FROM teddb.calendar where (date between '2017-09-07' and '2017-09-07') and (available="t") 
group by idProperty 
having count(*)=datediff('2017-09-07','2017-09-07')+1 
)