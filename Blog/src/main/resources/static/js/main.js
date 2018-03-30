/**
 * 
 */

$(document).ready(function(){
	
	$('.table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href,function(user,status){
			$('.myForm #id').val(user.id);
			$('.myForm #name').val(user.name);
			$('.myForm #lastName').val(user.lastName);
			$('.myForm #email').val(user.email);
			
		});
		$('.myForm #exampleModal').modal();
	});
});