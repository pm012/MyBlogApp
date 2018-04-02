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
			var isActiveVal=""+user.active;
			var activeIndex//=$(".userAddEditForm #active select option[text='+isActiveVal+']").index();
			var options = document.getElementById('active').options;

			for(var i = 0; i < options.length; i++) {
			    if(options[i].value == isActiveVal) {
			        //options[i].selected = true;
			    	activeIndex=i;
			    	
			        break;
			    }
			}

			$('.userAddEditForm #id').val(user.id);
			$('.userAddEditForm #firstName').val(user.firstName);
			$('.userAddEditForm #nickName').val(user.nickName);
			$('.userAddEditForm #lastName').val(user.lastName);
			$('.userAddEditForm #email').val(user.email);			
			$('.userAddEditForm #active').find('option[value='+isActiveVal+']').val();			
			//$('.userAddEditForm #active').find("option:selected").text(user.active);
			document.getElementById("active").selectedIndex=""+activeIndex;
			
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