$(function(){
	/* commen */
	commen();
	function commen (){
		$("#nav-box").children('li').click(function(){
			$(this).siblings('li').removeClass('active');
			$(this).addClass('active');
//			if($(this).index()==0){//管理
//				$(".securityContent").show();
//				$(".bindContent").hide();
//				$(".approvalContent").hide()
//			}else if($(this).index()==1){//审批
//				$(".securityContent").hide();
//				$(".bindContent").hide();
//				$(".approvalContent").show()
//			}else if($(this).index()==2){//绑定
//				$(".securityContent").hide();
//				$(".bindContent").show();
//				$(".approvalContent").hide()
//			}
		});
	}

	/* 管理 */
	security()
	function security (){

	}
	/* 绑定 */
	bind();
	function bind (){
		$("#icon_close").click(function(){
			$(".listPage").hide("slow");
		})

		$(".icon_setting").click(function(){
			$(".listPage").show("slow");
		})

		$("#bindExchangeList").children('li').click(function(){
			$(this).siblings('li').removeClass('active');
			$(this).addClass('active');
		});

		$(".listIcon").children('.annulus').click(function(){
			$(".listIcon").children('.annulus').removeClass('active');
			$(this).addClass('active');
		})
	}
	

	/* 审批 */
	approval();
	function approval (){
		$(".approvalContent").find('tbody>tr>td:nth-child(3)').click(function(){
			$("#windowPage").show('slow');
		})
		$("#windowPage").children('.header').children(".icon_close").click(function(){
			$("#windowPage").hide('slow');
		});

		$("#approvalContentList>tr>td:first-child").click(function(){
			$("#approvalContentList>tr>td").removeClass('active');
			$(this).addClass('active');
		});

		$("#approvalContentList").children('tr').children('td:last-child').find('a:first-child').click(function(){
			$(".approvalContent").children('.deleteTips').show();
		});

		$(".approvalContent").children('.deleteTips').find('.deleteTips-btn span').click(function(){
			$(".approvalContent").children('.deleteTips').hide();
		});
	}
	
})