<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- right bar -->
<div class="col-sm-3  right-content"
	style="margin-top: 20px; margin-bottom: 30px">
	<div class="col-lg-12 col-sm-12 col-md-12 title-add-seudo">LIÊN
		HỆ NGAY</div>
	<div class="col-lg-12 col-sm-12 col-md-12 content-add-seudo">
		<span class="text-bold" style="margin-left: 20px;">SỐ TÀI KHOẢN THANH TOÁN:</span> <br> <br>
		<span class="text-bold"><i class="fa fa-user"></i>  Chủ Thẻ:</span> Thái Quang Anh Tuấn<br> <br> 
		<span class="text-bold"><big>&#9755;</big>
			VietcomBank:</span> 0161001619947 <br> <br> <span class="text-bold"><big>&#9755;</big>
			VietinBank:</span> 109006370213 <br>
		<br> <span class="text-bold"><big>&#9755;</big> DongA:</span> 0108927156<br> <br>
		<div>
			<i class="fa fa-phone" style="font-size: 15px"></i> <a href="#">0906.400.956</a>
		</div>
		</br>
		<div>
			<i class="fa fa-envelope" style="font-size: 15px"></i> <a
				class="text-mail-top" target="_blank"
				href="mailto:tqatuan1694@gmail.com">tqatuan1694@gmail.com</a>

		</div>
		</br>
		<div>
			<i class="fa fa-mail-forward" style="font-size: 15px"></i> <a
				class="last" href="skype:fw.thaiquanganhtuan?call">Chat With ASHE SHOP</a>
		</div>
	</div>
	<div class="col-lg-12 col-sm-12 col-md-12 title-add-seudo" style="margin-top: 10px;">Tìm
		Kiếm Đơn Hàng</div>
	<div class="col-lg-12 col-sm-12 col-md-12 content-add-seudo">
		<form class="form-horizontal form-search" role="form" method="post"
			action="<%=request.getContextPath()%>/status">
			<div class="form-group">
				<div class="col-sm-9">
					<input type="text" name="code" class="form-control required"
						id="code" placeholder="Nhập code đơn hàng" style="width: 250px;">
				</div>
			</div>
			<div class="modal-footer">
				<input class="button-add btn btn-success create-button"
					name="submit" type="submit" value="Tìm kiếm" />
			</div>
		</form>
	</div>
	<div class="col-lg-12 col-sm-12 col-md-12" style="margin-top: 10px;">
		<div class="">
			<center>
				<script language="javascript" type="text/javascript">
					var day_of_week = new Array('Sun', 'Mon', 'Tue', 'Wed',
							'Thu', 'Fri', 'Sat');
					var month_of_year = new Array('January', 'February',
							'March', 'April', 'May', 'June', 'July', 'August',
							'September', 'October', 'November', 'December');

					//  DECLARE AND INITIALIZE VARIABLES
					var Calendar = new Date();

					var year = Calendar.getFullYear(); // Returns year
					var month = Calendar.getMonth(); // Returns month (0-11)
					var today = Calendar.getDate(); // Returns day (1-31)
					var weekday = Calendar.getDay(); // Returns day (1-31)

					var DAYS_OF_WEEK = 7; // "constant" for number of days in a week
					var DAYS_OF_MONTH = 31; // "constant" for number of days in a month
					var cal; // Used for printing

					Calendar.setDate(1); // Start the calendar day at '1'
					Calendar.setMonth(month); // Start the calendar month at now

					/* VARIABLES FOR FORMATTING
					 NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
					 tags to customize your caledanr's look. */

					var TR_start = '<TR>';
					var TR_end = '</TR>';
					var highlight_start = '<TD WIDTH="30"><TABLE CELLSPACING=0 BORDER=1 BGCOLOR=DEDEFF BORDERCOLOR=CCCCCC><TR><TD WIDTH=20><B><CENTER>';
					var highlight_end = '</CENTER></TD></TR></TABLE></B>';
					var TD_start = '<TD WIDTH="30"><CENTER>';
					var TD_end = '</CENTER></TD>';

					/* BEGIN CODE FOR CALENDAR
					 NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
					 tags to customize your calendar's look.*/

					cal = '<TABLE BORDER=1 CELLSPACING=0 CELLPADDING=0 BORDERCOLOR=BBBBBB><TR><TD>';
					cal += '<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=2>'
							+ TR_start;
					cal += '<TD COLSPAN="' + DAYS_OF_WEEK + '" BGCOLOR="#3C763D"><CENTER><B>';
					cal += month_of_year[month] + '   ' + year + '</B>'
							+ TD_end + TR_end;
					cal += TR_start;

					//   DO NOT EDIT BELOW THIS POINT  //

					// LOOPS FOR EACH DAY OF WEEK
					for (index = 0; index < DAYS_OF_WEEK; index++) {

						// BOLD TODAY'S DAY OF WEEK
						if (weekday == index)
							cal += TD_start + '<B>' + day_of_week[index]
									+ '</B>' + TD_end;

						// PRINTS DAY
						else
							cal += TD_start + day_of_week[index] + TD_end;
					}

					cal += TD_end + TR_end;
					cal += TR_start;

					// FILL IN BLANK GAPS UNTIL TODAY'S DAY
					for (index = 0; index < Calendar.getDay(); index++)
						cal += TD_start + '  ' + TD_end;

					// LOOPS FOR EACH DAY IN CALENDAR
					for (index = 0; index < DAYS_OF_MONTH; index++) {
						if (Calendar.getDate() > index) {
							// RETURNS THE NEXT DAY TO PRINT
							week_day = Calendar.getDay();

							// START NEW ROW FOR FIRST DAY OF WEEK
							if (week_day == 0)
								cal += TR_start;

							if (week_day != DAYS_OF_WEEK) {

								// SET VARIABLE INSIDE LOOP FOR INCREMENTING PURPOSES
								var day = Calendar.getDate();

								// HIGHLIGHT TODAY'S DATE
								if (today == Calendar.getDate())
									cal += highlight_start + day
											+ highlight_end + TD_end;

								// PRINTS DAY
								else
									cal += TD_start + day + TD_end;
							}

							// END ROW FOR LAST DAY OF WEEK
							if (week_day == DAYS_OF_WEEK)
								cal += TR_end;
						}

						// INCREMENTS UNTIL END OF THE MONTH
						Calendar.setDate(Calendar.getDate() + 1);

					}// end for loop

					cal += '</TD></TR></TABLE></TABLE>';

					//  PRINT CALENDAR
					document.write(cal);
				//  End -->
				</script>
			</center>
		</div>
	</div>

</div>

<!-- end rightbar -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".form-search")
								.validate(
										{
											rules : {
												code : {
													required : true,
													number : true,
												}

											},
											messages : {
												code : {
													required : "<span style='color:red;font-weight:bold;font-size:13px;'>Vui Lòng Nhập Mã Vận Đơn!!!</span>",
													number : "<span style='color:red;font-weight:bold;font-size:13px;'>Mã Vận Đơn Phải Là Dãy Số!!!</span>",
												},

											}
										});
					});
</script>
<!-- end body -->