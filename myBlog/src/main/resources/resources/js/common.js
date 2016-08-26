/**
 * 
 */


function test(){
	console.log("test ok");
};


$(document).ready(function(){
	$(".menu").on("click",function(){		
		$(".menu").removeClass();		
		$(this).addClass("menu active");
	});
});