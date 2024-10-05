-- Tạo cơ sở dữ liệu quizlet
CREATE DATABASE quizlet;
USE quizlet;

-- Tạo bảng role để lưu trữ vai trò người dùng
CREATE TABLE role (
    role_id INT PRIMARY KEY IDENTITY(1,1),
    role_name VARCHAR(100) NOT NULL
);

-- Thêm dữ liệu mẫu vào bảng role
INSERT INTO role (role_name) VALUES
('admin'),
('questioner'),
('answerer');

-- Tạo bảng Users để lưu trữ thông tin người dùng
CREATE TABLE Users (
    user_id INT PRIMARY KEY IDENTITY(1,1),
    username NVARCHAR(255) NOT NULL,
    Password NVARCHAR(255) NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);

-- Thêm dữ liệu mẫu vào bảng Users
INSERT INTO Users (username, Password, role_id) VALUES 
('admin', '12345', 1),
('questioner1', '12345', 2),
('questioner2', '12345', 2),
('answerer1', '12345', 3),
('answerer2', '12345', 3);

-- Tạo bảng UserProfile để lưu trữ thông tin hồ sơ người dùng
CREATE TABLE UserProfile (
    profile_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT NOT NULL,
    first_name NVARCHAR(255),
    last_name NVARCHAR(255),
    email NVARCHAR(255),
    phone NVARCHAR(20),
    address NVARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Thêm dữ liệu mẫu vào bảng UserProfile
INSERT INTO UserProfile (user_id, first_name, last_name, email, phone, address) VALUES
(1, 'Admin', 'User', 'admin@example.com', '123456789', '123 Admin St.'),
(2, 'John', 'Doe', 'questioner1@example.com', '987654321', '456 Questioner Ave.'),
(3, 'Jane', 'Smith', 'questioner2@example.com', '555666777', '789 Answerer Rd.');

-- Tạo bảng topic để lưu trữ thông tin chủ đề
CREATE TABLE topic (
    topic_id INT PRIMARY KEY IDENTITY(1,1),
    topic_name VARCHAR(100) NOT NULL
);

-- Thêm dữ liệu mẫu vào bảng topic
INSERT INTO topic (topic_name) VALUES
(N'Mathematics'),
(N'Geography'),
(N'Science'),
(N'Music'),
(N'Sports'),
(N'Others');

-- Tạo bảng quiz để lưu trữ thông tin về các quiz
CREATE TABLE quiz (
    quiz_id INT PRIMARY KEY IDENTITY(1,1),
    quiz_name VARCHAR(100) NOT NULL,
    topic_id INT,
    questioner_id INT,
    is_public BIT NOT NULL,
    enrol_key NVARCHAR(255) NULL,
    FOREIGN KEY (topic_id) REFERENCES topic(topic_id),
    FOREIGN KEY (questioner_id) REFERENCES Users(user_id)
);

-- Thêm dữ liệu mẫu vào bảng quiz
INSERT INTO quiz (quiz_name, topic_id, questioner_id, is_public, enrol_key) VALUES
('happy with basic math', 1, 2, 0, 'a12'),
('capitals in the world', 2, 2, 1, NULL),
('science quiz chill', 5, 2, 0, '5b6'),
('Vietnamese music', 4, 2, 1, NULL),
('ai thong minh hoc sinh lop 5', 1, 3, 1, NULL);

-- Tạo bảng question để lưu trữ thông tin câu hỏi
CREATE TABLE question (
    question_id INT PRIMARY KEY IDENTITY(1,1),
    question_content VARCHAR(100) NOT NULL,
    question_key BIT NOT NULL,
    quiz_id INT,
    FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id)
);

-- Thêm dữ liệu mẫu vào bảng question
INSERT INTO question (question_content, question_key, quiz_id) VALUES
('2 + 2 = 5', 0, 1),
('2 + 2 = 4', 1, 1),
('1 + 1 = 3', 0, 1),
('1 + 1 = 2', 1, 1),
('London is the capital of France', 0, 2),
('London is the capital of England', 1, 2),
('Pari is the capital of France', 1, 2),
('Hanoi is the capital of Viet Nam', 1, 2),
('h20 is a dangerous substance', 0, 3),
('we can eat axit', 0, 3),
('h20 is a dangerous substance', 0, 3),
('h20 is a dangerous substance', 0, 3),
('Son Tung MTP is dinh cua chop', 1, 4),
('Jack is 5M', 1, 4),
('Em khong la nang tho', 0, 4),
('The gioi nay lam ton thuong em bao nhieu, anh se yeu em nhieu gap doi nhu vay', 1, 4),
('1 = 1', 1, 5),
('1 > 1', 0, 5),
('1 < 1', 0, 5),
('1 != 1', 0, 5);

-- Tạo bảng quiz_answerer để lưu trữ thông tin người tham gia quiz và điểm số của họ
CREATE TABLE quiz_answerer (
    id INT PRIMARY KEY IDENTITY(1,1),
    quiz_id INT,
    answerer_id INT,
    mark DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id),
    FOREIGN KEY (answerer_id) REFERENCES Users(user_id)
);

-- Thêm dữ liệu mẫu vào bảng quiz_answerer
INSERT INTO quiz_answerer (quiz_id, answerer_id, mark) VALUES
(1, 4, 50),
(1, 5, 75),
(1, 4, 75),
(2, 4, 100),
(5, 4, 100);
