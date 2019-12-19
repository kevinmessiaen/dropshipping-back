INSERT INTO user (username, password, is_admin) VALUES
    ('user', '$2y$10$cM2TiO5CWtYJnE5tulwdiOEsjIAW0vqhBmSzoo/uwVg7dv7VAm.6K', false),
    ('admin', '$2y$10$5DjypPsecR3zbY1WdnupquE/svE/HHWq8TfpfZRgd/T60JzhoDJ2q', true);

INSERT INTO basket (id, user_id) VALUES
    (RANDOM_UUID(), 1),
    (RANDOM_UUID(), 2);

INSERT INTO category (name, desc, path, parent_id) VALUES
    ('Café', 'Les meilleurs cafés du Vietnam!', 'cafe', null),
    ('Arabica', 'Nos cafés arabica!', 'cafe-arabica', 1),
    ('Robusta', 'Nos cafés robusta!', 'cafe-robusta', 1),
    ('Culi', 'Nos cafés culi!', 'cafe-culi', 1);

INSERT INTO shipping_method(name, min_work_days, max_work_days, fees, min_order, free_min_order) VALUES
    ('Standard', 3, 5, 4.99, 0, 25),
    ('1 jour ouvré', 1, null, 9.99, 0, null);

INSERT INTO product (name, desc, path, price, category_id) VALUES
    ('Arabica 100% (250g)', '250 grammes de café Arabica cultivé dans la région de Da Lat au Vietnam', 'cafe-arabica-250-g', 4.7, 2),
    ('Arabica 100% (500g)', '250 grammes de café Arabica cultivé dans la région de Da Lat au Vietnam ', 'cafe-arabica-500-g', 7.8, 2),
    ('Arabica 100% (1kg)', 'Un kilo de café Arabica cultivé dans la région de Da Lat au Vietnam ', 'cafe-arabica-1-kg', 15.6, 2),
    ('Robusta 100% (250g)', '250 grammes de café Robusta cultivé au Vietnam', 'cafe-robusta-250-g', 3.9, 3),
    ('Robusta 100% (500g)', '250 grammes de café Robusta cultivé au Vietnam ', 'cafe-robusta-500-g', 6.6, 3),
    ('Robusta 100% (1kg)', 'Un kilo de café Robusta cultivé dans au Vietnam ', 'cafe-robusta-1-kg', 12.9, 3),
    ('Culi (250g)', '250 grammes de café Culi cultivé au Vietnam ', 'cafe-culi-250-g', 3.9, 4),
    ('Culi (500g)', '500 grammes de café Culi cultivé au Vietnam ', 'cafe-culi-500-g', 6.6, 4),
    ('Culi (1kg)', 'Un kilo de café Culi cultivé au Vietnam ', 'cafe-culi-1-kg', 12.9, 4);
