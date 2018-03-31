/**
 * 
 */

$(document).ready(function(){
	
	$('.nBtn, .table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text='Edit'){
		$.get(href,function(user,status){
			$('.myForm #id').val(user.id);
			$('.myForm #name').val(user.name);
			$('.myForm #lastName').val(user.lastName);
			$('.myForm #email').val(user.email);
			
		});
		$('.myForm #exampleModal').modal();
		}else{
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #lastName').val('');
			$('.myForm #email').val('');
			$('.myForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
	});
});