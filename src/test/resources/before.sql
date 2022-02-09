delete from product;
delete from list;

insert into product(id, name, description, kcal) values
(1, 'Item1', 'Best Item1', '333'),
(2, 'Item2', 'Best Item2', '444'),
(3, 'Item3', 'Best Item3', '555');

insert into list(id, name) values
(4, 'List1'),
(5, 'List2');

alter sequence hibernate_sequence restart with 10;