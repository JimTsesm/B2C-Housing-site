load data local infile 'C:/Users/turbox/Desktop/calendar_small.csv'
into table calendar
fields 
    terminated by ','
    enclosed by '"'
lines terminated by '\n'
(idProperty,@date,available,@price)
set
price=nullif(@price,''),
date=STR_TO_DATE(@date, '%m/%d/%Y');