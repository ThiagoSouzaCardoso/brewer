var Brewer = Brewer || {};

Brewer.EstiloCadastroRapido = (function (){
	
	function EstiloCadastroRapido(){
		this.modal = $('#modalCadastroRapidoEstilo');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar-btn');
		this.nomeInput = $('#nomeEstilo');
		this.containerMessageError = $('.js-mensagem-cadastro-rapido-estilo');
	}

	EstiloCadastroRapido.prototype.iniciar = function(){
		this.form.on('submit',function(event){ event.preventDefault()});
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this))
		this.botaoSalvar.on('click',onBotacaoSalvarClick.bind(this));
	}
	
	function onModalShow(){
		this.nomeInput.focus();
	}
	
	function onModalClose(){
		this.nomeInput.val('');
		this.containerMessageError.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}
	
	function onBotacaoSalvarClick(){
		var nomeEstilo = this.nomeInput.val().trim();
		$.ajax({
			url : this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({nome:nomeEstilo}),
			error: onErrorSalvandoEstilo.bind(this),
			success: onEstiloSalvo.bind(this)
		});
	}
	
	function onErrorSalvandoEstilo(obj){
		var mensagemError = obj.responseText;
		this.containerMessageError.removeClass('hidden');
		this.containerMessageError.html('<span>'+ mensagemError + '</span>');
		this.form.find('.form-group').addClass('has-error');
	}
	
	function onEstiloSalvo(estilo){
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value='+estilo.codigo+'>'+estilo.nome+'</option>')
		comboEstilo.val(estilo.codigo);
		this.modal.modal('hide');
	}
	
	return EstiloCadastroRapido;
}());



$(function(){
	var estiloCadastroRapido = new Brewer.EstiloCadastroRapido();
	estiloCadastroRapido.iniciar();
});