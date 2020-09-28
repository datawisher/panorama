DROP TABLE IF EXISTS person;
CREATE TABLE person (
  id int8 NOT NULL,
  name varchar(255) COLLATE pg_catalog.default,
  age int4
)
;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO person VALUES (1, 'jim', 18);
INSERT INTO person VALUES (2, 'jim', 18);
INSERT INTO person VALUES (3, 'jim', 18);
INSERT INTO person VALUES (4, 'jim', 18);
INSERT INTO person VALUES (10, 'han静', 55);
INSERT INTO person VALUES (1307222541518725121, '许巍', 55);
INSERT INTO person VALUES (1307222771861512194, '虎鲸', 5);
INSERT INTO person VALUES (1307225358929125378, '狗子', 12);
INSERT INTO person VALUES (1307225498989518850, '琪琪', NULL);
INSERT INTO person VALUES (1307229373360418817, '喵喵', 21);

-- ----------------------------
-- Primary Key structure for table person
-- ----------------------------
ALTER TABLE person ADD CONSTRAINT user_pkey PRIMARY KEY (id);

INSERT INTO person VALUES (111, 'itv', 18);
