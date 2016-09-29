(function(){
	
	function Modal(){}
	
	Modal.prototype.toggle = function(){
		var toggled = document.querySelector('.modal').style.display = 'none' ? false : true;
		
		if(toggled){
			document.querySelector('.modal-overlay').style.display = 'none';
			document.querySelector('.modal').style.display = 'none';	
		}else{
			document.querySelector('.modal-overlay').style.display = 'block';
			document.querySelector('.modal').style.display = 'block';
		}
	}


	Array.from(document.querySelectorAll("form"))
		.map(function(form){
			form.addEventListener('submit', function(event){
				
				event.preventDefault();
				
				new Modal().toggle();
				
				setTimeout(function(){
					event.target.submit();
				},2000);
				
			});
		});	
	
}());