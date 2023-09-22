
$('document').ready(function() {
	
	$('.table #editBtn').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(car){
			$('#acquisitiondateEdit').val(car.acquisitionDate.substr(0,10));
			$('#descriptionEdit').val(car.description);
			$('#personnelEdit').val(car.personnelid);
			$('#fuelcapacityEdit').val(car.fuelCapacity);
			$('#idEdit').val(car.id);
			$('#currentlocationEdit').val(car.locationid);
			$('#carnameEdit').val(car.name);
			$('#netweightEdit').val(car.netWeight);
			$('#energysourceEdit').val(car.energySource);
			$('#registrationdateEdit').val(car.registrationDate.substr(0,10));
			$('#remarksEdit').val(car.remarks);
			$('#carbrandEdit').val(car.carbrandid);		
			$('#carmodelEdit').val(car.carmodelid);			
			$('#carnumberEdit').val(car.carNumber);			
			$('#carstatusEdit').val(car.carstatusid);			
			$('#cartypeEdit').val(car.cartypeid);
			$('#imageEdit').val(car.photo);	
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsBtn').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(car){
			$('#acquisitiondateDetails').val(car.acquisitionDate.substr(0,10));
			$('#descriptionDetails').val(car.description);
			$('#personnelDetails').val(car.personnelid);
			$('#fuelcapacityDetails').val(car.fuelCapacity);
			$('#idDetails').val(car.id);
			$('#currentlocationDetails').val(car.locationid);
			$('#carnameDetails').val(car.name);
			$('#netweightDetails').val(car.netWeight);
			$('#energysourceDetails').val(car.energySource);
			$('#registrationdateDetails').val(car.registrationDate.substr(0,10));
			$('#remarksDetails').val(car.remarks);
			$('#carbrandDetails').val(car.carbrandid);		
			$('#carmodelDetails').val(car.carmodelid);			
			$('#carnumberDetails').val(car.carNumber);			
			$('#carstatusDetails').val(car.carstatusid);			
			$('#cartypeDetails').val(car.cartypeid);
			$('#imageDetails').val(car.photo);	
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteBtn').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDeleteBtn').attr('href', href);
		$('#deleteModal').modal();		
	});
	
	$('.table #ImageButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#ImageModal #carImage').attr('src', href);
		$('#ImageModal').modal();		
	});
});