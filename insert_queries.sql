DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `age` mediumint default NULL,
  `email` varchar(255) default NULL,
  `first_name` varchar(255) default NULL,
  `last_name` varchar(255) default NULL,
  `password` varchar(255),
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (35,"elit.nulla@icloud.edu","Prescott","Sandra","BXP03ZCY8WI"),
  (80,"mi.duis.risus@outlook.edu","Kaseem","Channing","RPY15LYB5YW"),
  (39,"maecenas.libero.est@icloud.org","Belle","Pearl","EXW73EHV7UN"),
  (39,"lorem@yahoo.org","Nadine","Abdul","VCL66RSY7CO"),
  (75,"lacus.vestibulum@aol.com","Reece","Pascale","ETK63LWP4RF"),
  (33,"justo.nec@icloud.couk","Chase","Tyrone","CRQ14OGS0MY"),
  (49,"sed.eu.eros@icloud.ca","Samson","Yetta","UIA83BCP8LB"),
  (60,"in.felis@google.edu","Michael","Felix","FLT13ZQS1HL"),
  (5,"cum.sociis@protonmail.ca","Cameron","Molly","LGE72KLA2GS"),
  (59,"turpis@aol.couk","Arden","Maryam","XTE08KQJ1EG");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (25,"et.tristique@google.net","Amelia","Susan","WHY82TWM6ZH"),
  (29,"ornare@yahoo.net","Erich","Adrienne","CWG86EBW9VQ"),
  (13,"lorem.sit.amet@icloud.com","Burke","Wade","LXH63LCG5NW"),
  (35,"vel.nisl.quisque@outlook.com","Charity","Yasir","OCM28QFK5WB"),
  (45,"lectus.nullam@outlook.com","Martena","Hadassah","KPO24OKB3XN"),
  (64,"conubia.nostra@yahoo.org","Alden","Ruby","AEE84ZXX1VF"),
  (35,"aliquam.nisl@aol.edu","Murphy","Amaya","HFO67EAA8PL"),
  (44,"penatibus.et.magnis@google.org","Marshall","Holmes","TMK82GPN3MQ"),
  (5,"orci@hotmail.org","Kitra","Genevieve","BHD52UPH5OU"),
  (57,"nullam.vitae@hotmail.com","Lee","Amery","KZS97NSR4PU");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (53,"purus.accumsan@aol.couk","Joseph","Scarlet","JNU23ZRP1WQ"),
  (4,"tristique.ac@icloud.net","Inez","Vladimir","WIN82TYD8MK"),
  (61,"semper@outlook.com","Jack","Lysandra","NFM88FHP2ED"),
  (59,"ut@yahoo.net","Grant","Alika","DBT35HKI1EB"),
  (2,"penatibus.et@icloud.edu","Nigel","Dominique","VEL88NBQ5CY"),
  (75,"sed.turpis@outlook.edu","Dillon","Kennedy","BQO21DDZ6UY"),
  (47,"donec.tincidunt.donec@yahoo.org","Lydia","Jackson","VEK72HBH8JM"),
  (56,"dictum.placerat@outlook.ca","Gabriel","Allen","RUQ20YRV4AK"),
  (0,"orci.in.consequat@google.net","Holly","Anika","ENP44WVP0MJ"),
  (48,"aliquam@yahoo.com","Ignatius","Marshall","JGJ72UKB0FJ");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (44,"ut.sagittis.lobortis@yahoo.org","Ferdinand","Savannah","ELV18XJF7TO"),
  (41,"elit.pretium@google.ca","Dexter","Iliana","MLC81UNK6IA"),
  (19,"ac.urna@yahoo.ca","Gisela","Christian","FCB56MHP8HO"),
  (50,"vitae.semper@aol.couk","Cheryl","Abbot","EVC75FXC3HR"),
  (33,"gravida.sagittis.duis@icloud.net","Ainsley","Audrey","LKF96OWF1MH"),
  (43,"luctus.et.ultrices@aol.edu","Jerome","Drake","ONV89AVN4ZI"),
  (46,"ipsum.ac.mi@protonmail.org","Savannah","Chase","JSH54KTP0GX"),
  (38,"elit@outlook.com","Timothy","Rashad","URX37DGA6VX"),
  (46,"arcu.nunc.mauris@icloud.edu","Demetrius","Jonas","URW23ECU0WK"),
  (28,"eget@aol.edu","Mallory","Branden","WIK30IHE6WY");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (48,"risus@protonmail.org","Axel","Cheyenne","UHS60LMD5NV"),
  (4,"arcu.iaculis.enim@outlook.ca","Charde","Keiko","LBN15WJZ8TC"),
  (28,"orci@outlook.ca","Deanna","Quinlan","HUD87WVF9DU"),
  (21,"a@aol.com","Cruz","Nasim","GUG15JFD7EH"),
  (40,"a@yahoo.org","Patrick","Merrill","CHO19UOP0FC"),
  (73,"orci.sem@google.net","Roth","Prescott","MWT89JYB7WE"),
  (0,"sit.amet@google.ca","Yuli","Christian","TCN80ETR5XU"),
  (45,"vitae@protonmail.couk","Sopoline","Rogan","UDK77INS4YC"),
  (31,"semper.dui@protonmail.org","Sophia","Moana","RGP52OIV5FF"),
  (15,"eu.metus@icloud.edu","Chiquita","Ginger","NXV95GQZ6JO");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (46,"feugiat.metus@google.ca","Sybill","Kylee","AKU29MTD2NH"),
  (22,"enim.nec@yahoo.org","Buffy","Hashim","PYW65TWF7ER"),
  (32,"vitae.diam@outlook.couk","Zane","Josephine","JAH16ZQC3FS"),
  (9,"lorem.lorem@google.com","Ira","Athena","CJE16HKJ7EO"),
  (11,"vehicula@protonmail.org","Lewis","Tasha","AOP58OCT7VS"),
  (27,"erat.vivamus.nisi@hotmail.com","Colby","Jemima","HNF59KCC6OT"),
  (74,"tincidunt@hotmail.couk","Ulric","Amaya","VJN57AJP5RH"),
  (31,"velit@protonmail.couk","Craig","Nora","MOP35YJH7EK"),
  (56,"posuere@outlook.com","Austin","Lavinia","DNB62AAJ5XT"),
  (24,"mus@google.couk","Bevis","Michelle","GZS69CBC5QQ");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (70,"eros.turpis@aol.org","Katell","India","YFJ64OBU2NB"),
  (78,"pretium@google.com","Joseph","Rose","BMD84GJI2JY"),
  (22,"libero.et@google.net","Madeline","Byron","HFY28NHA1OX"),
  (3,"consectetuer.cursus@google.com","Chastity","Priscilla","EVT72XXV3MY"),
  (49,"nulla.in@outlook.edu","Melvin","Rina","SNE43VHV3SE"),
  (40,"cursus.nunc@yahoo.org","Fritz","Aladdin","QYW72YUQ9ES"),
  (64,"dapibus.gravida.aliquam@protonmail.ca","Levi","Kay","LKA37XYK1YB"),
  (79,"vestibulum.ut@hotmail.org","Avram","Tashya","ELC18QXX1CG"),
  (8,"non.lorem.vitae@google.couk","Serena","Branden","MOW07YYV7XY"),
  (65,"at.fringilla@google.net","Vivien","Louis","OWH02FHG7TJ");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (48,"tincidunt.dui@aol.edu","Wallace","Hoyt","USE31CRW2BG"),
  (19,"eu.ultrices@icloud.couk","Mannix","Xander","DUT51JMF8HG"),
  (9,"tincidunt.congue@protonmail.org","Mara","Damon","WFB48TPR8UL"),
  (11,"netus.et@icloud.edu","Amery","Jessamine","UFV42DSC7SE"),
  (33,"augue.scelerisque@icloud.ca","Graham","Laurel","KUF37FJC6NM"),
  (49,"velit.pellentesque@protonmail.org","Marny","Vincent","DQT47RYM8JR"),
  (49,"mauris.sit@aol.net","Ruby","Valentine","DLX33UIM6OV"),
  (4,"posuere@protonmail.org","Ira","Emmanuel","VNO62TXB7GK"),
  (36,"sit@outlook.org","Vielka","Kyra","HCM61UAC6UY"),
  (32,"accumsan@aol.ca","Tad","Kim","GVE67XXG2UO");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (22,"enim@aol.com","Dante","Debra","NDF85UNY2HB"),
  (55,"luctus@yahoo.ca","Rana","Ulric","XAT59QGG6UJ"),
  (66,"vitae.mauris.sit@google.edu","Remedios","Kelly","CTL80JIW9HN"),
  (55,"odio.aliquam@outlook.ca","Aimee","Thaddeus","KPN21YZH4UM"),
  (49,"ligula.aliquam@aol.org","Dexter","Ashton","AJL28TSW2GD"),
  (45,"sodales.mauris@outlook.com","Ann","Latifah","XRY79PXS7XI"),
  (2,"mauris.vestibulum@outlook.net","Madonna","Aspen","NTG77RSX0KK"),
  (16,"sem.egestas.blandit@protonmail.couk","Jana","Reed","KFJ72FIK6AI"),
  (15,"condimentum.donec.at@aol.net","Ursula","Graiden","IBI44ZSB6RQ"),
  (8,"donec.est@protonmail.ca","Karina","Cassady","IUX33WWX4BQ");
INSERT INTO `users` (`age`,`email`,`first_name`,`last_name`,`password`)
VALUES
  (32,"adipiscing.elit@protonmail.com","Slade","Thor","WGU55MYA1ZB"),
  (79,"erat.etiam@protonmail.ca","Guy","Rashad","CDY76BRY6BZ"),
  (7,"ac.feugiat@yahoo.org","Amena","Alyssa","TIB81FZB5UC"),
  (33,"nulla.interdum@outlook.com","Austin","Sylvester","EXM15GKH2BD"),
  (64,"risus.quis.diam@icloud.couk","Walter","Noel","JTH23ZYQ2AP"),
  (72,"amet.ante@google.ca","Chaney","Vera","DCG09NZR8PU"),
  (69,"semper.erat@yahoo.com","Herrod","Grant","ANT48UYU7WW"),
  (67,"posuere.enim@icloud.com","Miriam","Ria","RVQ64TUE3KS"),
  (22,"ipsum.phasellus.vitae@aol.org","Malik","Dean","YZA76TJL2EN"),
  (15,"turpis.aliquam@outlook.org","Felicia","Samson","YUY17YZX2GH");
