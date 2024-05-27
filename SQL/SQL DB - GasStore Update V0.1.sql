USE master;
GO
DROP DATABASE IF EXISTS GasStore;
GO
CREATE DATABASE GasStore;
GO
USE GasStore;
GO

-- Table Manager (kết hợp Staff và Admin)
CREATE TABLE Managers (
    Manager_ID INT PRIMARY KEY IDENTITY(1,1),
    Manager_Email NVARCHAR(100) NOT NULL UNIQUE,
    Manager_Password VARBINARY(64) NOT NULL,
    Manager_Address NVARCHAR(255),
    Manager_PhoneNum NVARCHAR(20),
    Manager_Gender NVARCHAR(10),
    IsAdmin BIT NOT NULL,
    IsStaff BIT NOT NULL,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE()
);

-- Table Users
CREATE TABLE Users (
    User_ID INT PRIMARY KEY IDENTITY(1,1),
    User_Name NVARCHAR(100) NOT NULL,
    User_Password VARBINARY(64) NOT NULL,
    User_Email NVARCHAR(100) NOT NULL UNIQUE,
    User_PhoneNum NVARCHAR(20),
    User_Address NVARCHAR(255),
    User_Gender NVARCHAR(10),
	User_Image NVARCHAR (MAX),
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    IsCustomer BIT DEFAULT 0,
    IsGuest BIT DEFAULT 1
);

-- Table Categories
CREATE TABLE Categories (
    Category_ID INT PRIMARY KEY IDENTITY(1,1),
    Category_Name NVARCHAR(100) NOT NULL,
    Description NVARCHAR(255)
);

-- Table Products
CREATE TABLE Products (
    Product_ID INT PRIMARY KEY IDENTITY(1,1),
    Category_ID INT,
    SerialProduct_Number NVARCHAR(100),
    Product_Name NVARCHAR(100) NOT NULL,
    Product_Quantity INT CHECK (Product_Quantity >= 0),
    Product_Price DECIMAL(18, 2),
    Product_Description NVARCHAR(255),
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Category_ID) REFERENCES Categories(Category_ID)
);

-- Table Orders
CREATE TABLE Orders (
    Order_ID INT PRIMARY KEY IDENTITY(1,1),
    Order_Date DATETIME NOT NULL,
    User_ID INT,
    Order_Status NVARCHAR(50),
    Order_Total_Money FLOAT,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (User_ID) REFERENCES Users(User_ID)
);

-- Table Order_Details
CREATE TABLE Order_Details (
    OrderDetail_ID INT PRIMARY KEY IDENTITY(1,1),
    Order_ID INT,
    Product_ID INT,
    Order_Quantity INT CHECK (Order_Quantity > 0),
    OrderDetail_Status NVARCHAR(50),
    Total_Amount_Paid FLOAT,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table Discounts
CREATE TABLE Discounts (
    Discount_ID INT PRIMARY KEY IDENTITY(1,1),
    Discount_Name NVARCHAR(100),
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

-- Table Warranties
CREATE TABLE Warranties (
    Warranty_ID INT PRIMARY KEY IDENTITY(1,1),
    Product_ID INT,
    Warranty_Start_Date DATETIME,
    Warranty_Description NVARCHAR(255),
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Table UserWarranty
CREATE TABLE UserWarranty (
    UserWarranty_ID INT PRIMARY KEY IDENTITY(1,1),
    Order_ID INT,
    Product_ID INT,
    Image NVARCHAR(255),
    Description NVARCHAR(MAX),
    UserWarranty_Status NVARCHAR(50),
    UserWarranty_Start_Date DATETIME,
    UserWarranty_End_Date DATETIME,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    Manager_ID INT,
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID),
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
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Manager_ID) REFERENCES Managers(Manager_ID),
    FOREIGN KEY (OrderDetail_ID) REFERENCES Order_Details(OrderDetail_ID)
);

-- Table Image_Product
CREATE TABLE Image_Product (
    Image_ID INT PRIMARY KEY IDENTITY(1,1),
    Product_ID INT,
    Image_URL NVARCHAR(255),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);

-- Lệnh JOIN Users và Managers để kiểm tra đăng nhập
SELECT 
    U.User_ID AS ID,
    U.User_Email AS Email,
    U.User_Password AS Password,
    'Customer' AS Role
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

-- Lệnh cập nhật từ isGuest lên isCustomer khi người dùng mua ít nhất một sản phẩm
UPDATE Users
SET IsCustomer = 1, IsGuest = 0
WHERE User_ID IN (
    SELECT DISTINCT User_ID
    FROM Orders O
    JOIN Order_Details OD ON O.Order_ID = OD.Order_ID
    WHERE OD.Order_Quantity > 0
);
