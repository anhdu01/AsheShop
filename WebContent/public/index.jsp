<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
<!-- body -->
<div class="zopim" __jx__id="___$_65 ___$_65" data-test-id="ChatWidgetButton" style="margin-top: 0px; margin-right: 0px; margin-bottom: 0px; padding: 0px; border: 0px; background: transparent; overflow: hidden; position: fixed; z-index: 16000002; width: 180px; height: 30px; right: 10px; bottom: 0px;"><iframe frameborder="0" src="about:blank" style="background-color: transparent; vertical-align: text-bottom; position: relative; width: 100%; height: 100%; min-width: 100%; min-height: 100%; max-width: 100%; max-height: 100%; margin: 0px; overflow: hidden; display: block;" data-test-id="ChatWidgetButton-iframe"></iframe></div><div class="zopim" __jx__id="___$_4 ___$_4" data-test-id="ChatWidgetWindow" style="margin-top: 0px; margin-right: 0px; margin-bottom: 0px; padding: 0px; border: 0px; background: transparent; overflow: hidden; position: fixed; z-index: 16000001; right: 10px; bottom: 0px; border-top-left-radius: 5px; border-top-right-radius: 5px; display: none; width: 350px; height: 450px; box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 3px 2px;"><iframe frameborder="0" src="about:blank" data-test-id="ChatWidgetWindow-iframe" style="background-color: transparent; vertical-align: text-bottom; position: relative; width: 100%; height: 100%; min-width: 100%; min-height: 100%; max-width: 100%; max-height: 100%; margin: 0px; overflow: hidden; display: block;"></iframe></div>
        

        <div class="box-all">
            <!-- uiView:  --><main class="main ng-scope" ui-view="" style=""><div class="box ng-scope">
    <div class="title-bg bg-tit2">
        <h2 class="text-36">Vì sao bạn nên nhập hàng<br>qua ASHE SHOP?<br>

            <a href="<%=request.getContextPath()%>/indexOrder"><button type="button">Đăng ký ngay</button></a></h2>
        <button><span id="check" onclick="downFunction()"></span></button>
    </div>
</div>
<script>
		function downFunction() {
			document.body.scrollTop = 550;
			document.documentElement.scrollTop = 550;
		}
	</script>
<div class="box ng-scope">
    <div class="title-df">
        <h2 class="text-transform text-24" style="padding: 28px 0 23px;">Dịch vụ vận chuyển uy tín và tốc độ</h2>
    </div>
    <div class="container">
        <div class="service-all">
            <ul>
                <li>
                    <div class="service-detail">
                        <div class="sd-img">
                            <span id="sd1"></span>
                        </div>
                        <div class="sd-text">
                            <label>CƯỚC VẬN CHUYỂN<br> SIÊU THẤP</label>
                            <p>Chỉ 20.000đ/kg</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="service-detail">
                        <div class="sd-img">
                            <span id="sd2"></span>
                        </div>
                        <div class="sd-text">
                            <label>THỜI GIAN VẬN CHUYỂN<br> SIÊU NHANH</label>
                            <p>Từ 2 - 4 ngày</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="service-detail">
                        <div class="sd-img">
                            <span id="sd3"></span>
                        </div>
                        <div class="sd-text">
                            <label>VẬN CHUYỂN HÀNG HÓA <br> UY TÍN</label>
                            <p>Hoàn tiền 100% nếu mất hàng</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="box ng-scope">
    <div class="title-bg bg-tit3">
        <h2 class="text-24 text-transform">Chi phí nhập hàng ưu đãi và linh hoạt</h2>
    </div>
    <div class="container">
        <div class="cost-all">
            <ul>
                <li>
                    <div class="cost-detail">
                        <div class="cd-img">
                            <span id="cd1"></span>
                        </div>
                        <div class="cd-text">
                            <label>phí nhập hộ thấp</label>
                            <p>Chỉ từ 2% tiền hàng</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cost-detail">
                        <div class="cd-img">
                            <span id="cd2"></span>
                        </div>
                        <div class="cd-text">
                            <label>đặt cọc tiền hàng ít</label>
                            <p>Chỉ 70% tiền hàng</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="cost-detail">
                        <div class="cd-img">
                            <span id="cd3"></span>
                        </div>
                        <div class="cd-text">
                            <label>cam kết đặt đúng hàng</label>
                            <p>Đúng link và theo yêu cầu</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="box hidden ng-scope">
    <div class="title-df">
        <h2 class="text-24 text-transform">Hệ thông quản lý thông minh</h2>
    </div>
    <div class="container">
        <div class="system-all">
            <ul>
                <li>
                    <div class="system-detail">
                        <div class="sys-img">
                            <span id="sys1"></span>
                        </div>
                        <div class="sys-text">
                            <label>Quản lý đơn hàng Online<br>thuận tiện</label>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="system-detail">
                        <div class="sys-img">
                            <span id="sys2"></span>
                        </div>
                        <div class="sys-text">
                            <label>Hỗ trợ mạng lưới bán hàng<br>rộng khắp Mạng xã hội</label>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="system-detail">
                        <div class="sys-img">
                            <span id="sys3"></span>
                        </div>
                        <div class="sys-text">
                            <label>Hỗ trợ dịch vụ xử lý đơn hàng<br>vận chuyển tới tay người mua</label>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="box ng-scope">
    <div class="title-bg bg_212">
        <h2 class="text-36" style="padding-top: 78px;">Quy trình nhập hàng qua ASHE SHOP</h2>
        <span id="check" onclick="downFunction1()"></span>
    </div>
   <script>
		function downFunction1() {
			document.body.scrollTop = 1555;
			document.documentElement.scrollTop = 1555;
		}
	</script> 
    <div class="container">
        <div class="procedure-all">
            <div class="procedure-detail">
                <div class="pd-img">
                    <span id="pdi3"></span>
                </div>
                <div class="pd-text">
                    <label>Bước 1:</label>
                    <p>
                        <b>Chọn hàng</b> tại các<br>website Nước Ngoài
                    </p>
                </div>
                <div class="line-step">
                    <span class="line-step1"></span>
                </div>
            </div>
            <div class="procedure-detail">
                <div class="pd-img">
                    <span id="pdi6"></span>
                </div>
                <div class="pd-text">
                    <label>Bước 2:</label>
                    <p>
                        <b>Tạo đơn hàng</b><br>trên website <a href="<%=request.getContextPath()%>/index" title="asheshop">ASHE SHOP</a>
                    </p>
                </div>
                <div class="line-step">
                    <span class="line-step2"></span>
                </div>
            </div>
            <div class="procedure-detail">
                <div class="pd-img">
                    <span id="pdi7"></span>
                </div>
                <div class="pd-text">
                    <label>Bước 3:</label>
                    <p>
                        <b>Đặt cọc</b><br>70% giá trị đơn hàng
                    </p>
                </div>
                <div class="line-step">
                    <span class="line-step1"></span>
                </div>
            </div>
            <div class="procedure-detail">
                <div class="pd-img">
                    <span id="pdi8"></span>
                </div>
                <div class="pd-text">
                    <label>Bước 4:</label>
                    <p>
                        <b>Vận chuyển</b> từ Nước Ngoài<br>về kho Việt Nam
                    </p>
                </div>
                <div class="line-step">
                    <span class="line-step2"></span>
                </div>
            </div>
            <div class="procedure-detail">
                <div class="pd-img">
                    <span id="pdi9"></span>
                </div>
                <div class="pd-text">
                    <label>Bước 5:</label>
                    <p>
                        <b>Nhận hàng</b> tại nhà hoặc<br>Chuyển thẳng tới người mua
                    </p>
                </div>
            </div>
        </div>
        <div class="ad-btn">
            <a href="<%=request.getContextPath()%>/indexPolicy" target="_blank"><button type="button" class="text-bold">Tìm hiểu thêm</button></a>
            <a href="<%=request.getContextPath()%>/indexOrder"><button type="button" class="text-bold">Đăng ký ngay</button></a>
        </div>
    </div>
</div>
</div>
<%@include file="/templates/public/inc/footer.jsp" %>