<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm nhân viên | Quản trị Admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <script>
            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else {
                    $("#thumbimage").attr('src', input.value);
                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');
            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile" onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            });
        </script>
    </head>
    <body class="app sidebar-mini rtl">
        <style>
            .Choicefile {
                display: block;
                background: #14142B;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }
            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }
            #uploadfile, .removeimg {
                display: none;
            }
            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }
            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                border-radius: 50%;
            }
            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }
            .removeimg::after {
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">
                <!-- User Menu-->
                <li><a class="app-nav__item" href="/home"><i class='bx bx-log-out bx-rotate-180'></i></a></li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px" alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>Admin</b></p>
                    <p class="app-sidebar__user-designation">Welcome Admin</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="phan-mem-ban-hang.jsp"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS Bán Hàng</span></a></li>
                <li><a class="app-menu__item" href="home"><i class='app-menu__icon bx bx-tachometer'></i><span class="app-menu__label">Bảng Thống Kê</span></a></li>
                <li><a class="app-menu__item active haha" href="StaffURL"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Quản lý nhân viên</span></a></li>
                <li><a class="app-menu__item" href="CustomerURL"><i class='app-menu__icon bx bx-user-voice'></i><span class="app-menu__label">Quản lý khách hàng</span></a></li>
                <li><a class="app-menu__item" href="ProductURL"><i class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a></li>
                <li><a class="app-menu__item" href="ShippingURL"><i class='app-menu__icon bx bx-task'></i><span class="app-menu__label">Quản lý đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="bao-hanh-nguoi-dung.jsp"><i class='app-menu__icon bx bx-check-shield'></i>
                        <span class="app-menu__label">Bảo Hành User</span></a></li>
                <li><a class="app-menu__item" href="quan-ly-giao-hang.jsp"><i class='app-menu__icon bx bx-package'></i>
                        <span class="app-menu__label">Quản Lí Giao Hàng</span></a></li>
                <li><a class="app-menu__item" href="quan-ly-bao-cao.jsp"><i class='app-menu__icon bx bx-pie-chart-alt-2'></i>
                        <span class="app-menu__label">Báo cáo doanh thu</span></a></li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài đặt</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item"><a href="#"><b>Danh sách nhân viên</b></a></li>
                    <li class="breadcrumb-item active"><a href="#">Thêm nhân viên</a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <h3 class="head-title">Thêm nhân viên</h3>
            <form action="updateS" method="post">
                <div class="row">
                    <div class="form-group col-md-3">
                        <label class="control-label">Email</label>
                        <input class="form-control" type="text" name="email" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Mật khẩu</label>
                        <input class="form-control" type="password" name="pass" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Địa chỉ</label>
                        <input class="form-control" type="text" name="address" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Số điện thoại</label>
                        <input class="form-control" type="text" name="phone" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Giới tính</label>
                        <select class="form-control" name="gender" required>
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                            <option value="Khác">Khác</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Chọn vai trò</label>
                        <select class="form-control" name="Role" required>
                            <option value="1">Admin</option>
                            <option value="2">Staff</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Ngày tạo</label>
                        <input class="form-control" type="datetime-local" name="createdD" required>
                    </div>
                    <div class="form-group col-md-3">
                        <label class="control-label">Ngày cập nhật</label>
                        <input class="form-control" type="datetime-local" name="UpdatedAt" required>
                    </div>
                </div>
                <button type="submit" name="Submit" class="btn btn-save">Lưu lại</button>
                <a class="btn btn-cancel" href="StaffURL">Hủy bỏ</a>
                <input type="hidden" name="service" value="insertStaff">
            </form>
        </main>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script type="text/javascript" src="js/plugins/chart.js"></script>
    </body>
</html>