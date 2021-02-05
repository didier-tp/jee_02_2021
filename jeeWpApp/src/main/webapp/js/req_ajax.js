function rechercherComptes(){
	console.log("rechercherComptes");
	var url ="./rest/api-bank/compte";
    makeAjaxGetRequest(url , callbackListeCompte);
}

//function qui sera appelée automatiquement quand la réponse revient
function callbackListeCompte(data){
	console.log("data (reponse)="+data);
	var listeComptes = JSON.parse(data);  //conversion de JSON vers objet javascript
	
	var zoneTBody = document.getElementById("tBody");
	
	for(let i=0;i<listeComptes.length;i++){
		var compte = listeComptes[i];
		
		var tr = document.createElement("tr");
		zoneTBody.appendChild(tr);
		tr.innerHTML="<td>"+compte.numero+"</td><td>" 
		                   + compte.label + "</td><td>"
                           +compte.solde+"</td>";
	}
}