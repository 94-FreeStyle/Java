#!/bin/bash

#backup database
mysqldump --no-defaults -u root -p mse > backup.sql

#recover database
source backup.sql

#load index
LOAD DATA LOCAL INFILE 'index.csv' INTO TABLE tbl_name 
FIELDS TERMINATED BY ',' 
OPTIONALLY ENCLOSED BY ""
LINES TERMINATED BY '\n'