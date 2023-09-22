
$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(personnel){
			$('#addressEdit').val(personnel.address);
			$('#cityEdit').val(personnel.city);
			$('#nationalityEdit').val(personnel.countryid);			
			$('#dateofbirthEdit').val(personnel.dateOfBirth.substr(0,10));
			$('#emailEdit').val(personnel.email);
			$('#firstnameEdit').val(personnel.firstname);
			$('#genderEdit').val(personnel.gender);
			$('#idEdit').val(personnel.id);
			$('#initialsEdit').val(personnel.initials);
			$('#lastnameEdit').val(personnel.lastname);
			$('#maritalstatusEdit').val(personnel.maritalStatus);
			$('#mobileEdit').val(personnel.mobile);
			$('#othernameEdit').val(personnel.othername);		
			$('#phoneEdit').val(personnel.phone);			
			$('#imageEdit').val(personnel.photo);			
			$('#nationalidentitynumberEdit').val(personnel.nationalIdentityNumber);			
			$('#stateEdit').val(personnel.stateid);	
			$('#titleEdit').val(personnel.title);			
			$('#personneltypeEdit').val(personnel.personneltypeid);				
			$('#hiredateEdit').val(personnel.hireDate.substr(0,10));
			$('#roleEdit').val(personnel.roleid);		
		});			
		$('#editModal').modal();		
	});
	
		$('.table #detailsBtn').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(personnel){
			$('#addressDetails').val(personnel.address);
			$('#cityDetails').val(personnel.city);
			$('#nationalityDetails').val(personnel.countryid);			
			$('#dateofbirthDetails').val(personnel.dateOfBirth.substr(0,10));
			$('#emailDetails').val(personnel.email);
			$('#firstnameDetails').val(personnel.firstname);
			$('#genderDetails').val(personnel.gender);
			$('#idDetails').val(personnel.id);
			$('#initialsDetails').val(personnel.initials);
			$('#lastnameDetails').val(personnel.lastname);
			$('#maritalstatusDetails').val(personnel.maritalStatus);
			$('#mobileDetails').val(personnel.mobile);
			$('#othernameDetails').val(personnel.othername);		
			$('#phoneDetails').val(personnel.phone);			
			$('#imageDetails').val(personnel.photo);			
			$('#nationalidentitynumberDetails').val(personnel.nationalIdentityNumber);			
			$('#stateDetails').val(personnel.stateid);	
			$('#titleDetails').val(personnel.title);			
			$('#personneltypeDetails').val(personnel.personneltypeid);				
			$('#hiredateDetails').val(personnel.hireDate.substr(0,10));
			$('#roleDetails').val(personnel.roleid);		
		});			
		$('#detailsModal').modal();		
	});
	
	$('.table #deleteBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #imageBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#imageModal #personnelImage').attr('src', href);
		$('#imageModal').modal();
	});	

});