USE master
GO
DROP DATABASE GasStore
GO
CREATE DATABASE GasStore
GO
USE GasStore
GO

-- Table Role
CREATE TABLE Roles (
    Role_ID INT PRIMARY KEY IDENTITY(1,1),
    Role_Name NVARCHAR(100),
    Account_Status NVARCHAR(50)
);

-- Table Admin
CREATE TABLE Admins (
    Admin_ID INT PRIMARY KEY IDENTITY(1,1),
    Admin_Email NVARCHAR(100) NOT NULL UNIQUE,
    Admin_Password VARBINARY(64) NOT NULL,
    Admin_Address NVARCHAR(255),
    Admin_PhoneNum NVARCHAR(20),
    Admin_Gender NVARCHAR(10),
    Role_ID INT,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Role_ID) REFERENCES Roles(Role_ID)
);

-- Table Customer
CREATE TABLE Customers (
    User_ID INT PRIMARY KEY IDENTITY(1,1),
    User_Name NVARCHAR(100) NOT NULL,
    User_Password VARBINARY(64) NOT NULL,
    User_Email NVARCHAR(100) NOT NULL UNIQUE,
    User_PhoneNum NVARCHAR(20),
    User_Address NVARCHAR(255),
    User_Gender NVARCHAR(10),
    Role_ID INT,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Role_ID) REFERENCES Roles(Role_ID)
);

-- Table Staff
CREATE TABLE Staffs (
    Staff_ID INT PRIMARY KEY IDENTITY(1,1),
    Staff_Email NVARCHAR(100) NOT NULL UNIQUE,
    Staff_Password VARBINARY(64) NOT NULL,
    Staff_Address NVARCHAR(255),
    Staff_PhoneNum NVARCHAR(20),
    Staff_Gender NVARCHAR(10),
    Role_ID INT,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Role_ID) REFERENCES Roles(Role_ID)
);

-- Table Categories
CREATE TABLE Categories (
    Category_ID INT PRIMARY KEY IDENTITY(1,1),
    Category_Name NVARCHAR(100) NOT NULL,
    Category_Quantity INT CHECK (Category_Quantity >= 0),
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
    Order_Total_Money DECIMAL(18, 2),
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (User_ID) REFERENCES Customers(User_ID)
);

-- Table Order_Details
CREATE TABLE Order_Details (
    OrderDetail_ID INT PRIMARY KEY IDENTITY(1,1),
    Order_ID INT,
    Product_ID INT,
    Order_Quantity INT CHECK (Order_Quantity > 0),
    OrderDetail_Status NVARCHAR(50),
    Total_Amount_Paid DECIMAL(18, 2),
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
    Discount_Percent DECIMAL(5, 2) CHECK (Discount_Percent >= 0 AND Discount_Percent <= 100),
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
    Staff_ID INT,
    FOREIGN KEY (Order_ID) REFERENCES Orders(Order_ID),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID),
    FOREIGN KEY (Staff_ID) REFERENCES Staffs(Staff_ID)
);

-- Table Shipping
CREATE TABLE Shipping (
    Shipping_ID INT PRIMARY KEY IDENTITY(1,1),
    Staff_ID INT,
    OrderDetail_ID INT,
    Shipping_Status NVARCHAR(50),
    Shipping_Cost DECIMAL(18, 2),
    Shipping_Date DATETIME,
    Created_At DATETIME DEFAULT GETDATE(),
    Updated_At DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (Staff_ID) REFERENCES Staffs(Staff_ID),
    FOREIGN KEY (OrderDetail_ID) REFERENCES Order_Details(OrderDetail_ID)
);

-- Table Image_Product
CREATE TABLE Image_Product (
    Image_ID INT PRIMARY KEY IDENTITY(1,1),
    Product_ID INT,
    Image_URL NVARCHAR(255),
    FOREIGN KEY (Product_ID) REFERENCES Products(Product_ID)
);
