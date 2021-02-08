
--CATEGORY
insert into category values(10,'샌드위치');
insert into category values(20,'랩');
insert into category values(30,'찹샐러드');
insert into category values(40,'사이드메뉴');
insert into category values(50,'쿠키,칩');
insert into category values(60,'음료');

--FOOD
INSERT INTO FOOD VALUES (101,'햄',4700,10);
INSERT INTO FOOD VALUES (102,'참치',4800,10);
INSERT INTO FOOD VALUES (103,'에그마요',4300,10);
INSERT INTO FOOD VALUES (104,'베지',3900,10);
INSERT INTO FOOD VALUES (105,'비엘티',5200,10);
INSERT INTO FOOD VALUES (106,'이탈리안 비엠티',5200,10);
INSERT INTO FOOD VALUES (107,'미트볼',5200,10);
INSERT INTO FOOD VALUES (108,'터키',5200,10);
INSERT INTO FOOD VALUES (109,'스파이시 이탈리안',5700,10);
INSERT INTO FOOD VALUES (110,'치킨 데리야끼',5700,10);
INSERT INTO FOOD VALUES (111,'써브웨이 클럽',5700,10);
INSERT INTO FOOD VALUES (112,'로스트치킨',5900,10);
INSERT INTO FOOD VALUES (113,'써브웨이 멜트',5900,10);
INSERT INTO FOOD VALUES (114,'스테이크 앤 치즈',6500,10);
INSERT INTO FOOD VALUES (115,'터키베이컨 아보카도',6500,10);
INSERT INTO FOOD VALUES (116,'풀드포크 바비큐',5900,10);
INSERT INTO FOOD VALUES (117,'로티세리 바비큐 치킨',5900,10);
INSERT INTO FOOD VALUES (118,'쉬림프',5700,10);
INSERT INTO FOOD VALUES (119,'에그마요 베이컨',5200,10);
INSERT INTO FOOD VALUES (120,'K-바비큐',6000,10);

INSERT INTO FOOD VALUES(201,'스테이크앤치즈 아보카도 랩',5700,20);
INSERT INTO FOOD VALUES(202,'쉬림프 에그마요 랩',5000,20);
INSERT INTO FOOD VALUES(203,'치킨 베이컨 미니랩',2900,20);
INSERT INTO FOOD VALUES(204,'이탈리안 미니랩',3400,20);

insert into Food VALUES(301,'샐러드클럽',5000,30);
insert into Food VALUES(302,'햄샐러드',5700,30);
insert into Food VALUES(303,'참치샐러드',5700,30);
insert into Food VALUES(304,'치킨샐러드',5700,30);
insert into Food VALUES(305,'미트볼샐러드',5700,30);
insert into Food VALUES(306,'에그마요샐러드',5400,30);
insert into Food VALUES(307,'비엘티샐러드',7600,30);
insert into Food VALUES(308,'바베큐샐러드',5600,30);
insert into Food VALUES(309,'폴드포크샐러드',6700,30);


INSERT INTO FOOD VALUES(401,'해쉬브라운',1200,40);
INSERT INTO FOOD VALUES(402,'웨지 포테이토',1500,40);
INSERT INTO FOOD VALUES(403,'Cheesy 웨지 포테이토',2000,40);
INSERT INTO FOOD VALUES(404,'Bacon Cheesy 웨지 포테이토',2300,40);

INSERT INTO FOOD VALUES(501,'초코칩 쿠키',1000,50);
INSERT INTO FOOD VALUES(502,'더블 초코칩 쿠키',1000,50);
INSERT INTO FOOD VALUES(503,'오트밀 레이즌 쿠키',1000,50);
INSERT INTO FOOD VALUES(504,'라즈베리 치즈케잌 쿠키',1000,50);
INSERT INTO FOOD VALUES(505,'화이트 초코 마카다미아 쿠키',1000,50);
INSERT INTO FOOD VALUES(506,'칩',1000,50);

INSERT INTO FOOD VALUES(601,'코카콜라',1800,60);
INSERT INTO FOOD VALUES(602,'스프라이트',1800,60);
INSERT INTO FOOD VALUES(603,'닥터페퍼',1800,60);
INSERT INTO FOOD VALUES(604,'오렌지주스',2500,60);
INSERT INTO FOOD VALUES(605,'생수',1000,60);

--CARD --회원번호 수정
insert into CARD VALUES ('1465-7645-8954-1525','21/03',876,111111,202102071);
insert into CARD VALUES ('1234-4476-8466-7551','21/03',456,222222,202102072);
insert into CARD VALUES ('4460-7985-4315-2249','21/07',231,333333,202102073);
insert into CARD VALUES ('4685-0046-4764-8858','24/01',573,444444,202102074);
--insert into CARD VALUES ('6486-5774-1331-6456','23/06',195,555555,202102065);


--MEMBERINFO
DELETE FROM MEMBERINFO;
DROP SEQUENCE MEMBER_SEQ1;
CREATE SEQUENCE MEMBER_SEQ1
    increment by 1
    start with 1
    maxvalue 99999999999
    nocycle
    nocache;
INSERT INTO MEMBERINFO VALUES(to_char(sysdate,'YYYYMMDD')||member_SEQ1.NEXTVAL,'ID1','1111','황재호','111-1111-1111','XX시 XX구 XX동 XX빌라 101호','21-02-03');
INSERT INTO MEMBERINFO VALUES(to_char(sysdate,'YYYYMMDD')||member_seq1.NEXTVAL,'ID2','1111','박종석','222-2222-2222','XX시 XX구 XX동 XX빌라 201호','21-02-03');
INSERT INTO MEMBERINFO VALUES(to_char(sysdate,'YYYYMMDD')||member_seq1.NEXTVAL,'ID3','1111','박종은','333-3333-3333','XX시 XX구 XX동 XX빌라 301호','21-02-03');
INSERT INTO MEMBERINFO VALUES(to_char(sysdate,'YYYYMMDD')||member_seq1.NEXTVAL,'ID4','1111','이현민','444-4444-4444','XX시 XX구 XX동 XX빌라 401호','21-02-03');
INSERT INTO MEMBERINFO VALUES(to_char(sysdate,'YYYYMMDD')||member_seq1.NEXTVAL,'ID5','1111','최혜조','555-5555-5555','XX시 XX구 XX동 XX빌라 501호','21-02-03');

--Store
desc store;
--1번 학동점 정보입력
insert into STORE values(1,'학동점','00:00~23:59','02-515-1014','서울 강남구 학동로 171',3000,'15분~20분',null);
--2번 수서점 정보입력
insert into STORE values(2,'수서점','08:00~23:00','02-445-1636','서울 강남구 밤고개로 1길 10 B1',2000,'10분~20분',null);
--3번 봉은사점 정보입력
insert into STORE values(3,'봉은사점','08:00~22:00','02-545-5729','서울시 강남구 봉은사로 627',2000,'10분~20분',null);
--4번 강남역 정보입력
insert into STORE values(4,'강남역','08:00~22:00','02-557-4727','서울 강남구 강남대로96길 12',3000,'15분~20분',null);
--5번 선정릉점 정보입력
insert into STORE values(5,'선정릉점','08:00~23:00','02-555-9389','서울 강남구 봉은사로 328',2000,'10분~20분',null);
--6번 강남구청점 정보입력
insert into STORE values(6,'강남구청점','08:00~22:00','02-545-0806','서울 강남구 선릉로 653',2000,'10분~20분',null);
--7번 압구정점 정보입력
insert into STORE values(7,'압구정점','08:00~22:00','02-548-1014','서울 강남구 압구정로 28길 13',3000,'15분~20분',null);
--8번 언주점 정보입력
insert into STORE values(8,'언주점','08:00~23:00','02-557-8805','서울 강남구 봉은사로 206대명빌딩',2000,'10분~20분',null);
--9번 삼성점 정보입력
insert into STORE values(9,'삼성점','08:00~23:00','02-2051-2008','서울 강남구 삼성로 520',2000,'10분~20분',null);
--10번 신사점 정보입력
insert into STORE values(10,'신사점','08:00~22:00','02-546-2007','서울 강남구 도산대로 124 대영빌딩',3000,'15분~20분',null);
commit;

--BOARD
DELETE FROM BOARD;
DROP SEQUENCE BOARD_SEQ1;
CREATE SEQUENCE BOARD_SEQ1
    increment by 1
    start with 1
    maxvalue 99999999999
    nocycle
    nocache;
INSERT INTO BOARD VALUES (BOARD_SEQ1.NEXTVAL,'2021-02-01','잘먹었습니다.',5,1);
INSERT INTO BOARD VALUES (BOARD_SEQ1.NEXTVAL,'2021-02-02','저는 별로였어요.',1,1);
INSERT INTO BOARD VALUES (BOARD_SEQ1.NEXTVAL,'2021-02-01','배달이 빨리왔어요.',5,1);
INSERT INTO BOARD VALUES (BOARD_SEQ1.NEXTVAL,'2021-02-02','항상 여기서 시켜먹어요.',5,1);
INSERT INTO BOARD VALUES (BOARD_SEQ1.NEXTVAL,'2021-02-03','너무 맛있어요.',5,1);


--JUMUN
DELETE FROM JUNUM;
DROP SEQUENCE JUMUN_SEQ1;
CREATE SEQUENCE JUMUN_SEQ1
    increment by 1
    start with 1
    maxvalue 99999999999
    nocycle
    nocache;

COMMIT;