
$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(car){
			var acDate = car.acquisitionDate.substr(0,10);
			$('#acquisitiondateEdit').val(acDate);
			$('#descriptionEdit').val(car.description);
			$('#personnelEdit').val(car.personnelid);
			$('#fuelcapacityEdit').val(car.fuelCapacity);
			$('#idEdit').val(car.id);
			$('#locationEdit').val(car.locationid);
			$('#nameEdit').val(car.name);
			$('#netweightEdit').val(car.netWeight);
			$('#energysourceEdit').val(car.energySource);
			var regDate = car.registrationDate.substr(0,10);
			$('#registrationdateEdit').val(regDate);
			$('#remarksEdit').val(car.remarks);
			$('#carbrandEdit').val(car.carbrandid);		
			$('#carmodelEdit').val(car.carmodelid);			
			$('#carnumberEdit').val(car.carNumber);			
			$('#carstatusEdit').val(car.carstatusid);			
			$('#cartypeEdit').val(car.cartypeid);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(car){
			$('#acquisitionDateDetails').val(acDate);
			$('#descriptionDetails').val(car.description);
			$('#personnelDetails').val(car.personnelid);
			$('#fuelcapacityDetails').val(car.fuelCapacity);
			$('#idDetails').val(car.id);
			$('#locationDetails').val(car.locationid);
			$('#nameDetails').val(car.name);
			$('#netweightDetails').val(car.netWeight);
			$('#energysourceDetails').val(car.energySource);
			var regDate = car.registrationDate.substr(0,10);
			$('#registrationdateDetails').val(regDate);
			$('#remarksDetails').val(car.remarks);
			$('#carbrandDetails').val(car.carbrandid);		
			$('#carmodelDetails').val(car.carmodelid);			
			$('#carnumberDetails').val(car.carNumber);			
			$('#carstatusDetails').val(car.carstatusid);			
			$('#cartypeDetails').val(car.cartypeid);	
			$('#updatedbyDetails').val(car.updatedby);
			$('#updateddateDetails').val(car.updateddate.substr(0,19).replace("T", " "));
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