function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	
	if (nome === "") {
		alert("Preencha o campo Nome")
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert("Preencha o campo Nome")
		frmContato.fone.focus()
	} else {
		document.forms["frmContato"].submit()
	}
}