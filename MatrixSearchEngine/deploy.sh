#!/bin/bash

#backup database
mysqldump --no-defaults -u root -p mse > backup.sql

#recover database
source backup.sql