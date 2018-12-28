SELECT 
f_item.*,
f_delivery_method.name,
f_delivery_method.price,
f_item_status.name,
category.name,
f_board.board_comment
FROM
f_item INNER JOIN f_delivery_method ON
f_item.delivery_method_id=f_delivery_method.id
INNER JOIN f_item_status ON
f_item.status=f_item_status.id
INNER JOIN f_board ON
f_item.id=f_board.item_id
INNER JOIN category ON
f_item.category_id=category_id;
