--DROP TABLE users IF EXISTS;

CREATE TABLE purchase_order (
  po_nbr  VARCHAR(30) PRIMARY KEY,
  status  VARCHAR(30),
);
