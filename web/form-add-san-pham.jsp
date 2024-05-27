<%-- 
    Document   : form-add-san-pham
    Created on : May 13, 2024, 10:50:26 AM
    Author     : xuank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sản phẩm | Quản trị Admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script>

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
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
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
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

            #uploadfile,
            .removeimg {
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
                /* border: 3px solid red; */
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
                /* color: #FFF; */
                /* background-color: #DC403B; */
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
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="/Manager"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>Admin</b></p>
                    <p class="app-sidebar__user-designation">Welcome Admin</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="phan-mem-ban-hang.jsp"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS Bán Hàng</span></a></li>
                <li><a class="app-menu__item " href="Manager"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng Thống Kê</span></a></li>
                <li><a class="app-menu__item" href="StaffURL"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Quản lý nhân viên</span></a></li>
                <li><a class="app-menu__item" href="CustomerURL"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Quản lý khách hàng</span></a></li>
                <li><a class="app-menu__item active haha" href="ProductURL"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item" href="ShippingURL"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="UserWarrantyURL"><i class='app-menu__icon bx bx-check-shield'></i>
                        <span class="app-menu__label">Bảo Hành User</span></a></li>
                <li><a class="app-menu__item" href="Shipping"><i class='app-menu__icon bx bx-package' ></i>
                        <span class="app-menu__label">Quản Lí Giao Hàng</span></a></li>
                <!--      <li><a class="app-menu__item" href="table-data-banned.html"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Quản lý nội bộ
                          </span></a></li>-->
                <!--                <li><a class="app-menu__item" href="table-data-money.jsp"><i class='app-menu__icon bx bx-dollar'></i><span
                                            class="app-menu__label">Bảng kê lương</span></a></li>-->
                <li><a class="app-menu__item" href="quan-ly-bao-cao.jsp"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>
                <!--      <li><a class="app-menu__item" href="page-calendar.html"><i class='app-menu__icon bx bx-calendar-check'></i><span
                            class="app-menu__label">Lịch công tác </span></a></li>-->
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài
                            đặt hệ thống</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách sản phẩm</li>
                    <li class="breadcrumb-item"><a href="#">Thêm sản phẩm</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Tạo mới sản phẩm</h3>
                        <div class="tile-body">
                            <form class="row" method="post" action="updateP">

                                <!--                                <div class="form-group col-md-3 ">
                                                                    <label for="exampleSelect1" class="control-label">Tình trạng</label>
                                                                    <select class="form-control" id="exampleSelect1">
                                                                        <option>-- Chọn tình trạng --</option>
                                                                        <option>Còn hàng</option>
                                                                        <option>Hết hàng</option>
                                                                    </select>
                                                                </div>-->
                                <!--                                <div class="form-group col-md-3">
                                                                    <label for="exampleSelect1" class="control-label">Danh mục</label>
                                                                    <select class="form-control" id="exampleSelect1">
                                                                        <option>-- Chọn danh mục --</option>
                                                                        <option>Bàn ăn</option>
                                                                        <option>Bàn thông minh</option>
                                                                        <option>Tủ</option>
                                                                        <option>Ghế gỗ</option>
                                                                        <option>Ghế sắt</option>
                                                                        <option>Giường người lớn</option>
                                                                        <option>Giường trẻ em</option>
                                                                        <option>Bàn trang điểm</option>
                                                                        <option>Giá đỡ</option>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group col-md-3 ">
                                                                    <label for="exampleSelect1" class="control-label">Nhà cung cấp</label>
                                                                    <select class="form-control" id="exampleSelect1">
                                                                        <option>-- Chọn nhà cung cấp --</option>
                                                                        <option>Phong vũ</option>
                                                                        <option>Thế giới di động</option>
                                                                        <option>FPT</option>
                                                                        <option>Võ Trường</option>
                                                                    </select>
                                                                </div>-->

                                <div class="form-group col-md-3">
                                    <label class="control-label">Loại Sản Phẩm</label>
                                    <select class="form-control" name="category" required>
                                        <option value="1">Bếp Gas</option>
                                        <option value="2">Bình Gas</option>
                                        <option value="3">Phụ Kiện</option>
                                        <option value="4">Bếp Điện</option>
                                        <option value="5">Bếp Từ</option>
                                        <option value="6">Bếp Hồng Ngoại</option>
                                        <option value="7">Dụng cụ nấu nướng</option>
                                        <option value="8">Thiết Bị An Toàn</option>
                                        <option value="9">Sửa Chữa</option>
                                        <option value="10">Khuyến Mãi Đặc Biệt</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Mã sản phẩm </label>
                                    <input class="form-control" type="text" name="serial" placeholder="">
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Tên sản phẩm</label>
                                    <input class="form-control" type="text" name="name">
                                </div>
                                <div class="form-group  col-md-3">
                                    <label class="control-label">Số lượng</label>
                                    <input class="form-control" type="number" name="quantity">
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Giá bán</label>
                                    <input class="form-control" type="text" name="price">
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Ngày tạo</label>
                                    <input class="form-control" type="datetime-local" name="createdAt" required>
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="control-label">Ngày cập nhật</label>
                                    <input class="form-control" type="datetime-local" name="UpdatedAt" required>
                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Ảnh sản phẩm</label>
                                    <div id="myfileupload">
                                        <input type="file" id="uploadfile" name="ImageUpload" onchange="readURL(this);" />
                                    </div>
                                    <div id="thumbbox">
                                        <img height="450" width="400" alt="Thumb image" id="thumbimage" style="display: none" />
                                        <a class="removeimg" href="javascript:"></a>
                                    </div>
                                    <div id="boxchoice">
                                        <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Chọn ảnh</a>
                                        <p style="clear:both"></p>
                                    </div>

                                </div>
                                <div class="form-group col-md-12">
                                    <label class="control-label">Mô tả sản phẩm</label>
                                    <textarea class="form-control" name="description" id="description"></textarea>
                                    <script>CKEDITOR.replace('mota');</script>
                                </div>
                                <button type="submit" name="Submit" class="btn btn-save">Lưu lại</button>
                                <a class="btn btn-cancel" href="ProductURL">Hủy bỏ</a>
                                <input type="hidden" name="service" value="insertProduct">
                            </form>
                        </div>
                    </div>
                </div>

        </main>


        <!--
        MODAL CHỨC VỤ 
        -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Thêm mới nhà cung cấp</h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Nhập tên chức vụ mới</label>
                                <input class="form-control" type="text" required>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        <BR>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->



        <!--
        MODAL DANH MỤC
        -->
        <div class="modal fade" id="adddanhmuc" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Thêm mới danh mục </h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Nhập tên danh mục mới</label>
                                <input class="form-control" type="text" required>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Danh mục sản phẩm hiện đang có</label>
                                <ul style="padding-left: 20px;">
                                    <li>Bàn ăn</li>
                                    <li>Bàn thông minh</li>
                                    <li>Tủ</li>
                                    <li>Ghế gỗ</li>
                                    <li>Ghế sắt</li>
                                    <li>Giường người lớn</li>
                                    <li>Giường trẻ em</li>
                                    <li>Bàn trang điểm</li>
                                    <li>Giá đỡ</li>
                                </ul>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        <BR>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->




        <!--
        MODAL TÌNH TRẠNG
        -->
        <div class="modal fade" id="addtinhtrang" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
             data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">

                    <div class="modal-body">
                        <div class="row">
                            <div class="form-group  col-md-12">
                                <span class="thong-tin-thanh-toan">
                                    <h5>Thêm mới tình trạng</h5>
                                </span>
                            </div>
                            <div class="form-group col-md-12">
                                <label class="control-label">Nhập tình trạng mới</label>
                                <input class="form-control" type="text" required>
                            </div>
                        </div>
                        <BR>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                        <BR>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <!--
      MODAL
        -->



        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/plugins/pace.min.js"></script>
        <script>
                                        const inpFile = document.getElementById("inpFile");
                                        const loadFile = document.getElementById("loadFile");
                                        const previewContainer = document.getElementById("imagePreview");
                                        const previewContainer = document.getElementById("imagePreview");
                                        const previewImage = previewContainer.querySelector(".image-preview__image");
                                        const previewDefaultText = previewContainer.querySelector(".image-preview__default-text");
                                        inpFile.addEventListener("change", function () {
                                            const file = this.files[0];
                                            if (file) {
                                                const reader = new FileReader();
                                                previewDefaultText.style.display = "none";
                                                previewImage.style.display = "block";
                                                reader.addEventListener("load", function () {
                                                    previewImage.setAttribute("src", this.result);
                                                });
                                                reader.readAsDataURL(file);
                                            }
                                        });
                                        $(document).ready(function () {
                                            $(".btn-save").click(function () {
                                                // Thu thập các giá trị từ form
                                                var maSanPham = $("#maSanPham").val();
                                                var tenSanPham = $("#tenSanPham").val();
                                                var soLuong = $("#soLuong").val();
                                                var tinhTrang = $("#exampleSelect1 option:selected").text();
                                                var danhMuc = $("#exampleSelect2 option:selected").text();
                                                var nhaCungCap = $("#exampleSelect3 option:selected").text();
                                                var giaBan = $("#giaBan").val();
                                                var giaVon = $("#giaVon").val();
                                                var moTa = CKEDITOR.instances['mota'].getData(); // Lấy giá trị từ trình soạn thảo CKEditor

                                                // Gửi dữ liệu sản phẩm đến backend server (ở đây là một URL cụ thể)
                                                $.ajax({
                                                    url: "url_to_your_backend_server",
                                                    type: "POST",
                                                    data: {
                                                        maSanPham: maSanPham,
                                                        tenSanPham: tenSanPham,
                                                        soLuong: soLuong,
                                                        tinhTrang: tinhTrang,
                                                        danhMuc: danhMuc,
                                                        nhaCungCap: nhaCungCap,
                                                        giaBan: giaBan,
                                                        giaVon: giaVon,
                                                        moTa: moTa
                                                    },
                                                    success: function (response) {
                                                        // Xử lý kết quả sau khi gửi dữ liệu thành công
                                                        // Ví dụ: hiển thị thông báo hoặc làm mới trang
                                                        alert("Sản phẩm đã được thêm thành công!");
                                                        window.location.href = "table-data-product.html"; // Chuyển hướng người dùng đến trang danh sách sản phẩm
                                                    },
                                                    error: function (xhr, status, error) {
                                                        // Xử lý khi có lỗi xảy ra
                                                        alert("Đã có lỗi xảy ra: " + error);
                                                    }
                                                });
                                            });
                                        });

        </script>
    </body>

</html>