function disablePTable(){
	var ptable=document.getElementById("divptable");
	var ptoolbar=document.getElementById("ptoolbar");
	ptable.classList.add("no-click");
	ptoolbar.classList.add("no-click");
}
function closeCreatePopup(){
	var createpopup=document.getElementById("createpopup");
    createpopup.classList.remove("open-popup");
}
function openCreatePopup(){
	var createpopup=document.getElementById("createpopup");
    createpopup.classList.add("open-popup");
    disablePTable();
}
function closeDeletePopup(){
	var deletepopup=document.getElementById("deletepopup");
    deletepopup.classList.remove("open-popup");
}
function openDeletePopup(){
	var deletepopup=document.getElementById("deletepopup");
    deletepopup.classList.add("open-popup");
    disablePTable();
}
function closeUpdatePopUp(){
	var updatepopup=document.getElementById("updatepopup");
	updatepopup.classList.remove("open-popup");
}
function openUpdatePopUp(){
	var updatepopup=document.getElementById("updatepopup");
	updatepopup.classList.add("open-popup");
	disablePTable();
}