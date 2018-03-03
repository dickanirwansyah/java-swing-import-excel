/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dickajava
 * Created: Mar 3, 2018
 */

create table product(
    idproduct varchar(255) not null unique,
    name varchar(255) not null,
    quantity int not null,
    constraint pk_product_idproduct PRIMARY KEY (idproduct)
);