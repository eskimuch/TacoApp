delete from Ingredient;
delete from Taco;
delete from Taco_Order;
delete from Taco_To_Ingredient;
delete from Order_To_Taco;
delete from User;

insert into Ingredient (id, name, ingredient_type) 
                values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, ingredient_type) 
                values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, ingredient_type) 
                values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, ingredient_type) 
                values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, ingredient_type) 
                values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, ingredient_type) 
                values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, ingredient_type) 
                values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, ingredient_type) 
                values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, ingredient_type) 
                values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, ingredient_type) 
                values ('SRCR', 'Sour Cream', 'SAUCE');
                
insert into User (id, city, fullname, password, phone_number, state, street, username, zip)
				values (1,'Wroclaw','Dorota Lubis', 'a9820579d9363c03bc1cb2fb3f003ad6855f9bcbda029ea48c6a7c9254f59ace962486ce7a947240','123123123','Dolnoslaskie', 'Legnicka','lubis','50-500');