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
			var isActive=user.active+"";
			$('.userAddEditForm #id').val(user.id);
			$('.userAddEditForm #firstName').val(user.firstName);
			$('.userAddEditForm #nickName').val(user.nickName);
			$('.userAddEditForm #lastName').val(user.lastName);
			$('.userAddEditForm #email').val(user.email);
			$('.userAddEditForm #active').find("option:selected").text(user.active);
			
		});
		$('.userAddEditForm #exampleModal').modal();
		}else{
			$('.userAddEditForm #id').val('');
			$('.userAddEditForm #nickName').val('');
			$('.userAddEditForm #firstName').val('');
			$('.userAddEditForm #lastName').val('');
			$('.userAddEditForm #email').val('');
			$('.userAddEditForm #active').val('true');
			$('.userAddEditForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteUserModal #delRef').attr('href',href);
		$('#deleteUserModal').modal();
	});
});