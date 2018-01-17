$(function(){
	$("#nav-box").children('li').click(function(){
		$("#nav-box").children('li').removeClass('active');
		$(this).addClass('active');
		console.log($(this).index())
		if($(this).index()==0){
			$(".manageContent").show();
			$(".addContent").hide();
		}else if($(this).index()==1){
			$(".manageContent").hide();
			$(".addContent").show();
		}
	});

	/* 管理 */
//	$("#infoLook>li").find('.icon_look').click(function(){
//		$(".manageContentPage").show("slow");
//	});

	$(".manageContentPage").children('.title').children('.icon_close').click(function(){
		$(".manageContentPage").hide("slow");
	});

//	$("#infoLook").children('li').find('.icon_delete').click(function(){
//		$(".deleteTips").show();
//	});

//	$(".deleteTips").children('.content').children('.deleteTips-btn').children('span').click(function(){
//		$(".deleteTips").hide();
//	});

	/* 添加 */
	$("#addContent-save").click(function(){
		$(".addContent").children('.content').children('.body').children('.addContent-showInfo').show();
	});
})