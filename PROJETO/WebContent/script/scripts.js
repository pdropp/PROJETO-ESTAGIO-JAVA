/**
 * VALIDAÇÃO DO FORMULÁRIO DE CADASTRO
	@author PEDRO PAULO
 */

function validar() {
	let NOME = frmUsuarios.NOME.value
	let EMAIL = frmUsuarios.EMAIL.value
	let SENHA = frmUsuarios.SENHA.value
	let TELEFONE = frmUsuarios.TELEFONE.value

	if (NOME === "") {
		alert('Preencha o campo Nome')
		frmUsuarios.NOME.focus()
		return false
	} else if (EMAIL === "") {
		alert('Preencha o campo email')
		frmUsuarios.EMAIL.focus()
		return false

	} else if (SENHA === "") {
		alert('Preencha o campo senha')
		frmUsuarios.SENHA.focus()
		return false
	} else if (TELEFONE === "") {
		alert('Preencha o campo telefone')
		frmUsuarios.TELEFONE.focus()
		return false
	}else{
		document.forms["frmUsuarios"].submit()
	}
}