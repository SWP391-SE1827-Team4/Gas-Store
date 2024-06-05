USE master;
GO
DROP DATABASE IF EXISTS GasStore1;
GO
CREATE DATABASE GasStore1;
GO
USE GasStore1
GO

-- Table Managers (kết hợp Staff và Admin)
CREATE TABLE Managers (
    Manager_ID INT PRIMARY KEY IDENTITY(1,1),
    Manager_Name NVARCHAR(50) NOT NULL,
    Manager_Email NVARCHAR(100) NOT NULL UNIQUE,
    Manager_Password VARCHAR(50) NOT NULL, 
    Manager_Address NVARCHAR(MAX),
    Manager_PhoneNum NVARCHAR(20),
    Manager_Gender NVARCHAR(10),
    IsAdmin BIT NOT NULL,
    IsStaff BIT NOT NULL
);

-- Table Users
CREATE TABLE Users (
    User_ID INT PRIMARY KEY IDENTITY(1,1),
    User_Name NVARCHAR(50) NOT NULL,
    User_Password VARCHAR(50) NOT NULL,
    User_Email NVARCHAR(100) NOT NULL UNIQUE,
    User_PhoneNum NVARCHAR(20),
    User_Address NVARCHAR(MAX),
    User_Gender NVARCHAR(10),
    User_Image NVARCHAR(MAX),
    User_Type NVARCHAR(50) DEFAULT 'Guest'
);

-- Table Categories
CREATE TABLE Categories (
    Category_ID INT PRIMARY KEY IDENTITY(1,1),
    Category_Name NVARCHAR(50) NOT NULL,
    Description NVARCHAR(MAX)
);

-- Table Products
CREATE TABLE Products (
    Product_ID INT PRIMARY KEY IDENTITY(1,1),
    Category_ID INT,
    Product_Name NVARCHAR(50) NOT NULL,
    Product_Quantity INT CHECK (Product_Quantity >= 0),
    Product_Price FLOAT,
    Product_Description NVARCHAR(MAX),
    FOREIGN KEY (Category_ID) REFERENCES Categories(Category_ID)
);

-- Table Product_Details
CREATE TABLE Product_Details (
    Product_Detail_ID INT PRIMARY KEY IDENTITY(1,1),
    Product_ID INT,
    Serial_Number NVARCHAR(100) NOT NULL,
    Warranty_Start_Date DATETIME,
    Warranty_End_Date DATETIME,
    Warranty_Description NVARCHAR(255),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table Orders
CREATE TABLE Orders (
    Order_ID INT PRIMARY KEY IDENTITY(1,1),
    User_ID INT,
    Product_ID INT,
    Order_Status NVARCHAR(50),
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table Order_Details
CREATE TABLE Order_Details (
    OrderDetail_ID INT PRIMARY KEY IDENTITY(1,1),
    Order_ID INT,
    Product_ID INT,
    Order_Quantity INT CHECK (Order_Quantity > 0),
    OrderDetail_Status NVARCHAR(50),
    Total_Amount_Paid FLOAT,
    Payment_Completion_Date DATETIME,
    Payment_Method NVARCHAR(50),
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table Discounts
CREATE TABLE Discounts (
    Discount_ID INT PRIMARY KEY IDENTITY(1,1),
    Discount_Name NVARCHAR(50),
    Discount_Code NVARCHAR(50),
    Discount_Percent FLOAT CHECK (Discount_Percent >= 0 AND Discount_Percent <= 100),
    Discount_Description NVARCHAR(255),
    Discount_Start DATETIME,
    Discount_End DATETIME
);

-- Table Order_Discounts (for many-to-many relationship)
CREATE TABLE Order_Discounts (
    Order_ID INT,
    Discount_ID INT,
    PRIMARY KEY (Order_ID, Discount_ID),
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
    FOREIGN KEY (Discount_ID) REFERENCES Discounts(Discount_ID)
);

-- Table UserWarranty (updated to use Product_Details and Order_Details)
CREATE TABLE UserWarranty (
    UserWarranty_ID INT PRIMARY KEY IDENTITY(1,1),
    OrderDetail_ID INT,
    Product_Detail_ID INT,
    Image NVARCHAR(MAX),
    Description NVARCHAR(MAX),
    Maintenance_Status NVARCHAR(50),
    Maintenance_StartDate DATETIME,
    Maintenance_EndDate DATETIME,
    Maintenance_Fee FLOAT,
    Manager_ID INT,
    FOREIGN KEY (OrderDetail_ID) REFERENCES Order_Details(OrderDetail_ID),
    FOREIGN KEY (Product_Detail_ID) REFERENCES Product_Details(Product_Detail_ID),
    FOREIGN KEY (Manager_ID) REFERENCES Managers(Manager_ID)
);

-- Table Shipping
CREATE TABLE Shipping (
    Shipping_ID INT PRIMARY KEY IDENTITY(1,1),
    Manager_ID INT,
    OrderDetail_ID INT,
    Shipping_Status NVARCHAR(50),
    Shipping_Cost FLOAT,
    Shipping_Date DATETIME,
    FOREIGN KEY (Manager_ID) REFERENCES Managers(Manager_ID),
    FOREIGN KEY (OrderDetail_ID) REFERENCES Order_Details(OrderDetail_ID)
);

-- Table Image_Product
CREATE TABLE Image_Product (
    Image_ID INT PRIMARY KEY IDENTITY(1,1),
    Product_ID INT,
    Image_URL NVARCHAR(MAX),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table Ads_Notifications (updated to include User_ID for linking with Users)
CREATE TABLE Ads_Notifications (
    Ads_ID INT PRIMARY KEY IDENTITY(1,1),
    Ads_Title NVARCHAR(50),
    Ads_Content NVARCHAR(MAX),
    Target_User_Type NVARCHAR(50) CHECK (Target_User_Type IN ('Guest', 'Customer_InUse', 'Customer_Used')),
    User_ID INT,
    Sent_Date DATETIME DEFAULT GETDATE(),
    Sent_Via NVARCHAR(50) CHECK (Sent_Via IN ('Email', 'SMS')),
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID)
);

-- Table User_Ads_Notifications (for many-to-many relationship between Users and Ads_Notifications)
CREATE TABLE User_Ads_Notifications (
    User_Ads_ID INT PRIMARY KEY IDENTITY(1,1),
    Ads_ID INT,
    Sent_Date DATETIME DEFAULT GETDATE(),
    Sent_Via NVARCHAR(50) CHECK (Sent_Via IN ('Email', 'SMS')),
    FOREIGN KEY (Ads_ID) REFERENCES Ads_Notifications(Ads_ID)
);

-- Table StoreInfo for storing general store information
CREATE TABLE StoreInfo (
    StoreInfo_ID INT PRIMARY KEY IDENTITY(1,1),
    Store_Name NVARCHAR(50),
    Store_Address NVARCHAR(MAX),
    Store_Phone NVARCHAR(20),
    Store_Email NVARCHAR(100),
    Store_Website NVARCHAR(255),
    Store_Fanpage NVARCHAR(255)
);

-- Table Web_Images
CREATE TABLE Web_Images (
    Image_ID INT PRIMARY KEY IDENTITY(1,1),
    Image_Name NVARCHAR(50) NOT NULL,
    Image_Type NVARCHAR(50), -- Loại hình ảnh, ví dụ: Banner, Ads, ...
    Image_Description NVARCHAR(MAX),
    Image_URL NVARCHAR(MAX) NOT NULL
);

-- Lệnh JOIN Users và Managers để kiểm tra đăng nhập
SELECT 
    U.User_ID AS ID,
    U.User_Email AS Email,
    U.User_Password AS Password,
    U.User_Type AS Role
FROM Users U
UNION ALL
SELECT 
    M.Manager_ID AS ID,
    M.Manager_Email AS Email,
    M.Manager_Password AS Password,
    CASE 
        WHEN M.IsAdmin = 1 THEN 'Admin'
        WHEN M.IsStaff = 1 THEN 'Staff'
        ELSE 'Unknown'
    END AS Role
FROM Managers M;

-- Lệnh cập nhật User_Type khi người dùng mua ít nhất một sản phẩm
UPDATE Users
SET User_Type = 'Customer_InUse'
WHERE User_ID IN (
    SELECT DISTINCT User_ID
    FROM Orders O
    JOIN Order_Details OD ON O.Order_ID = OD.Order_ID
    WHERE OD.Order_Quantity > 0 AND OD.Payment_Completion_Date IS NOT NULL
);

-- Lệnh cập nhật User_Type cho Customer_Used nếu không có đơn hàng mới trong vòng 1 năm
UPDATE Users
SET User_Type = 'Customer_Used'
WHERE User_Type = 'Customer_InUse' AND User_ID NOT IN (
    SELECT DISTINCT User_ID
    FROM Orders O
    JOIN Order_Details OD ON O.Order_ID = OD.Order_ID
    WHERE OD.Payment_Completion_Date IS NOT NULL AND DATEDIFF(YEAR, OD.Payment_Completion_Date, GETDATE()) < 1
);
