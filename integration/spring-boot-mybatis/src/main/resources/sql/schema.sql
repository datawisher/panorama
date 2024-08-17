CREATE TABLE `t_car`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `car_num`      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `brand`        varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `guide_price`  decimal(10, 2)                          DEFAULT NULL,
    `produce_time` datetime                                DEFAULT NULL,
    `car_type`     int(2)                                  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (1, '6', 'benz', 50.00, '2024-08-01 20:19:40', 1);
INSERT INTO `t_car` (`id`, `car_num`, `brand`, `guide_price`, `produce_time`, `car_type`) VALUES (2, '15', 'BMW', 38.45, '2024-08-11 12:18:15', 2);


CREATE TABLE `t_car_type`
(
    `id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO `t_car_type` (`id`, `name`) VALUES (1, '燃油');
INSERT INTO `t_car_type` (`id`, `name`) VALUES (2, '新能源');
