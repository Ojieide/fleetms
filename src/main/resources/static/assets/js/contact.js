$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact){
			$('#idEdit').val(contact.id);
			$('#firstnameEdit').val(contact.firstname);
			$('#lastnameEdit').val(contact.lastname);
			$('#emailEdit').val(contact.email);
			$('#phoneEdit').val(contact.phone);
			$('#mobileEdit').val(contact.mobile);
			$('#remarksEdit').val(contact.remarks);
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact){
			$('#idDetails').val(contact.id);
			$('#firstnameDetails').val(contact.firstname);
			$('#lastnameDetails').val(contact.lastname);
			$('#emailDetails').val(contact.email);
			$('#phoneDetails').val(contact.phone);
			$('#mobileDetails').val(contact.mobile);
			$('#remarksDetails').val(contact.remarks);
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();		
	});	
});