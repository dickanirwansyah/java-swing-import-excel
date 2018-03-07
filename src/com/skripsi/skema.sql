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


create table table_proses(
    idproses int not null auto_increment,
    tanggal_proses date not null,

    CONSTRAINT pk_table_proses_idproses PRIMARY KEY (idproses)
);

create table weather(
    
    idweather int not null auto_increment,
    outlook varchar(255) not null,
    temprature varchar(255) not null,
    humidity varchar(255) not null,
    windy varchar(255) not null,
    play varchar(255) not null,

    CONSTRAINT pk_weathe_idweather PRIMARY KEY (idweather)
);

create table weathers(
    
    idweather int not null auto_increment,
    outlook varchar(255) not null,
    temprature varchar(255) not null,
    humidity varchar(255) not null,
    windy varchar(255) not null,
    

    CONSTRAINT pk_weathe_idweather PRIMARY KEY (idweather)
);

create table table_pengajuan(
    idanalisis varchar(255) not null unique,
    idproses int not null,
    penghasilan_ortu varchar(255) not null,
    jarak varchar(255) not null,
    kendaraan varchar(255) not null,
    nilai_rapot varchar(255) not null,
    jumlah_saudara varchar(255) not null,
    mendapatkan_beasiswa varchar(255) not null,
    keputusan varchar(255) not null,

    CONSTRAINT pk_table_pengajuan PRIMARY KEY (idanalisis),
    CONSTRAINT fk_table_pengajuan FOREIGN KEY (idproses)
    REFERENCES table_proses (idproses)
);