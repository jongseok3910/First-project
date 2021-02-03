DROP TABLE Board;
DROP TABLE Store;
DROP TABLE Jumun;
DROP TABLE MemberInfo;
DROP TABLE Card;
DROP TABLE Food;
DROP TABLE Category;

CREATE TABLE MemberInfo(
        member_no VARCHAR2(20) PRIMARY KEY,
		member_id VARCHAR2(10),
		member_password VARCHAR2(12),
		member_name VARCHAR2(20),
		member_phone VARCHAR2(13),
		member_address VARCHAR2(60),
		member_joinDate DATE DEFAULT sysdate,
        member_autoLogin VARCHAR2(1) DEFAULT 'F'
);

CREATE TABLE Card(
		card_no VARCHAR2(19) PRIMARY KEY,
		card_validity VARCHAR2(5),
		card_cvc number,
		card_password number,
        member_no VARCHAR2(20),
  FOREIGN KEY (member_no) REFERENCES MemberInfo (member_no)  
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
        jumun_request VARCHAR2(255),
		jumun_paymentType VARCHAR2(30),
		jumun_paymentTime DATE DEFAULT sysdate,
		member_no VARCHAR2(20),
        food_no number,
        store_no number,
  FOREIGN KEY (member_no) REFERENCES MemberInfo (member_no),
  FOREIGN KEY (food_no) REFERENCES Food (food_no),
  FOREIGN KEY (store_no) REFERENCES Store (store_no)
);

CREATE TABLE Store(
		store_no number PRIMARY KEY,
		store_name VARCHAR2(30),
		store_businessTime VARCHAR2(30),
		store_phone VARCHAR2(13),
		store_address VARCHAR2(50),
		store_deliveryPrice number,
		jumun_estimatedTime VARCHAR2(30) DEFAULT '30분',
		store_rating number
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