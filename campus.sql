CREATE DATABASE campusconnect;
USE campusconnect;

-- USERS TABLE (Admin + Student login)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(200) NOT NULL,
    role ENUM('admin', 'student') NOT NULL
);

-- STUDENT PROFILE TABLE
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    course VARCHAR(100),
    year INT,
    section VARCHAR(10),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- NOTICE TABLE (created by admin)
CREATE TABLE notices (
    notice_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- REQUEST TABLE (created by student)
CREATE TABLE requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    type VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    status ENUM('Pending','Approved','Rejected') DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert a default admin
INSERT INTO users (name, email, password, role)
VALUES ('Admin User', 'admin@campus.com', 'admin123', 'admin');
