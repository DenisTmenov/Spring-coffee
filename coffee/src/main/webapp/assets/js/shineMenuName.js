$(function(){
	switch(menu) {
	
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contacts':
		$('#contacts').addClass('active');
		break;
	case 'Services':
		$('#services').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
});