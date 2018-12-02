select *
from    (select * from message
         order by parent_message_id, idMessage) message_sorted,
        (select @pv := 17) initialisation
where   find_in_set(parent_message_id, @pv) > 0
and     @pv := concat(@pv, ',', idMessage)
having count(*)>0;