DROP TABLE Board;
DROP TABLE Store;
DROP TABLE Jumun;
DROP TABLE MemberInfo;
DROP TABLE Card;
DROP TABLE Food;
DROP TABLE MemberJoin;
DROP TABLE Category;

CREATE TABLE MemberJoin(
		member_id VARCHAR2(10) PRIMARY KEY,
		member_password VARCHAR2(12),
		member_name VARCHAR2(20),
		member_phone VARCHAR2(13),
		member_address VHRCHAR2(255),
		member_joinDate DATE DEFAULT sysdate
);

CREATE TABLE Card(
		card_no VARCHAR2(19) PRIMARY KEY,
		card_validity VARCHAR2(10),
		card_cvc number,
		card_password number
);

CREATE TABLE MemberInfo(
		member_no VARCHAR2(255) PRIMARY KEY,
		member_id VARCHAR2(10),
		card_no VARCHAR2(19),
		member_autoLogin VARCHAR2(1) DEFAULT 'F',
  FOREIGN KEY (member_id) REFERENCES MemberJoin (member_id),
  FOREIGN KEY (card_no) REFERENCES Card (card_no)
);

CREATE TABLE Category(
		category_no number PRIMARY KEY,
        category_name varchar2(30)
);

CREATE TABLE Food(
		food_no number PRIMARY KEY,
		food_name VARCHAR2(255),
		food_price number,
        category_no number,
  FOREIGN KEY (category_no) REFERENCES Category (category_no)
);

CREATE TABLE Jumun(
		jumun_no number PRIMARY KEY,
		jumun_quantity number,
		jumun_sum number,
		jumun_payment VARCHAR2(10),
		jumun_request VARCHAR2(255),
		jumun_estimatedTime VARCHAR2(30),
		card_no VARCHAR2(19),
		member_no number,
		food_no number,
  FOREIGN KEY (card_no) REFERENCES Card (card_no),
  FOREIGN KEY (member_no) REFERENCES MemberInfo (member_no),
  FOREIGN KEY (food_no) REFERENCES Food (food_no)
);

CREATE TABLE Store(
		store_no number PRIMARY KEY,
		store_name VARCHAR2(30),
		store_businessTime VARCHAR2(30),
		store_phone VARCHAR2(13),
		store_address VARCHAR2(50),
		store_deliveryPrice number,
		jumun_estimatedTime VARCHAR2(30) DEFAULT '30분',
		store_rating number,
		category_no number,
		jumun_no number,
  FOREIGN KEY (category_no) REFERENCES Category (category_no),
  FOREIGN KEY (jumun_no) REFERENCES Jumun (jumun_no)
);

CREATE TABLE Board(
		board_no number PRIMARY KEY,
		board_date DATE DEFAULT sysdate,
		board_content VARCHAR2(255),
		board_rating number,
		store_no number,
  FOREIGN KEY (store_no) REFERENCES Store (store_no)
);
commit;